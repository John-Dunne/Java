import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainThread {
private int[] mainarraylist;


	public static void MainThread()
	{
	   
	   mainarraylist = new int[50];
		for(int i = 0; i < 50; i++) {
			mainarraylist[i] = i+1;
		}
		mainarraylist = shufflearray(mainarraylist);
		
	}
	
	public static int[] getMainarraylist() {
		return mainarraylist;
	}

	public void setMainarraylist(int[] mainarraylist) {
		this.mainarraylist = mainarraylist;
	}

	static int[] shufflearray(int[] array) {
		int n = 50;
		Random random = new Random();
		for(int i = n-1; i > 1; i--) {
			int j = random.nextInt(i);
			int temporary = array[i];
			array[i] = array[j];
			array[j] = temporary;
			
		}
		return array;
		
	}
	public static void main(String [] args) {
		MainThread();
		JFrame frame = new JFrame();
		frame.setSize(1600, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout( new GridLayout(1, 4) );
		frame.add(panel);
		frame.setVisible(true);
		//this is where you start the threads
	}
	
}
