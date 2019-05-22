import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class bubbleSortRunnable extends JPanel implements Runnable, ActionListener {
	Timer tm = new Timer(5, this);
	
	public ArrayList<Shape> shapeList = new ArrayList<Shape>();

	private int[] arraylist;
	public bubbleSortRunnable(int[] anArrayList)
	{
	   arraylist = anArrayList;
	   
	}
	private void initComponents() {
    	for(int i = 0; i < 50; i ++) {
    		shapeList.add(new RectangleShapes(15*i, 90, 10, 90));
    		
    	}}
	@Override
    public void paint(Graphics g) {
		
        for (Shape s : shapeList) {
        	super.paintComponent(g);
        	g.setColor(Color.RED);
        	
            s.draw(g);
            
        }
        tm.start();
    }
	@Override
	public void run() {
		int n = arraylist.length;
		
		for (int i = 0; i < n-1; i++)
        	
            for (int j = 0; j < n-i-1; j++)
                if (arraylist[j] > arraylist[j+1])
                {
                    int temporary = arraylist[j];
                    arraylist[j] = arraylist[j+1];
                    arraylist[j+1] = temporary;
                }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
public static void main(String[] args) {
	int[] inputarray = new int[50];
	for(int i = 0; i < 50; i++) {
		inputarray[i] = i;
	}
	bubbleSort2 b = bubbleSort2();
	JFrame jf = new JFrame();
	jf.setTitle("bubbleSort");
	jf.setSize(600, 400);
	jf.setVisible(true);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.add(b);
	
}
}
