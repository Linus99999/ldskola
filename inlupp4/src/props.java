import java.io.*;
import java.util.*;
public class props {
public static void main(String[] args) throws IOException {
	Properties p = new Properties();
	Scanner sc = new Scanner(System.in);
	System.out.print("Sätt första vägen: ");
	p.setProperty("r0", sc.nextLine());
	System.out.print("Sätt vägen som går rakt fram: ");
	p.setProperty("r1", sc.nextLine());
	System.out.print("Sätt vägen som svänger vänster: ");
	p.setProperty("r2", sc.nextLine());
	System.out.print("Sätt perioden för trafikljuset: ");
	p.setProperty("period", sc.nextLine());
	System.out.print("Sätt ankomstintensiteten: ");
	p.setProperty("intense", sc.nextLine());
	System.out.print("Sätt hur länge ljus 1 ska vara grönt: ");
	p.setProperty("green1", sc.nextLine());
	System.out.print("Sätt hur länge ljus 2 ska vara grönt: ");
	p.setProperty("green2", sc.nextLine());
	System.out.print("Sätt namn och sökväg till filen: ");
	OutputStream d = new FileOutputStream(sc.nextLine());
	p.store(d, "Properties file for trafficsimulation");
}

}
