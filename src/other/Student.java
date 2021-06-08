package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Student {
	
	private int token;
	private String fname;
	private double cgpa;
	
	public Student(int id, String fname, double cgpa) {
		super();
		this.token = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getToken() {
		return token;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}

}
class Priorities {
	
	public List< Student > getStudents( List< String > events){
		
		PriorityQueue < Student > student_queue = new PriorityQueue(Comparator.comparing(Student::getCgpa).reversed()
				.thenComparing(Student::getFname).thenComparing(Student::getToken));		

		List < Student > students = new ArrayList<Student>();
		
		for ( String e : events) {
			Scanner scan = new Scanner(System.in);
			String event = scan.next();
			if ( event.equals("ENTER")) {
				String name = scan.next();
				double cgpa = scan.nextDouble();
				int token = scan.nextInt();
				
				Student student = new Student(token, name, cgpa);
				student_queue.add(student);
			}
			else if ( event.equals("SERVED")) {
				Student first = student_queue.poll();
			}
			scan.close();
		}
		Student first = student_queue.poll();
		if ( first == null) return students;
		else {
			while( first != null) {
				
				students.add(first);
				first = student_queue.poll();
			}
			return students;
		}
	}
	
	
	
}
