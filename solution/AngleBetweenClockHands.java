/**
 * Problem: Calculate Angle Between Clock Hands
 * Approach: Use formula.
 * Explanation: Hour Hand
                   In 12 hours Hour hand complete whole circle and cover 360°
                   1 hour - 360° / 12 = 30°
                Minute Hand
                   In 60 minutes Minute Hand coplete whole circle and cover 360°.
                   1 minute -> 360° / 60 = 6°

                   1 hour - 60 minutes
                   1 hours - 30°
                   1 minute hours hand rotate -> 30° / 60 = 0.5°
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
        double distance = Math.abs((hour % 12) * 30 - 5.5 * minutes);    // Math.abs(30.0 * hour + 0.5  * minutes - 6 * minutes)
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
