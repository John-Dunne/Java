import java.awt.Graphics;

import javax.swing.JComponent;

public class selectionSortComponent extends JComponent{
	private selectionSorter sorter;

	public selectionSortComponent(int array[]) {
		int[] values =array;
		sorter = new selectionSorter(values, this);
	}
	public void paintComponent(Graphics g) {
		sorter.draw(g);
	}
	public void startAnimation2() {
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
