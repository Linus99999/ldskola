import java.io.*;
import java.util.*;
public class props {
public static void main(String[] args) throws IOException {
	Properties p = new Properties();
	p.setProperty("r0", "25");
	p.setProperty("r1", "25");
	p.setProperty("r2", "25");
	p.setProperty("period", "20");
	p.setProperty("intense", "2");
	p.setProperty("green1", "10");
	p.setProperty("green2", "15");
	OutputStream d = new FileOutputStream("prop.txt");
	p.store(d, "props");
	System.out.print(p.getProperty("r1"));
	System.out.print(p);
}

}
