import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Given a string s containing only digits, return all possible valid IP addresses.
 *          Given "2542540123", you should return ['254.25.40.123', '254.254.0.123']
 * Approach: DFS
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-12-27
 */
public class RestoreIPAddresses {

    // Runtime: 1ms, Memory: 39.2MB
    private static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        char[] array = s.toCharArray();
        char[] path = new char[s.length() + 3];
        int num = 0;
        for (int i = 0; i < 3; i++) {
            num = 10 * num + array[i] - '0';
            if (num > 255) {
                break;
            }
            path[i] = array[i];
            dfs(result, path, array, i + 1, i + 1, 0);
            if (num == 0) { // we could not let 0 to be the prefix of a positive number
                break;
            }
        }
        return result;
    }

    private static void dfs(List<String> result, char[] path, char[] array, int index, int length, int dot) {
        if (dot == 3) {
            if (index == array.length) {
                result.add(new String(path));
            }
            return;
        }
        path[length] = '.';
        int num = 0;
        for (int i = index; i < Math.min(index + 3, array.length); i++) {
            num = 10 * num + array[i] - '0';
            if (num > 255) {
                break;
            }
            path[length + 1 + i - index] = array[i];
            dfs(result, path, array, i + 1, length + 2 + i - index, dot + 1);
            if (num == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("1111"));
        System.out.println(restoreIpAddresses("010010"));
        System.out.println(restoreIpAddresses("101023"));
        System.out.println(restoreIpAddresses("2542540123"));
    }

}

/*
Output:
—————————
[255.255.11.135, 255.255.111.35]
[0.0.0.0]
[1.1.1.1]
[0.10.0.10, 0.100.1.0]
[1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]
[254.25.40.123, 254.254.0.123]

*/
