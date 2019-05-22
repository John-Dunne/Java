import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CourseSubmission extends JFrame {
	
	private JLabel instructions;
	private JTextField input1;
	private JButton Submit;
	private JLabel instructions2;
	private JTextField input2;
	private JLabel instructions3;
	private JComboBox letterGradeBox;
	private JComboBox creditHourBox;
	
	
	public CourseSubmission() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setLayout(new GridLayout(4,3));
		
		instructions = new JLabel("Course Name: ");
		input1 = new JTextField(10);
		Submit = new JButton("Submit");
		
		instructions2 = new JLabel("Grade: ");
		String[] creditHoursselect = {"1","2","3","4"};
		creditHourBox = new JComboBox(creditHoursselect);
		instructions3 = new JLabel("Credit Hours: ");
		String[] letterGrades = {"N/A","A","A-","B+","B","B-","C+","C","C-","D+","D","D-","F"};
		letterGradeBox = new JComboBox(letterGrades);
		
		
		Submit.addActionListener(new TranslateListener());
		this.add(instructions);
		this.add(input1);
		
		this.add(instructions2);
		this.add(letterGradeBox);
		this.add(instructions3);
		this.add(creditHourBox);
		this.add(Submit);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	private class TranslateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String word = input1.getText();
			input2.setText(toPigLatin(word));
			
		}
		public String toPigLatin(String word) {
			int vowelIndex = 0;
			for(int i = 0; i<word.length();i++) {
				if("aeiouAEIOU".contains(word.substring(i, i+1))) {
					vowelIndex = i;
					break;
				}
			}
			//check if it begins with a vowel
			if(vowelIndex == 0) {
				return word+"ay";
			}else {
				return word.substring(vowelIndex)+word.substring(0, vowelIndex)+"ay";
			}
		}
	}
	

	public static void main(String[] args) {
		new CourseSubmission();

	}

}
