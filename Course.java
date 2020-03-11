package hw4;

import java.util.ArrayList;

public class Course{
	private int ID;
	private String title;
	private String location;
	private int instructor;
	private ArrayList<Student> students = new ArrayList<>();
	
	public Course(int iD, String title, int instructor, String location) {
		super();
		ID = iD;
		this.title = title;
		this.location = location;
		this.instructor = instructor;
	}
	
	public Course() {
		ID = 0;
		this.title = null;
		this.location = null;
		this.instructor = 0;
	}
	
	@Override
	public String toString() {
		return "Course [ID=" + ID + ", title=" + title + ", location=" + location + ", instructor=" + instructor + "]";
	}

	public ArrayList<Student> getRoster(){
		return students;
	}
	
	public void addStudent(Student x) {
//		int exists = 0;
		for(Student i : students) {
			if(i.getID() == x.getID()) {
//				System.out.println("IM HERE");
				return;
			}
		}
//		System.out.println("**** BEFORE " + getClassSize() + " ****");
		students.add(x);
//		System.out.println("**** AFTER " + getClassSize() + " ****");
		
	}
	
	public int getClassSize() {
		return students.size();
	}
	
	public double getAverage() {
		if(students.size() == 0) {
			System.out.println("****" + students.size() + "****");
			return 0.0;
		}
		
		double average = 0.0;
		for(Student x : students) {
			average += x.getGrade(getID());
			System.out.println("****" + x.getName() + " " + x.getID() + "****" + x.getGrade(getID()));
		}
		System.out.println("**** " + average + " **** " + students.size() + "****");
		average = average/students.size();
		System.out.println("**** " + average + " **** ");
		
		return average;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getInstructor() {
		return instructor;
	}

	public void setInstructor(int instructor) {
		this.instructor = instructor;
	}

	public void updateLocation(String location) {
		this.location = location;
	}
	
	public void clearClass() {
		students.clear();
	}
	
	public void setGrade(int studID, double grade) {
		for(Student x : students) {
			if(x.getID() == studID) {
				x.setGrade(grade, getID());
			}
		}
	}

	public void removeStudent(int studentID) {
		for(int i = 0; i < students.size(); i++) {
			Student x = students.get(i);
			if(x.getID() == studentID) {
				students.remove(i);
			}
		}
	}
	
	public void clearStudent(int studentID) {
		for(int i = 0; i < students.size(); i ++) {
			Student x = students.get(i);
			if(x.getID() == studentID) {
				students.remove(i);
			}
		}
	}
	
	
}
