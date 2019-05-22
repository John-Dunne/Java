import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;
/** 
 * 
 * @author Student
 *Messed up my algorithms when I was rearranging the heirarchy. This is actually the selection sort!
 */
public class bubbleSorter {
private int[] a;
private int selected;


private JComponent component;
private static final int DELAY = 50;

public bubbleSorter(int[] anArray, JComponent aComponent) {
	a = anArray;
	
	component = aComponent;
}
public void sort() throws InterruptedException{
	int n = a.length;
for (int i = 0; i < n-1; i++)
		
        for (int j = 0; j < n-i-1; j++)
        	
            if (a[j] > a[j+1])
            {try {
            	
                int temporary = a[j];
                
            
                a[j] = a[j+1];
                
                selected = j+1;
                a[j+1] = temporary;}finally {
                }
            pause(2);
}
}
public void draw(Graphics g) {
	
	try {
		int deltaX = component.getWidth()/a.length;
		for(int i = 0; i < a.length; i++) {
			if(i == selected) {
				g.setColor(Color.RED);
			}else {
				g.setColor(Color.BLACK);
			}
			g.drawLine(i*deltaX, 0, i*deltaX, a[i]);
			
		}
	}finally {
		
	}
}
public void pause(int steps) throws InterruptedException {
	component.repaint();
	Thread.sleep(steps*DELAY);
}
}
