import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Identify the busiest entry
 * Approach: Sort and identify the busiest entry
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */

public class BusiestEntry {

    public static void main(String[] args) {
        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry(1, 2, "enter"));
        entries.add(new Entry(2, 2, "enter"));
        entries.add(new Entry(3, 1, "enter"));
        entries.add(new Entry(4, 1, "enter"));

        entries.add(new Entry(5, 3, "exit"));
        entries.add(new Entry(6, 1, "exit"));
        entries.add(new Entry(7, 1, "exit"));
        entries.add(new Entry(8, 1, "exit"));

        BusiestEntry obj = new BusiestEntry();
        System.out.println(obj.getPeriod(entries));
    }

    Pair getPeriod(List<Entry> entries) {
        if (entries == null || entries.isEmpty()) {
            return null;
        }
        entries.sort((o1, o2) -> (int) (o1.timestamp - o2.timestamp));
        int max = 0;
        int current = 0;
        Pair period = null;
        for (int index = 0; index < entries.size(); index++) {
            Entry currentEntry = entries.get(index);
            if (currentEntry.type.equals("enter")) {
                current += currentEntry.count;
            } else {
                current -= currentEntry.count;
            }
            if (current > max) {
                max = current;
                period = new Pair(currentEntry.timestamp, entries.get(index + 1).timestamp);
            }
        }
        return period;
    }

    static class Pair {
        private long start, end;
        Pair(long start, long end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString(){
            return "[" + start + "," + end + "]";
        }
    }

    static class Entry {
        private long timestamp;
        private int count;
        private String type;
        Entry(long timestamp, int count, String type) {
            this.timestamp = timestamp;
            this.count = count;
            this.type = type;
        }
        public int getCount() {
            return count;
        }
    }

}



/*
Output:
—————————————————————— 

[4,5]


*/
