import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals Problem
 * Approach: Sort and One-pass merge
 *
 * Time complexity : O(logn) + O(n).
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class MergeIntervals {

    static class Interval {
        int start, end;
        public Interval(int s,int e){start=s;end=e;}
        @Override
        public String toString() { return "("+start+","+end+")"; }
    }

    public static void main(String args[]) {
       List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(5,7));
        intervals.add(new Interval(6,8));
        System.out.println(merge(intervals));
    }

    private static List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size()<=1){
            return intervals;
        }
        Collections.sort(intervals, Comparator.comparing((Interval itl)->itl.start));
        List<Interval> result = new ArrayList<>();
        Interval a = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval b = intervals.get(i);
            if(a.end >= b.start){
                a.end = Math.max(a.end, b.end);
            }else{
                result.add(a);
                a = b;
            }
        }
        result.add(a);
        return result;
    }

}




/*
Output:
—————————

[(1,4), (5,8)]

*/
