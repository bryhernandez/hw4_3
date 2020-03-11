package hw4;

import java.util.ArrayList;
import java.util.HashMap;

public class Student{
	
	private String name;
	private int ID;
	private ArrayList<Course> courses = new ArrayList<>();
	private boolean isGraduate;
	private HashMap<Integer, Double> grades = new HashMap<>();
	
	public Student(int ID, String name) {
		this.name = name;
		this.ID = ID;
		isGraduate = false;
	}
	
	public Student getStudent() {
		Student x = new Student(getID(), getName());
		return x;
	}
	

	public void clearTranscript() {
		for(int i = 0; i < courses.size(); i++) {
			Course x = courses.get(i);
			x.clearStudent(getID());
		}
		courses.clear();
		
	}
	
	public void clearGrades() {
		grades.clear();
	}
	
	public double getGrade(int courseID) {
		for(int i = 0; i < grades.size(); i++) {
			if(grades.containsKey(courseID)) {
				return grades.get(courseID);
			}
		}
		
		return 0.0;
	}
	
	public void setGrade(double grade, int course) {
		for(Course x : courses) {
			if(x.getID() == course) {
				grades.put(x.getID(), grade);
			}
		}
	}
	
	public void addClass(Course course, double grade) {
		int exists = 0;
		for(Course x : courses) {
			if(x.getID() == course.getID()) {
				exists++;
			}
		}
		
		if(exists == 0) {
			courses.add(course);
			grades.put(course.getID(), grade);
//			course.addStudent(getStudent());
		}
		
		
	}
	
	public String getLetterGrade(double grade) {
		if(grade <= 59 || grade >= 0)
			return "F";
		if(grade >= 60 || grade <= 69.99)
			return "D";
		if(grade >= 70 || grade <= 79.99)
			return "C";
		if(grade >= 80 || grade <= 89.99)
			return "B";
		if(grade >= 90 || grade < 100) 
			return "A";
		
		return null;
	}
	
	public double getGradePoints(double grade) {
		if(grade <= 59 || grade >= 0)
			return 0.0;
		if(grade >= 60 || grade <= 69.99)
			return 1.0;
		if(grade >= 70 || grade <= 79.99)
			return 2.0;
		if(grade >= 80 || grade <= 89.99)
			return 3.0;
		if(grade >= 90 || grade < 100) 
			return 4.0;
		
		return 0.0;
	}
	

	public Course getClass(int index) {
		return courses.get(index);
	}
	
	public void removeClass(int courseId) {
		for(int i = 0; i < courses.size(); i ++) {
			if(courses.get(i).getID() == courseId) {
				courses.remove(i); 
			}
		}
	}
	
	public double getGPA() {
		if(grades.size() == 0) {
			System.out.println("Im Here");
			return 0.0;
		}
		
		double gpa = 0.0;
		int size = grades.size();
		
//		System.out.println("Course size: " + courses.size() + "\nGrade size: " + grades.size());
		for(int i = 0; i < courses.size(); i ++) {
			Course x = courses.get(i);
//			System.out.println(" 1 ****" + grades.get(x.getID()) + "****");
			if(grades.get(x.getID()) == 0.0){
				size--;
			}
			gpa += grades.get(x.getID());
		}
//		System.out.println("\n****" + gpa + " / " + grades.size() + "****");
		
		if(gpa == 0.0) {
			return 0.0;
		}
		
//		System.out.println("****" + gpa + "****" + grades.size() );
		gpa = gpa/size;
		
		return gpa;
	}
	
	public ArrayList<Course> getTranscript() {
		return courses;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public boolean isGraduate() {
		return isGraduate;
	}

	public void setGraduate(boolean isGraduate) {
		if(isGraduate) {
			clearTranscript();
		}
		this.isGraduate = isGraduate;
	}
	
	public boolean hasClass(int courseId) {
		for(Course x : courses) {
			if(x.getID() == courseId) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		if(!isGraduate) {
			String str = "";
			
			str += "Student Number: " + getID() + "\n";
			str += "Name: " + getName() + "\n";
			str += "Courses Enrolled: \n";
			
			int i = 0;
			for(Course x : courses) {
				str += x.getID() + ": " + grades.get(i) + "(" + getLetterGrade(grades.get(i)) + ")\n";
			}
			
			str += "Course Average: " + getGPA();
			
			return str;
		}
		
		return "Student Number: " + getID() + "\nNo student information.";
	}
	
	
}
