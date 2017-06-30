/*
 * This example shows a common mistake, i.e. leaking a mutable member variable
 * by means of a getter.
 */

// This class violates point 4 from
// https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html

import java.util.*;

final class Student {

	private List<Integer> marks;

	public Student(int... marks) {

		this.marks = new ArrayList<>();

		for (int mark : marks) {
			this.marks.add(mark);
		}
	}

	public List<Integer> getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return "Student: [" + marks.toString() + "]";
	}
}

class StudentDriver {
	public static void main(String[] args) {
		Student s = new Student(98, 94, 99);

		System.out.println(s);

		// The getter returns a reference of the marks ArrayList
		// Now leakedMarks points to the same instance as the member variable
		// And you are able to modify the student's marks!
		// This happens only when you return a reference of a mutable member variable
		// And so this problem does not occur for Strings, Integers, etc
		List<Integer> leakedMarks = s.getMarks();
		leakedMarks.add(10);    // WHAT? NOOOOOOOOOOOOOOOOO

		System.out.println(s);  // KT :(
	}
}
