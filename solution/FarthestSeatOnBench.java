import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Farthest Seat on Bench Problem.
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class FarthestSeatOnBench {

    private static class Seat {
        int leftEdge, rightEdge;
        Seat(int leftEdge, int rightEdge) {
            this.leftEdge = leftEdge;
            this.rightEdge = rightEdge;
        }
        public String toString() {
            return "["+leftEdge +" " + rightEdge+"]";
        }
    }

    public static void main(String[] args) {
        int[] a = {0,0,0,0,0,0,0,0,0,0};
        int size = a.length;
        PriorityQueue<Seat> seatingSpace = new PriorityQueue<>(new SeatComparator());
        for(int i = 0; i < size; i ++) {
            int nextSeat = getSeat(a, seatingSpace);
            System.out.println("Next Seat Option: " + nextSeat);
        }
    }

    private static int getSeat(int[] input, PriorityQueue<Seat> seatingSpace) {
        if(input[0] == 0) {input[0] = 1;	return 0;}
        if(input[input.length-1] == 0) {
            seatingSpace.add(new Seat(0, input.length -1));
            input[input.length-1] = 1;
            return input.length - 1;
        }
        //get the max Seat
        Seat currentSeat = seatingSpace.poll();
        seatingSpace.add(new Seat(currentSeat.leftEdge, (currentSeat.leftEdge + currentSeat.rightEdge) / 2));
        seatingSpace.add(new Seat((currentSeat.leftEdge + currentSeat.rightEdge) / 2, currentSeat.rightEdge));
        return (currentSeat.leftEdge + currentSeat.rightEdge) / 2;
    }

    static class SeatComparator implements Comparator<Seat> {
        public int compare(Seat one, Seat two) {
            return Integer.compare(two.rightEdge - two.leftEdge, one.rightEdge - one.leftEdge);
        }
    }
}


/*
Output:
—————————

Next Seat Option: 0
Next Seat Option: 9
Next Seat Option: 4
Next Seat Option: 6
Next Seat Option: 2
Next Seat Option: 7
Next Seat Option: 3
Next Seat Option: 8
Next Seat Option: 5
Next Seat Option: 1

*/
