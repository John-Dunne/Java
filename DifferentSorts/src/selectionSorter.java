import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;

public class selectionSorter {
	private int[] a;
	private int markedPosition = -1;
	private int alreadySorted = -1;

	private int selected;
	private int selected1;
	private int selected2;
/**
 * This is bubblesort! Screwed up when I was messing around between my different classes. The GUI is correct though
 */
	private JComponent component;
	private static final int DELAY = 1000;

	public selectionSorter(int[] anArray, JComponent aComponent) {
		a = anArray;
		
		component = aComponent;
	}
	public void sort() throws InterruptedException{
		int n = a.length;
        for (int i = 0; i < n-1; i++)
        { ;
        try {
            int minimum = i;
            for (int j = i+1; j < n; j++)
                if (a[j] < a[minimum])
                    minimum = j;
            int temporary = a[minimum];
            a[minimum] = a[i];
            a[i] = temporary;
            
        }finally{}
        pause(2);}
	}
	public void draw(Graphics g) {
		
		try {
			int deltaX = component.getWidth()/a.length;
			for(int i = 0; i < a.length; i++) {
				
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
