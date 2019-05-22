import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DrawShapes extends JPanel{
	private int[] arraylist;
	public ArrayList<Shape> shapeList = new ArrayList<Shape>();
	static int[] shufflearray(int[] array) {
		int n = 50;
		Random random = new Random();
		for(int i = n-1; i > 0; i--) {
			int j = random.nextInt(i);
			int temporary = array[i];
			array[i] = array[j];
			array[j] = temporary;
			
		}
		return array;
	}
	
    public DrawShapes(String title) {
        

        this.setLayout(new BorderLayout());
        
        this.setSize(775, 250);
       

        this.initComponents();
    }

    private void initComponents() {
    	for(int i = 0; i < 50; i ++) {
    		shapeList.add(new RectangleShapes(15*i, 90, 10, 90));
    		
    	}
        
    }

    @Override
    public void paint(Graphics g) {
        for (Shape s : shapeList) {
            s.draw(g);
        }
    }

    public static void main(String args[]) {
    	int[] inputarray = new int[50];
		for(int i = 0; i < 50; i++) {
			inputarray[i] = i;
		}
		inputarray = shufflearray(inputarray);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DrawShapes d = new DrawShapes("Drawing program");
                d.setVisible(true);
            }
        });
    }
}
