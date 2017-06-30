/*
 * This example fixes the faulty immutable Student class to be truly immutable
 */

import java.util.*;

final class Student {

	private List<Integer> marks;

	public Student(int... marks) {

		this.marks = new ArrayList<>();

		for (int mark : marks) {
			this.marks.add(mark);
		}
	}

	// Note how we return a copy of the original array
	public List<Integer> getMarks() {
		return new ArrayList<>(marks);
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

		List<Integer> marksCopy = s.getMarks();
		marksCopy.add(10);    // HAHAHAHAHAHAHA, doesn't make a difference!

		System.out.println(s);  // :D
	}
}
