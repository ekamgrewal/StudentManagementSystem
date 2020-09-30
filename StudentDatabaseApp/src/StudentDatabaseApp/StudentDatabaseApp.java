package StudentDatabaseApp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) throws CourseUnavailableException {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter the no. of Students: ");
		int numberOfStudents = in.nextInt();
		Student[] students = new Student[numberOfStudents];
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student();
			students[i].enroll();
			students[i].payTuition();
			students[i].showInfo();

		}

	}

}
