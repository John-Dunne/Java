/* John Dunne
 * Jd5an
 * Homework 5
 * 
 * I am going to comment at the top of the code as to the major assumptions I made. The code works and has a somewhat logical flow (minus the end with all the GPA calculations).
 * (It is also an assumption that when commenting code I can do it at the top in a block of text (I think its easier to read))
 * 
 * Assumptions were made. The ability to remove a single course was implemented in the GUI.
 * The caveat is that you can only remove the bottom course from the list. I spent hours trying to implement a Jtable
 * but I ran into problems when trying to manipulate the DefaultTable model for the jtable so adding and removing rows became just too difficult.
 * THUS you can remove a single course, you just have less control of which one.
 * 
 * The 15 blank course blocks I lumped into a special course of its own. I just made a super course of 15 credits.
 * The purpose of the 15 blank courses is to see what you would need GPA wise to reach a target GPA. It also gives you a general idea
 * of what your goals for an average semester should be grade wise.
 * 
 *  I also allowed the blank GPAs to be given values less than 0 if for some reason you wanted a target GPA lower than your current GPA.
 *  Though this is not possible I think it gives the individual a sense of "weight" for their GPA.
 *  
 *  I also made the grades a combobox with credit hours ranging from 1 to 4 credit hours. This seemed like a reasonable range that encompasses virtually all classes.
 *  I have never heard of a class more than 4 credits at UVa. If there is a course with more credit hours than 4, the individual can just add another course with the same name
 *  since my course list does not discriminate against courses with the same name for exactly this reason.
 *  
 *  There is also minimal exception handling, we just covered it in lecture so I did not implement any. I did try to make it possible in a number of the inputs to prevent users from putting in certain inputs.
 *  
 */

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.JList;


public class GPACal {

	private JFrame Overallframe;
	private CourseTable table;
	private JTextField CourseNametextField;
	private JTextField TargetGPAtextField;
	private JTextField CurrentGPADisplaytextField;
	private JTextField RecommendationtextField;
	
	private String credithoursextract;
	private String Gradeextract;
	private JViewport Courselist;
	private DefaultListModel listModel;
	private JList list;
	private ArrayList<Double> gpaArray;
	private ArrayList<Double> creditactualArray;
	private ArrayList<Double> creditpotentialArray;
	private String currentgpa;
	private ArrayList<String> hiddencoursearray;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GPACal window = new GPACal();
					window.Overallframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public GPACal() {
		initialize();
		
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Overallframe = new JFrame();
		Overallframe.setBounds(100, 100, 702, 576);
		Overallframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new CourseTable();
		Overallframe.getContentPane().add(table, BorderLayout.CENTER);
		Overallframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course List");
		lblNewLabel.setBounds(155, 25, 99, 20);
		Overallframe.getContentPane().add(lblNewLabel);
		
		Map<String, String> StringGPADict = new TreeMap<String, String>();
		StringGPADict.put("A", "4.0");
		StringGPADict.put("A-", "3.7");
		StringGPADict.put("B+", "3.3");
		StringGPADict.put("B", "3.0");
		StringGPADict.put("B-", "2.7");
		StringGPADict.put("C+", "2.3");
		StringGPADict.put("C", "2.0");
		StringGPADict.put("C-", "1.7");
		StringGPADict.put("D+", "1.3");
		StringGPADict.put("D", "1.0");
		StringGPADict.put("D-", "0.7");
		StringGPADict.put("F", "0.0");
		StringGPADict.put("N/A", "N/A");
		
		gpaArray = new ArrayList<Double>();
		creditpotentialArray = new ArrayList<Double>();
		creditactualArray = new ArrayList<Double>();
		hiddencoursearray = new ArrayList<String>();
		
		
	
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CourseString = "";
				CourseString = CourseNametextField.getText();
				if(CourseString.length() == 0) {
					CourseString = "(NO COURSE NAME)";
				}else {
					CourseString = CourseNametextField.getText();
				}
				CourseString = CourseString + " : "+Gradeextract;
				CourseString = CourseString+" : "+credithoursextract;
				CourseString = CourseString+" : "+StringGPADict.get(Gradeextract);
				String Stringgpa = StringGPADict.get(Gradeextract);
				if(Stringgpa.equals("N/A")) {
					creditpotentialArray.add(Double.parseDouble(credithoursextract));
					String newCourseString = CourseNametextField.getText()+" : "+Gradeextract+" : "+ credithoursextract+" : ";
					hiddencoursearray.add(newCourseString);
					
					listModel.addElement(CourseString);
				}else {
					double doublegpa = Double.parseDouble(Stringgpa);
					gpaArray.add(doublegpa);
					creditactualArray.add(Double.parseDouble(credithoursextract));
					listModel.addElement(CourseString);
					hiddencoursearray.add(CourseString);
				}
				
				
				
			}
		});
		
		
		btnAddCourse.setBounds(377, 233, 115, 29);
		Overallframe.getContentPane().add(btnAddCourse);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		
		
		
		btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(listModel.size() > 1) {
				listModel.remove(listModel.size()-1);
				gpaArray.remove(gpaArray.size()-1);
				hiddencoursearray.remove(hiddencoursearray.size()-1);
			}
			}});
		
		
		
		btnRemoveCourse.setBounds(91, 429, 198, 29);
		Overallframe.getContentPane().add(btnRemoveCourse);
		
		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setBounds(377, 83, 107, 34);
		Overallframe.getContentPane().add(lblCourseName);
		
		JLabel label = new JLabel("Grade: ");
		label.setBounds(377, 133, 107, 34);
		Overallframe.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Credit Hours: ");
		label_1.setBounds(377, 183, 107, 34);
		Overallframe.getContentPane().add(label_1);
		
		CourseNametextField = new JTextField();
		CourseNametextField.setBounds(503, 87, 146, 26);
		Overallframe.getContentPane().add(CourseNametextField);
		CourseNametextField.setColumns(10);
		
		String[] gradecombos = {"N/A", "A","A-","B+","B","B-","C+","C","C-","D+","D","D-"};
		JComboBox GradecomboBox = new JComboBox(gradecombos);
		GradecomboBox.setBounds(444, 136, 69, 29);
		GradecomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox GCB = (JComboBox)e.getSource();
				Gradeextract = (String)GCB.getSelectedItem();
			}
		});
		Overallframe.getContentPane().add(GradecomboBox);
		
		
		
		String[] credithourscombo = {"1","2","3","4"};
		JComboBox CreditHourscomboBox = new JComboBox(credithourscombo);
		CreditHourscomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox CH = (JComboBox)e.getSource();
				credithoursextract = (String)CH.getSelectedItem();
				
			}
		});
		CreditHourscomboBox.setBounds(482, 183, 78, 32);
		Overallframe.getContentPane().add(CreditHourscomboBox);
		
		JButton btnAutoPopulateSchedule = new JButton("Auto Populate Schedule");
		btnAutoPopulateSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String blankCredits = "EMPTY : EMPTY : 15 : N/A";
				listModel.addElement(blankCredits);
				creditpotentialArray.add(15.0);
				String modblankcredits = "EMPTY : EMPTY : 15 : ";
				hiddencoursearray.add(modblankcredits);
				}});
		
		btnAutoPopulateSchedule.setBounds(377, 278, 225, 29);
		Overallframe.getContentPane().add(btnAutoPopulateSchedule);
		
		JLabel lblCourseEditor = new JLabel("Course Editor");
		lblCourseEditor.setBounds(442, 51, 160, 20);
		Overallframe.getContentPane().add(lblCourseEditor);
		
		JButton removeallbutton = new JButton("Remove All Courses");
		removeallbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String element1;
				element1 = "CourseName:Grade:CreditHours:GPA";
				listModel.removeAllElements();
				gpaArray.clear();
				listModel.addElement(element1);
				hiddencoursearray.clear();
				}});
		
		removeallbutton.setBounds(91, 474, 200, 29);
		Overallframe.getContentPane().add(removeallbutton);
		
		JLabel lblTargetGpa = new JLabel("Target GPA: ");
		lblTargetGpa.setBounds(377, 323, 105, 20);
		Overallframe.getContentPane().add(lblTargetGpa);
		
		TargetGPAtextField = new JTextField();
		TargetGPAtextField.setBounds(482, 320, 146, 26);
		Overallframe.getContentPane().add(TargetGPAtextField);
		TargetGPAtextField.setColumns(10);
		
		JLabel label_2 = new JLabel("Current GPA: ");
		label_2.setBounds(377, 359, 105, 20);
		Overallframe.getContentPane().add(label_2);
		
		CurrentGPADisplaytextField = new JTextField();
		CurrentGPADisplaytextField.setBounds(482, 356, 146, 26);
		CurrentGPADisplaytextField.setEditable(false);
		Overallframe.getContentPane().add(CurrentGPADisplaytextField);
		CurrentGPADisplaytextField.setColumns(10);
		
		JLabel RecommendationLabel = new JLabel("Recommendation:  ");
		RecommendationLabel.setBounds(346, 433, 146, 20);
		Overallframe.getContentPane().add(RecommendationLabel);
		
		RecommendationtextField = new JTextField();
		RecommendationtextField.setBounds(480, 430, 185, 26);
		RecommendationtextField.setEditable(false);
		Overallframe.getContentPane().add(RecommendationtextField);
		RecommendationtextField.setColumns(10);
		
		String element1;
		element1 = "CourseName:Grade:CreditHours:GPA";
		listModel = new DefaultListModel();
		listModel.addElement(element1);
		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setSelectedIndex(0);
		list.setVisibleRowCount(-1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 61, 321, 360);
		
		Overallframe.getContentPane().add(scrollPane);
		scrollPane.setViewport(Courselist);
		scrollPane.setViewportView(list);
		
		currentgpa = "0.0";
		
		JButton btnRefreshGpa = new JButton("Refresh GPA");
		btnRefreshGpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double totalgpa = 0.0;
				double totalcoursestaken = 0.0;
				double avgneededgpa = 0.0;
				double targetgpaDouble = 0.0;
				ArrayList<String> hiddencoursearrayemptied = new ArrayList<String>();
				String targetgpa = "";
				
				for(int i = 0; i < gpaArray.size(); i++) {
					totalgpa = gpaArray.get(i)*creditactualArray.get(i)+totalgpa;
					totalcoursestaken =  creditactualArray.get(i) + totalcoursestaken;
				}
				double nonroundedgpa = (totalgpa/totalcoursestaken);
				CurrentGPADisplaytextField.setText(String.valueOf(nonroundedgpa));
				targetgpa = TargetGPAtextField.getText();
				targetgpaDouble = Double.parseDouble(targetgpa);
				
				
				if(targetgpa.isEmpty() == false) {
					
					double coursesum = 0.0;
					double ungradedcoursesum = 0.0;
					for(int i = 0; i < creditactualArray.size(); i++) {
						coursesum = coursesum + creditactualArray.get(i);
					}
					for(int i = 0; i < creditpotentialArray.size(); i++) {
						ungradedcoursesum = ungradedcoursesum+creditpotentialArray.get(i);
					}
					avgneededgpa = ((targetgpaDouble*(coursesum+ungradedcoursesum))-totalgpa)/ungradedcoursesum;
					
					
					for(int i = 0; i < hiddencoursearray.size(); i++) {
						if(hiddencoursearray.get(i).trim().endsWith(":")) {
							hiddencoursearrayemptied.add(hiddencoursearray.get(i)+String.valueOf(avgneededgpa));
						}else {
							hiddencoursearrayemptied.add(hiddencoursearray.get(i));
						}
						
					}
					String element1;
					element1 = "CourseName:Grade:CreditHours:GPA";
					listModel.removeAllElements();
					listModel.addElement(element1);
					for(int i =0;i<hiddencoursearrayemptied.size(); i++) {
						listModel.addElement(hiddencoursearrayemptied.get(i));
						if(avgneededgpa > 4.0) {
							RecommendationtextField.setText("You may want to add more credits.");
						}else if(avgneededgpa < 2.0) {
							RecommendationtextField.setText("You could take less credits.");
						}else {
							RecommendationtextField.setText("");
						}
					}
					
					}
			
		}});
		btnRefreshGpa.setBounds(482, 395, 146, 29);
		Overallframe.getContentPane().add(btnRefreshGpa);
		
		
		
	}
}
