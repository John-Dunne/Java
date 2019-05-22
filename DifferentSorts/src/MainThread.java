import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainThread {
private static int[] mainarraylist;

public static int[] getmainarraylist() {
	return mainarraylist;
}

public static void setmainarraylist(int[] mainarraylist) {
	MainThread.mainarraylist = mainarraylist;
}

	public static int[] MainThread()
	{
	   
	   mainarraylist = new int[50];
		for(int i = 0; i < 50; i++) {
			mainarraylist[i] = i+1;
		}
		int[] array1 = shufflearray(mainarraylist);
		return array1;
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
	private static int[] deepcopymethod(int[] array) {
		int[] dp1 = new int[50];
		for(int i = 0; i < array.length; i++) {
			dp1[i] = array[i];
		}
		return dp1;
	}
	public static void main(String [] args) {
		int[] array1 = MainThread();
		
		
		JFrame frame4 = new JFrame();
		
		JLabel bubblelabelselection = new JLabel("BubbleSort");
		JLabel insertionlabelselection = new JLabel("InsertionSort");
		JLabel selectionlabelselection = new JLabel("SelectionSort");
		
		
		frame4.setSize(400,400);
		
		
		
		
		frame4.setLayout(new GridLayout(2, 3));
		
		
		
		
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final bubbleSortComponent component1 = new bubbleSortComponent(deepcopymethod(array1));
		final insertionSortComponent component2 = new insertionSortComponent(deepcopymethod(array1));
		final selectionSortComponent component3 = new selectionSortComponent(deepcopymethod(array1));
		
		
		frame4.add(bubblelabelselection);
		frame4.add(insertionlabelselection );
		frame4.add(selectionlabelselection);
		
		frame4.add(component3, BorderLayout.CENTER);
		frame4.add(component2, BorderLayout.CENTER);
		frame4.add(component1, BorderLayout.CENTER);
		
		frame4.setVisible(true);
		
		
		
		component2.startAnimation1();
		component3.startAnimation2();
		component1.startAnimation3();
	}
	
}
