import java.util.*;
import java.io.*;

class Stories {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mymanjeeves.txt"));

		StringBuilder sb = new StringBuilder();
		String s;

		while ((s = br.readLine()) != null) {
			sb.append(s.replace('"', ' ').replace(',', ' '));
		}

		String fullStory = sb.toString();

		String[] words = fullStory.split("\\s+");
	}
}
