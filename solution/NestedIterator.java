import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Problem: Given a nested list of integers, implement an iterator to flatten it.
 *          Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Approach: Iterate and unnest nested data.
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */


  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }

public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int curr;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        curr = 0;
        unnest(nestedList, list);
    }

    private void unnest(List<NestedInteger> nestedList, List<Integer> res) {
        if (nestedList.size() == 0) return;
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                res.add(n.getInteger());
            } else {
                unnest(n.getList(), res);
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(curr++);
    }

    @Override
    public boolean hasNext() {
        return curr < list.size();
    }
}
