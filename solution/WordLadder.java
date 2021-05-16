import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: Word Ladder
 * Approach: 1. Search from entry and exit simultaneously
 *           2. Pick the queue with less elements to BFS
 *           3. Use set instead of queue during bfs
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class WordLadder {

    public static void main(String[] args) {
        System.out.println( ladderLength("dog", "cat", Arrays.asList("dot", "dop", "dat", "cat")) );
        System.out.println( ladderLength("dog", "cat", Arrays.asList("dot", "tod", "dat", "dar")) );
        System.out.println( ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")) );
        System.out.println( ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")) );
    }

    // Runtime: 10ms, Memory: 40.4MB
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);
        if (!wordSet.contains(endWord))
            return 0;
        // 3. Use set instead of queue during bfs
        Set<String> forwardSet = new HashSet<>();
        Set<String> backwardSet = new HashSet<>();
        forwardSet.add(beginWord);
        backwardSet.add(endWord);
        wordSet.remove(endWord);
        wordSet.remove(beginWord);
        // 1. Search from entry and exit simultaneously
        return transform(forwardSet, backwardSet, wordSet);
    }

    public static int transform(Set<String> forwardSet, Set<String> backwardSet, Set<String> wordSet) {
        Set<String> newSet = new HashSet<>();
        for (String fs : forwardSet) {
            char wordArray[] = fs.toCharArray();
            for (int i = 0; i < wordArray.length; i++) {
                for (int c = 'a'; c <= 'z'; c++) {
                    char origin = wordArray[i];
                    wordArray[i] = (char) c;
                    String target = String.valueOf(wordArray);
                    if (backwardSet.contains(target))
                        return 2; // stop bfs when entry and exits meet
                    else if (wordSet.contains(target) && !forwardSet.contains(target)) {
                        wordSet.remove(target); // 4. Remove visited word from wordList to decrease the search time
                        newSet.add(target);
                    }
                    wordArray[i] = origin;
                }
            }
        }
        if (newSet.size() == 0)
            return 0;
        forwardSet = newSet;
        // 2. Pick the queue with less elements to BFS
        int result = forwardSet.size() > backwardSet.size() ?
                transform(backwardSet, forwardSet, wordSet) : transform(forwardSet, backwardSet, wordSet);
        return result == 0 ? 0 : result + 1;
    }
}

/*
Output:
——————————————————————

4
0
5
0

*/

// https://leetcode.com/problems/word-ladder