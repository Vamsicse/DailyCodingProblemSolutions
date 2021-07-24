public class LCS {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ace","abcde"));
        System.out.println(longestCommonSubsequence("epidemiologist","refrigeration"));
    }

    // Runtime: 5ms, Memory: 42.8 MB
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] c1=text1.toCharArray();
        char[] c2=text2.toCharArray();
        int[][] dp=new int[c1.length+1][c2.length+1];
        for(int i=1;i<=c1.length;i++){
            for(int j=1;j<=c2.length;j++){
                if(c1[i-1]==c2[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[c1.length][c2.length];
    }

}

/*
Output:
——————————————————————
3
5

*/
