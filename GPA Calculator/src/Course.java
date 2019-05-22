
public class Course {
	private String CreditHours;
	private String Grade;
	private String CourseName;
	private String[] courseArray = new String[3];
	
	public String getCreditHours() {
		return CreditHours;
	}
	public void setCreditHours(String creditHours) {
		CreditHours = creditHours;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public Course(String CreditHours) {
		this.CreditHours = CreditHours;
		this.setGrade(null);
		this.setCourseName(null);
	}
	public Course(String CourseName, String CreditHours, String Grade) {
		this.CourseName = CourseName;
		this.CreditHours = CreditHours;
		this.Grade = Grade;
	}
	
	public Course(String CreditHours, String Grade) {
		this.CreditHours = CreditHours;
		this.Grade = Grade;
		this.setCourseName(null);
	}
	
	@Override
	public String toString() {
		return "Course [CreditHours=" + CreditHours + ", Grade=" + Grade + ", CourseName=" + CourseName + "]";
	}
	public boolean equals(Object o) {
		if(o instanceof Course) {
			Course c2 = (Course) o;
			return (this.CourseName.equals(c2.getCourseName()) && this.CreditHours == c2.getCreditHours()) && this.getGrade().equals(c2.getGrade());
		}
		else {
			return false;
		}
		
	}
	
}
