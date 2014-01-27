/*
 * The program will crawl a bunch of webpages and create a graph
 * structure which captures the link structure between them. 
 *
 * The program is untested, and while it may work on webpages,
 * best for now to apply it only to simple local files. 
 */

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Webcrawler {
    private static final int MAX_CRAWL_DEPTH = 8;
    public static int crawlDepth = 0;

    public static boolean canGoDeeper() { return crawlDepth < MAX_CRAWL_DEPTH; }
    
    private static final PageSet ALL_PAGES = new PageSet();
    public static Page newPage(URL url) {
	Page _ = ALL_PAGES.get(url);
	if (_ == null) {
	    _ = new Page(url);
	    ALL_PAGES.add(_);
	}
	return _;
    }

    public static void main(String[] args) {
	String url = args.length > 0 ? args[0] : "file:page1.html";

	final Page p = newPage(Utility.urlify(url));
	p.crawl(true);
	System.out.println(toDot(p));
    }

    public static String toDot(Page p) {
	PageSet visited = new PageSet();
	Queue workList = new LinkedList();

	StringBuffer result = new StringBuffer();
	result.append("digraph graphname {\n");
	result.append("\tnode [shape=note];\n");

	Page _ = p;
	while (_ != null) {
	    visited.add(_);
	    final String _Name = _.getName().replace(" ","_");
	    result.append("\t" + _Name + " [label=<<B>" + _.getName() + "</B>>]" + ";\n");
	    for (Link link : _.getLinks()) {
		if (link == null) break; 
		final Page page = link.target();
		final String toName = link.target().getName().replace(" ","_");
		result.append("\t" + _Name + " -> " + toName + " [label=<<I>" + link.name() + "</I>>]" + ";\n");
		if (visited.contains(page) == false) {
		    if (workList.contains(page) == false) {
			workList.offer(page);
		    }
		}
	    }
	    _ = (Page) workList.poll();
	}

	result.append("}");
	return result.toString();
    }
}

/**
 * Represents a crawled page. We save its name, url, and its
 * outgoing links.
 */
class Page {
    String name = "<unvisited page>"; 
    URL url; 

    int linksIndex = 0;
    Link links[] = new Link[1024];
    boolean visited = false;

    Page(URL url) {
	this.url = url;
    }
    String getName() {
	return name;
    }
    Link[] getLinks() {
	Link[] _ = new Link[linksIndex];
	System.arraycopy(links, 0, _, 0, linksIndex);
	return _;
    }
    URL getURL() {
	return url;
    }
    void linkTo(String linkName, String targetUrl) {
	links[linksIndex++] = createLink(linkName, targetUrl);
    }
    private Link createLink(String linkName, String targetUrl) {
	return new Link(Webcrawler.newPage(Utility.urlify(targetUrl)), linkName);
    }
    void crawl() { crawl(false); }
    void crawl(boolean deep) {
	if (Webcrawler.canGoDeeper() == false) return;
	Webcrawler.crawlDepth++;

	if (visited == false) {
	    String pageContents = Utility.readURL(this.url);

	    Pattern TITLE = Pattern.compile("<title>(.*?)</title>", 
					    Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
	    Pattern A_HREF = Pattern.compile("<a\\s+href=\\\"(http.*?|file.*?)\\\">(.*?)</a>", 
					     Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);

	    Matcher titleMatcher = TITLE.matcher(pageContents);
	    if (titleMatcher.find()) {
		name = titleMatcher.group(1);
	    }

	    Matcher linkMatcher = A_HREF.matcher(pageContents);
	    int index = 0;
	    while (linkMatcher.find(index)) {
		final String linkName = linkMatcher.group(2).trim();
		final String targetUrl = linkMatcher.group(1);
		linkTo(linkName, targetUrl);
		index = linkMatcher.end();
	    }
	    visited = true;
	    if (deep) {
		for (Link link : links) {
		    if (link == null) break; 
		    link.crawl(deep);
		}
	    }
	}
    }
    public boolean equals(Object other) {
	if (other instanceof Page) {
	    Page otherPage = (Page) other;
	    return url.equals(otherPage.url);
	}
	return false;
    }
    public String toString() {
	StringBuffer result = new StringBuffer();
	result.append("Page(title='");
	result.append(this.name);
	result.append("', links=[");
	if (linksIndex > 0)
	    result.append(links[0].toString());
	for (int i = 1; i<linksIndex; ++i) {
	    result.append(",");
	    result.append(links[i].toString());
	}
	result.append("])");
	return result.toString();
    }
}

/**
 * Represents a link from one page to another. 
 */
class Link {
    private final Page target;
    private final String name;
    public Link(Page _target, String _name) {
	this.target = _target;
	this.name   = _name;
    }
    Page target() {
	return this.target;
    }
    String name() {
	return this.name;
    }
    void crawl(boolean deep) {
	target.crawl(deep);
    }
    public String toString() {
	return "Link('" + this.name + "' --> '" + this.target.getURL() + "')";
    }
}

class Utility {
    public static URL urlify(String s) {
	try { return new URL(s); } catch (Exception e) {}
	return null;
    }
    public static String readURL(URL url) {
	String inputLine;
	StringBuffer result = new StringBuffer();
	BufferedReader in = null;

	try {
	    in = new BufferedReader(new InputStreamReader(url.openStream()));
	    
	    while ((inputLine = in.readLine()) != null)
		result.append(inputLine);

	} catch (FileNotFoundException fnfe) {
	    fnfe.printStackTrace(System.err);
	} catch (IOException ioe) {
	    ioe.printStackTrace(System.err);
	} finally {
	    try { if (in != null) in.close(); } catch (Exception ignore) {}
	}
	
	return result.toString();
    }
}

/**
 * Specialisation of a list. Contains only pages. 
 */
class PageSet {
    private final Set pages = new HashSet();
    void add(final Page p) { 
	pages.add(p); 
    }
    boolean contains(final Page p) {
	return pages.contains(p);
    }
    Page get(final URL url) {
	for (final Object _ : pages) {
	    Page p = (Page) _;
	    if (p.getURL().equals(url)) return p;
	}
	return null;
    }
    Iterator iterator() {
	return pages.iterator();
    }
    void crawl(boolean deep) {
	for (final Object p : pages) ((Page) p).crawl(deep);
    }
    public String toString() {
	StringBuffer result = new StringBuffer();
	result.append("PageSet({");
	final Iterator iter = this.pages.iterator();
	if (iter.hasNext()) {
	    result.append(iter.next().toString());
	}
	while (iter.hasNext()) {
	    result.append(",");
	    result.append(iter.next().toString());
	}
	result.append("})");
	return result.toString();
    }
}
