import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 *          determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Approach: Use DP, Create a boolean DP array and insert true after every valid word.
 *           If all words are valid, last location should have value true.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class WordBreak {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> dictionary1 = List.of("quick", "brown", "the", "fox");
        String str1 = "thequickbrownfox";
        System.out.println(wordBreak.wordBreakDP(str1, dictionary1));
        System.out.println(wordBreak.wordBreakBFS(str1, dictionary1));
        List<String> dictionary2 = List.of("bed", "bath", "bedbath", "and", "beyond");
        String str2 = "bedbathandbeyond";
        System.out.println(wordBreak.wordBreakDP(str2, dictionary2));
        System.out.println(wordBreak.wordBreakBFS(str2, dictionary2));
        List<String> dictionary3 = List.of("cats", "dog", "sand", "and", "cat");
        String str3 = "catsandog";
        System.out.println(wordBreak.wordBreakDP(str3, dictionary3));
        System.out.println(wordBreak.wordBreakBFS(str3, dictionary3));
    }

    // Runtime: 7ms, Memory:39.6MB
    public boolean wordBreakDP(String s, List<String> dictionary) {
        int size=s.length();
        boolean[] dp = new boolean[size+1];
        dp[0]=true;
        for (int i=1;i<=size;i++){
            for (int j=0;j<i;j++){
                System.out.println(dp[j] + " && " + s.substring(j,i));
                if (dp[j] && dictionary.contains(s.substring(j,i))){
                    // System.out.println(s.substring(j,i)); // Print Words
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[size];
    }

    // Runtime: 1ms, Memory:37.3MB
    public boolean wordBreakBFS(String s, List<String> wordDict) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[s.length()];
        int pos = 0;
        q.add(pos);
        visited[0] = true;
        while(!q.isEmpty()){
            pos = q.poll();
            for(String word : wordDict){
                if(s.startsWith(word, pos)) {
                    int next = pos + word.length();
                    // System.out.println(s.substring(pos,next)); // Print Words
                    if(s.length() == next) return true;
                    if(!visited[next]){
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return pos == s.length();
    }

}




/*
Output:
—————————————————————— 

true
true
true
true
false
false



*/
