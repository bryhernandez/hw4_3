package hw4;


public class Enrollment{
	
	private String grade;
	private Course course;
	private Student student;
	
	public Enrollment(String grade, Course course, Student student) {
		super();
		this.grade = grade;
		this.course = course;
		this.student = student;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
