/**
 * Problem: LC.881. Min Boats Required to Save People. At most two people can fit in a rescue boat.
 * Approach: Sort people. For the current heaviest person, we try to let him go with the lightest person.
 *           As all people need to get on the boat. If the sum of weight is over the limit, we have to let the heaviest go alone.
 *           No one can take the same boat with him. At the end of for loop, it may happen that i = j.
 *           But it won't change the result so don't worry about it.
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-12-27
 */
public class BoatsToSavePeople {

    private static int numRescueBoats(int[] people, int limit) {
        java.util.Arrays.sort(people);
        int i, j;
        for (i = 0, j = people.length - 1; i <= j; --j)
            if (people[i] + people[j] <= limit) ++i;
        return people.length - 1 - j;
    }

    public static void main(String[] args) {
        int[] people1 = {100, 200, 150, 80};
        System.out.println(numRescueBoats(people1, 200));
        int[] people2 = {3,5,3,4};
        System.out.println(numRescueBoats(people2, 5));
        int[] people3 = {3,2,3,2,2};
        System.out.println(numRescueBoats(people3, 6));
    }

}

/*
Output:
—————————
3
4
3

*/
