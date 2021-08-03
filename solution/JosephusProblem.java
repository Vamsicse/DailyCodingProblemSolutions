import java.util.ArrayList;

/**
 * Problem: Josephus Problem
 * Approach: Use ArrayList to kill nth member i.e. remove from list.
 *
 * Time complexity : O(n)
 * Space complexity : O(n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class JosephusProblem {

    public static int execute(int n, int k){
        int killNum = 0;
        ArrayList<Integer> prisoners = new ArrayList<>(n);
        for(int i = 0;i < n;i++){
            prisoners.add(i);
        }
        System.out.println("Prisoners executed in order:");
        while(prisoners.size() > 1){
            killNum = (killNum + k - 1) % prisoners.size();
            System.out.print(prisoners.get(killNum) + " ");
            prisoners.remove(killNum);
        }
        System.out.println();
        return prisoners.get(0);
    }

    public static ArrayList<Integer> executeAllButM(int n, int k, int m){
        int killNum = 0;
        ArrayList<Integer> prisoners = new ArrayList<>(n);
        for(int i = 0;i < n;i++){
            prisoners.add(i);
        }
        System.out.println("Prisoners executed in order:");
        while(prisoners.size() > m){
            killNum = (killNum + k - 1) % prisoners.size();
            System.out.print(prisoners.get(killNum) + " ");
            prisoners.remove(killNum);
        }
        System.out.println();
        return prisoners;
    }

    public static void main(String[] args){
        System.out.println("Survivor: " + execute(41, 3));
        System.out.println("Survivors: " + executeAllButM(41, 3, 3));
    }

}

/*
Output:
——————————————————————
Prisoners executed in order:
2 5 8 11 14 17 20 23 26 29 32 35 38 0 4 9 13 18 22 27 31 36 40 6 12 19 25 33 39 7 16 28 37 10 24 1 21 3 34 15
Survivor: 31
Prisoners executed in order:
2 5 8 11 14 17 20 23 26 29 32 35 38 0 4 9 13 18 22 27 31 36 40 6 12 19 25 33 39 7 16 28 37 10 24 1 21 3
Survivors: [15, 30, 34]

*/