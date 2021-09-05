/**
 * Problem: ExcelSheetColumnNumber<->Title
 * Approach: Iterative approach.
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-12-27
 */
public class ExcelSheetColumnNumber {

    // Runtime: 1ms, Memory: 39 MB. LC: 171
    public static int titleToNumber(String s) {
        if (s.length() == 0) return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i)-64;    // ascall table, A-64 = 1
            res += n*Math.pow(26, s.length()-i-1);
        }
        return res;
    }

    // Runtime: 0ms, Memory: 36.2MB
    public String convertToTitle(int n) {
        StringBuffer mot = new StringBuffer();
        int r=0;
        while(n>0){
            r = n%26;
            if(r==0){
                r=26;
            }
            n=(n-r)/26;
            mot.append(String.valueOf((char)(r+64)));
        }
        return mot.reverse().toString();
    }

    // Runtime: 7ms, Memory: 37.2MB
    public String convertToTitle1Liner(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }

}
