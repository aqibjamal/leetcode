package root;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		queue.add(null);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		int level = 1;
		while (!queue.isEmpty()) {
			String word = queue.poll();
			if (word != null) {
				for (int x = 0; x < word.length(); x++) {
					char[] character = word.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						character[x] = c;
						String createdWord = new String(character);
						if (createdWord.equals(endWord))
							return level + 1;
						if (wordList.contains(createdWord) && !visited.contains(createdWord)) {
							queue.add(createdWord);
							visited.add(createdWord);
						}
					}
				}
			} else {
				level++;
				if (!queue.isEmpty())
					queue.add(null);
			}
		}
		return 0;
	}
}
