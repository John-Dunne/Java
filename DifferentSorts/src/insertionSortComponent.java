import java.awt.Graphics;

import javax.swing.JComponent;

public class insertionSortComponent extends JComponent {
	private insertionSorter sorter;

	public insertionSortComponent(int [] array) {
		int[] values = array;
		sorter = new insertionSorter(values, this);
	}
	public void paintComponent(Graphics g) {
		sorter.draw(g);
	}
	public void startAnimation1() {
		class AnimationRunnable implements Runnable{
			public void run() {
				try {
					sorter.sort();
				}catch(InterruptedException exception) {
					
				}
			}
		}
		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
	}

}
