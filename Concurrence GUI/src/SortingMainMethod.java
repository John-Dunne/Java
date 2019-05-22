import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class SortingMainMethod implements ActionListener  {
	
	
	
	private static int[] mainarraylist;
	
	public SortingMainMethod()
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
	
	class startSorts implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			bubbleSort2 bs = new bubbleSort2();
			Thread mybs = new Thread(bs);
			mybs.start();
			
		}
		
	}
	
	public static void main(String[] args) {
		SortingMainMethod s = new SortingMainMethod();
		final int REPETITIONS = 1;
		final int THREADS = 1;
		
		for(int i = 1; i <= THREADS; i++){
			bubbleSort2 bubble = new bubbleSort2();
			
			Thread dt = new Thread(bubble);
			
			
			dt.start();
			bubbleSort2 b = new bubbleSort2();
			JFrame jf = new JFrame();
			jf.setTitle("Tutorial");
			jf.setSize(400,900);
			jf.setVisible(true);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.add(b);
			
			
			
			
		}
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}

}
