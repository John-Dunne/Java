import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class OverallInterface {
	
		private static void createGUI() {
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(600, 600);
			frame.setLayout(new GridLayout(2,2));
			//Fills rows first
			frame.add(new CourseTable());
			//frame.add(new CourseSubmission());
			
			
			
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
		public static void main(String[] args) {
			createGUI();
		}
	
}
