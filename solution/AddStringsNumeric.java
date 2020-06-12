/**
 * Problem: Add big numeric strings
 * Approach: Add individual characters and keep track of carry
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class AddStringsNumeric {

    // Runtime: 2ms, Memory: 39.6MB
    public static String addStrings(String num1, String num2) {
        int carry =0;
        int len1 = num1.length()-1, len2 = num2.length()-1;
        StringBuilder sb = new StringBuilder();

        while(len1 >=0 || len2 >=0 || carry ==1){
            int n1 = len1 <0 ? 0 : num1.charAt(len1) -'0';
            int n2 = len2<0 ? 0 : num2.charAt(len2) - '0';
            sb.append((n1 + n2 + carry)%10);
            carry = (n1 + n2 + carry)/10;
            len1-=1;
            len2-=1;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        if(!addStrings("3876620623801494171","6529364523802684779").equals("10405985147604178950")){
            throw new RuntimeException("Error");
        }
    }

}
