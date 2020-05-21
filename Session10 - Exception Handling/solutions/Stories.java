import java.util.*;
import java.io.*;

class Stories {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mymanjeeves.txt"));

		StringBuilder sb = new StringBuilder();
		String s;

		while ((s = br.readLine()) != null) {
			sb.append(s.replace('"', ' ').replace(',', ' ')).append(" ");
		}

		String full = sb.toString();

		String[] words = full.split("\\s+");

		Map<String, List<String>> trigram = populateMapFromWords(words);

		Random r = new Random();

		String w1 = "I";
		String w2 = "said";
		StringBuilder story = new StringBuilder(w1 + " " + w2 + " ");

		final int maxLength = 30;

		for (int i = 0; i < maxLength; i++) {
			String phrase = w1 + " " + w2;
			List<String> possibleWords = trigram.get(phrase);

			// Minor chance of a NPE, but who cares.
			String nextWord = possibleWords.get(r.nextInt(possibleWords.size()));

			story.append(nextWord + " ");
			w1 = w2;
			w2 = nextWord;
		}

		System.out.println(story.toString());

	}

	public static Map<String, List<String>> populateMapFromWords(String[] words) {

		Map<String, List<String>> trigram = new HashMap<>();

		for (int i = 0; i < words.length - 2; i++) {

			String phrase = words[i] + " " + words[i + 1];
			String result = words[i + 2];

			if (!trigram.containsKey(phrase)) {
				trigram.put(phrase, new ArrayList<>());
			}

			trigram.get(phrase).add(result);
		}

		return trigram;
	}
}
