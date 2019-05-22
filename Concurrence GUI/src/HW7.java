import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HW7 {

	private JFrame frame;
	private static int[] mainarraylist;
	
	public static void SortingMainMethod1()
	{
	   
	   mainarraylist = new int[50];
		for(int i = 0; i < 50; i++) {
			mainarraylist[i] = i+1;
		}
		int n = 50;
		Random random = new Random();
		for(int i = n-1; i > 1; i--) {
			int j = random.nextInt(i);
			int temporary = mainarraylist[i];
			mainarraylist[i] = mainarraylist[j];
			mainarraylist[j] = temporary;
			
		}
		
		
		
	}
	
	public static int[] getMainarraylist() {
		return mainarraylist;
	}

	public void setMainarraylist(int[] mainarraylist) {
		this.mainarraylist = mainarraylist;
	}

	public ArrayList<Rectangle> createShapelist() {
		ArrayList<Rectangle> shapeList = new ArrayList<Rectangle>();

		

		 int BOX_Y = 15;
		final int BOX_WIDTH = 5;
		int BOX_HEIGHT = 10;
		int BOX_X = 50;
		Rectangle box;
		
		int[] arraylist = getMainarraylist();
		
		for(int i = 0; i < 50; i++) {
			int id = arraylist[i];
			
			box = new Rectangle(BOX_X, BOX_Y + i*15, BOX_WIDTH*id, BOX_HEIGHT);
			shapeList.add(box);
		}
		return shapeList;
	}
	class bubbleSort extends JPanel implements Runnable{
		ArrayList<Rectangle> shapeList = createShapelist();
		private static final int DELAY = 1000;
		
		
		
		public void paintComponent(Graphics g) {
			boolean paintcomponent = true;
			if(paintcomponent) {
				
			
			for (Rectangle s : shapeList) {
				Graphics2D g2 = (Graphics2D) g;
				g2.drawRect((int)s.getX(), (int)s.getY(), (int)s.getWidth(), (int)s.getHeight());
				
			}}}
			
			@Override
			public void run(){
				int[] arraylist = mainarraylist;
				int n = arraylist.length;
				System.out.println("1");
				
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
			                System.out.println(i + "pass");
			                
			                
			                try {
								Thread.sleep(DELAY);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			               
			            }
				
				repaint();
			}

			
			
			
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SortingMainMethod1();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HW7 window = new HW7();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
class startSortingmethods implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		bubbleSort bs = new bubbleSort();
		Thread mybs = new Thread(bs);
		mybs.start();
		
		
		
	}
	
}
	/**
	 * Create the application.
	 */
	public HW7() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		bubbleSort b = new bubbleSort();
		JFrame jf = new JFrame();
		jf.setTitle("Tutorial");
		jf.setSize(400,900);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(b);
		
		
	}

}
