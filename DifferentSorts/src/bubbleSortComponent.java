import java.awt.Graphics;

import javax.swing.JComponent;

public class bubbleSortComponent extends JComponent {
private bubbleSorter sorter;

public bubbleSortComponent(int array[]) {
	int[] values = array;
	sorter = new bubbleSorter(values, this);
}
public void paintComponent(Graphics g) {
	sorter.draw(g);
}
public void startAnimation3() {
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
