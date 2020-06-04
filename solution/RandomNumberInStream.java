import java.util.Random;

/**
 * Problem: Pick a random element from the stream with uniform probability
 * Approach: Pick random element based on size of array.
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class RandomNumberInStream {

    private static int randNumber = 0;    // The resultant random number
    private static int count = 0;

    public static void main(String[] args) {
        int stream[] = {1, 2, 3, 4};
        int n = stream.length;
        for(int i = 0; i < n; i++)
            System.out.println("Random number from first " + (i+1) +
                    " numbers is " + selectRandom(stream[i]));
    }

    private static int selectRandom(int x) {
        count++; // increment count of numbers seen so far

        // If this is the first element from stream, return it
        if (count == 1)
            randNumber = x;
        else
        {
            // Generate a random number from 0 to count - 1
            Random r = new Random();
            int i = r.nextInt(count);

            // Replace the prev random number with new number with 1/count probability
            if(i == count - 1)
                randNumber = x;
        }
        return randNumber;
    }

}


/*
Output:
——————————————————————

Random number from first 1 numbers is 1
Random number from first 2 numbers is 2
Random number from first 3 numbers is 3
Random number from first 4 numbers is 3


*/
