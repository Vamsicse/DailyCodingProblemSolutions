/**
 * Problem: Add big numeric strings
 * Approach: Add individual characters and keep track of carry
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class AddStringsNumericBinary {

    // Runtime: 2ms, Memory: 39.6MB
    public String addStrings(String num1, String num2) {
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

    // Runtime: 1ms, Memory: 38.2MB
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int tmp=0,carry=0,i=a.length()-1,j=b.length()-1;
        while(i>=0 || j>=0){
            tmp=carry;
            if(i>=0) tmp+=a.charAt(i--)-'0';
            if(j>=0) tmp+=b.charAt(j--)-'0';
            sb.append(tmp%2);
            carry=tmp/2;
        }
        if(carry>0) sb.append(1);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddStringsNumericBinary obj = new AddStringsNumericBinary();
        if(!obj.addStrings("3876620623801494171","6529364523802684779").equals("10405985147604178950")){
            throw new RuntimeException("Error");
        }
        if(!obj.addBinary("1010","1011").equals("10101")){
            throw new RuntimeException("Error");
        }
    }

}
