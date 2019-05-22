import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;

public class insertionSorter {
	private int[] a;
	private int markedPosition = -1;
	private int alreadySorted = -1;
	private int selected;
	

	

	private JComponent component;
	private static final int DELAY = 50;

	public insertionSorter(int[] anArray, JComponent aComponent) {
		a = anArray;
		
		component = aComponent;
	}
	public void sort() throws InterruptedException{
		int n = a.length;
        for (int i=1; i<n; ++i)
        {
        	
            int current = a[i];
            int j = i-1;
            while (j>=0 && a[j] > current)
            {try {
            	
            	
            selected = j;
                a[j+1] = a[j];
                
                j = j-1;
               
            a[j+1] = current;
           
            alreadySorted = i;
            }finally {
            	
            }pause(2);
        }}
		
	}
	private int maximumPosition(int from) throws InterruptedException {
		int maxPos = from;
		for(int i = from +1; i < a.length; i++) {
			
			try {
				if(a[i] < a[maxPos]) {
					maxPos = i;
				}
				markedPosition = i;
			}finally {
				
			}
			pause(2);
		}
		return maxPos;
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
