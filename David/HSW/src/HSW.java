import java.awt.Graphics;

public class HSW extends java.applet.Applet
{

    public void paint(Graphics g)
    {
        int x1 = 0;
        int y1 = 0;
        int x2 = 10;
        int y2 = 10;
        
        while (x2 <= 30){
        	
        g.drawRect(x1,y1,x2,y2);
        x1 = x1 + 20;
        
        x2 = x2 + 10;
        
        
        
       
        }
    }
}