/**
 * Problem: Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *          word1 and word2 may be the same and they represent two individual words in the list.
 * Approach: 2 variables used to track indices should take turns to update.
 *           Divide the cases to two: word1 and word2 are the same and not the same.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */

public class ShortestWordDistance {

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        if(shortestWordDistance(words,"makes", "coding") != 1){
            throw new RuntimeException("Error");
        }
        if(shortestWordDistance(words,"makes", "makes") != 3){
            throw new RuntimeException("Error");
        }
    }

    private static int shortestWordDistance(String[] words, String word1, String word2) {
        if(words==null || words.length==0)
            return -1;
        if(word1==null || word2==null)
            return -1;
        boolean isSame = false;
        if(word1.equals(word2))
            isSame = true;
        int shortest = Integer.MAX_VALUE;

        int prev=-1, i1=-1, i2=-1;

        for(int i=0; i<words.length; i++){
            if(isSame){
                if(words[i].equals(word1)){
                    if(prev != -1){
                        shortest = Math.min(shortest, i-prev);
                    }
                    prev = i;
                }
            }else{
                if(word1.equals(words[i])){
                    i1 = i;
                    if(i2 != -1){
                        shortest = Math.min(shortest, i-i2);
                    }
                }else if(word2.equals(words[i])){
                    i2 = i;
                    if(i1 != -1){
                        shortest = Math.min(shortest, i-i1);
                    }
                }
            }
        }
        return shortest;
    }

}
