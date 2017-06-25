import java.io.*;
import java.util.*;

class StringPermute {

	public static TreeSet<String> getSortedPermutations(char[] ca) {
		Set<Character> chars = new HashSet<>();
		for (char c : ca) {
			chars.add(c);
		}

		return new TreeSet<>(getPermutations(chars, ""));
	}

	private static Set<String> getPermutations(Set<Character> leftOver, String curString) {
		Set<String> returnSet = new TreeSet<>();

		if (leftOver.isEmpty()) {
			returnSet.add(curString);
			return returnSet;
		}

		Set<Character> setCopy = new HashSet<>(leftOver);
		for (char c : leftOver) {
			setCopy.remove(c);
			returnSet.addAll(getPermutations(setCopy, curString + c));
			setCopy.add(c);
		}
		return returnSet;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s = "abcdefghijklmnopqrstuvwxyz";

		int k = sc.nextInt();

		String alpha = s.substring(0, k);

		long start = System.currentTimeMillis();

		Set<String> allSortedPerms = getSortedPermutations(alpha.toCharArray());

		long end = System.currentTimeMillis();

		//System.out.println("Time: " + ((end - start)) + "ms");


		for (String perm : allSortedPerms) {
			System.out.println(perm);
		}

	}
}
