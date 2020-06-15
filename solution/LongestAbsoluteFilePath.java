/**
 * Problem: Find Longest Absolute File Path
 * Approach: Since we can view the dir as a tree structure split by \n, and to traverse this tree using dfs we can iterate all directories.
 * Key observation: 
    1. We can run dfs sequentially along the split array, so use a global pointer tracking the current index. 
    2. Computation of length of the directory: each time increment the total length by
       (curLength + curDirLength - offset(of "\t")), and if we are at a directory, total length = (curLength + curFileLength)
 *
 * Time Complexity: O(s), s = length of input
 * Space Complexity: O(# of dir), used for call stack
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        String[] arr = input.split("\n");
        int[] max = new int[1];
        int[] cur = new int[1];
        while (cur[0] < arr.length) {
            //we wrap our call in a while loop to handle if there are multiple top level files
            dfs(arr, cur, max, 0, 0);
        }
        return max[0];
    }
    //recursively visit all subdirectories in a given dir array
    //@params: max[1] be the global maximum where we update as we encounter a file dir
    //@params: cur[1] be the global index pointing at the current arr[count[0]]
    //@params: offset = # of \t we are skipping at this level
    //@params: curLength = current dir length
    public void dfs(String[] arr, int[] cur, int[] max, int offset, int curLength) {
        if (cur[0] == arr.length) {
            return;
        }
        String curStr = arr[cur[0]++];
        if (curStr.contains(".")) {
            max[0] = Math.max(max[0], curLength + curStr.length());
            //since we cannot have further dir if it's a file, return to previous level
            return;
        }
        //curStr is a dir, not a file
        while (cur[0] < arr.length && countOffset(arr[cur[0]]) == offset + 1) {
            dfs(arr, cur, max, offset + 1, curLength + curStr.length() - offset);
        }
    }

    public int countOffset(String s) {
        int count = 0;
        int i = 0;
        while (i < s.length() && s.charAt(i) == '\t') {
            count++;
            i++;
        }
        return count;
    }
}
