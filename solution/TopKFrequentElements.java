import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;


/**
 * TopKFrequentElements Problem
 * Approach: Use Heap
 *
 * Time complexity : O(Nlog(k)). The complexity of Counter method is O(N).
 * To build a heap and output list takes O(Nlog(k)).
 * Hence the overall complexity of the algorithm is O(N+Nlog(k))=O(Nlog(k)).
 * Space complexity : O(N) to store the hash map.
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println( topKFrequent(new int[]{3, 0, 1, 0}, 2));
        System.out.println(topKFrequents(new int[]{3, 0, 1, 0}, 2));
    }

    // Approach 1 (Using Heap)
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = (Arrays.stream(nums).boxed()
                .collect(Collectors.toList())).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));

        // init heap 'the less frequent element first'
        // PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));

        // keep k top frequent elements in the heap
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        List<Integer> top_k = new LinkedList<>();
        while (!heap.isEmpty()) {
            top_k.add(heap.poll());
        }
        Collections.reverse(top_k);
        return top_k;
    }

    // Approach 2 (Without Heap)
    public static List<Integer> topKFrequents(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        Map<Integer, Long> fMap = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> freqMap = fMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));
        System.out.println(freqMap);
        if (k == freqMap.size()) {
            result.addAll(freqMap.keySet());
        } else {
            int c = 0;
            for (Integer key : freqMap.keySet()) {
                if (c < k) {
                    result.add(key);
                    c++;
                }
            }
        }
        return result;
    }

}
