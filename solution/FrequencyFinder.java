public class FrequencyFinder {

    public static void main(String[] args) {
        int[] map = new int[26];
        String str = "galaxy";
        int n = str.length();

        for (int i = 0; i < n; i++)
            map[str.charAt(i) - 'a']++;

        for (int i = 0; i < n; i++) {
            // if frequency of character str.charAt(i) is not equal to 0
            int freq = map[str.charAt(i) - 'a'];
            if (freq != 0) {
                System.out.print(str.charAt(i));
                System.out.println(freq);
                // update frequency of str.charAt(i) to 0 so that the same character is not printed again
                map[str.charAt(i) - 'a'] = 0;
           }
        }
    }
}
