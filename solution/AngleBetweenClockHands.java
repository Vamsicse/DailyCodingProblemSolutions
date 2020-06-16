/**
 * Problem: Calculate Angle Between Clock Hands
 * Approach: Use formula
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class AngleBetweenClockHands {

    // Runtime: 0ms, Memory: 36.1MB
    public double angleClock(int hour, int minutes) {
        double distance = Math.abs((hour % 12) * 30 - 5.5 * minutes);
        return Math.min(distance, 360 - distance);
    }

    public static void main(String[] args) {
        AngleBetweenClockHands obj = new AngleBetweenClockHands();
        System.out.println(obj.angleClock(12,30));
        System.out.println(obj.angleClock(3,30));
        System.out.println(obj.angleClock(12,0));
    }

}

/*
Output:
——————————————————— 
165.0
75.0
0.0

*/
