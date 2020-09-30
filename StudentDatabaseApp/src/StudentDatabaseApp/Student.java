package StudentDatabaseApp;

import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int gradeYear;
	private String courses;
	private String studentId;
	private double tuitionBalance;
	private static final int COST_OF_A_COURSE = 600;
	private static int id = 1000;
	private static final String[] LEGAL_COURSES = { "History 101", "POLS 101", "Physiscs 150", "CHEM 101", "CS 146",
			"ENG 150", "BIOL 10" };

	public Student() {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter student first name");
		this.firstName = in.nextLine();

		System.out.println("Enter student last name");
		this.lastName = in.nextLine();

		System.out.println("1- Freshaman\n2- Sophomore\n3- Junior\n4- Senior\nEnter student class level: ");

		this.gradeYear = in.nextInt();

		setStudentId();

		System.out.println(this.firstName + " " + this.lastName + " " + this.gradeYear + " " + studentId);

	}

	public void setStudentId() {

		id++;

		this.studentId = gradeYear + "" + id;

	}

	public void enroll() throws CourseUnavailableException {

		do {
			System.out.println("Enter course to enroll (Q to quit)");
			Scanner in = new Scanner(System.in);

			String course = in.nextLine();
			boolean rightCourse = false;
			for (String s : LEGAL_COURSES) {

				if (s.equals(course)) {

					courses += "\n" + course;
					tuitionBalance += COST_OF_A_COURSE;
					rightCourse = true;
				}

			}
			if (!rightCourse) {
				throw new CourseUnavailableException("Course not found!!");

			}
			if (course.equals("Q")) {
				break;
			}
		} while (1 != 0);

		System.out.println("ENROLLED IN: " + courses);
		System.out.println("====================================");

	}

	public void viewBalance() {

		System.out.println("Your balance is: $" + tuitionBalance);

	}

	public void payTuition() {

		do {
			viewBalance();
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the payment Amount (0 to exit): ");
			double payment = in.nextDouble();
			if (payment != 0) {
				if (payment <= tuitionBalance && payment > 0) {

					tuitionBalance -= payment;
					System.out.println("Thank You for your payment of: $" + tuitionBalance);
					System.out.println("---------------------------------------------");
					viewBalance();
					System.out.println("---------------------------------------------");
				}

				else {
					System.out.println("Invalid payment amount");
					viewBalance();
				}
			} else {
				break;
			}
		} while (1 != 0);

	}

	public void showInfo() {
		System.out.println("Name: " + firstName + " " + lastName + "\nGrade Level: " + gradeYear + "\nCoursesEnrolled: "
				+ courses);
		viewBalance();
		System.out.println("======================================");

	}

}
