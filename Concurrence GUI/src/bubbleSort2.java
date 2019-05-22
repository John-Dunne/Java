import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class bubbleSort2 extends JPanel implements Runnable, ActionListener {
public ArrayList<Rectangle> shapeList = new ArrayList<Rectangle>();

private static final int DELAY = 1000;

private static final int BOX_Y = 15;
private static final int BOX_WIDTH = 5;
private int BOX_HEIGHT = 10;
private int BOX_X = 50;

private Rectangle box;




public bubbleSort2()  {
	int[] arraylist = SortingMainMethod.getMainarraylist();
	
	
	
	for(int i = 0; i < 50; i++) {
		int id = arraylist[i];
		
		box = new Rectangle(BOX_X, BOX_Y + i*15, BOX_WIDTH*id, BOX_HEIGHT);
		shapeList.add(box);
	}
	
	
}

public void paintComponent(Graphics g) {
	for (Rectangle s : shapeList) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawRect((int)s.getX(), (int)s.getY(), (int)s.getWidth(), (int)s.getHeight());
		removeAll();
		
		repaint();
	}
	
		
}

public void run() {
	int[] arraylist = SortingMainMethod.getMainarraylist();
	int n = arraylist.length;
	
	
	for (int i = 0; i < n-1; i++)
		
        for (int j = 0; j < n-i-1; j++)
        	
            if (arraylist[j] > arraylist[j+1])
            {
                int temporary = arraylist[j];
                Rectangle t = shapeList.get(j);
            
                arraylist[j] = arraylist[j+1];
                shapeList.set(j, shapeList.get(j+1));
                
                arraylist[j+1] = temporary;
                shapeList.set(j+1, t);
                
            	repaint();
                try {
					Thread.sleep(DELAY);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               
            }
	
            }

public ArrayList<Rectangle> getShapeList() {
	return shapeList;
}

public void setShapeList(ArrayList<Rectangle> shapeList) {
	this.shapeList = shapeList;
}


	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		run();
		
		
	}
	

}
