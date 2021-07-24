/**
 * Problem: Count and Say Sequence. LC: 38
 * Approach: Use recursion to find the sequence.
 *
 * Time complexity : O(n)
 * Space complexity : O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class CountAndSay {

    public static void main(String[] args) {
        for(int i=1;i<10;i++){
            System.out.println(i + ": " +countAndSay(i));
        }
    }

    // Runtime: 1ms, Memory: 36MB
    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char[] sc = s.toCharArray();
        int count = 0;
        for(int i = 0; i <= sc.length; i++){
            if(i == sc.length || i - 1 >= 0 && sc[i] != sc[i - 1]){
                sb.append(count);
                sb.append(sc[i - 1]);
                count = 0;
            }
            count++;
        }
        return sb.toString();
    }
}

/*
Output:
——————————————————————
1: 1
2: 11
3: 21
4: 1211
5: 111221
6: 312211
7: 13112221
8: 1113213211
9: 31131211131221

*/