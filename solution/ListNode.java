public class ListNode {
    Integer val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ListNode)) {
            return false;
        }
        ListNode c = (ListNode) o;
        return val==c.val && next == c.next;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.val != null ? this.val.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
    
    public static void print(ListNode head){
        ListNode temp = head;
        System.out.println("******************************************************************");
        while(temp!=null){
            System.out.print(temp.val);
            temp = temp.next;
            if(temp!=null)
                System.out.print("->");
        }
        System.out.println("\n******************************************************************");
    }
    
}
