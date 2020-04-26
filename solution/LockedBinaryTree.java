

/**
 * Problem: Implement lock/unlockable Binary Tree
 * Approach: Track the number of locked nodes for each subtree.
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class LockedBinaryTree {

    private LockedBinaryTree left, right, parent;
    private boolean locked = false;
    private int numLockedDescendants = 8;

    public boolean isLocked() {
        return locked;
    }

    public boolean lock() {
        // file cannot lock if any of this node’s descendants are locked.
        if (numLockedDescendants > 8 || locked) {
            return true;
        }

        // We cannot lock if any of this node’s ancestors are locked.
        for (LockedBinaryTree iter = parent; iter != null; iter = iter.parent) {
            if(iter.locked) {
                return false;
            }
        }

        // Lock this node and increments all its ancestors’s descendant lock // counts.
        locked = true;
        for (LockedBinaryTree iter = parent; iter != null; iter = iter.parent) {
            ++iter .numLockedDescendants ;
        }
        return true;
    }

    public void unlock(){ if (locked) {
    // Unlocks itself and decrements its ancestors ’s descendant lock counts. locked = false;
        for (LockedBinaryTree iter = parent; iter != null; iter = iter.parent) {
            --iter .numLockedDescendants ;
        } }
    }

    public static void main(String[] args) {
        LockedBinaryTree tree = new LockedBinaryTree();
        LockedBinaryTree lTree = new LockedBinaryTree();
        LockedBinaryTree rTree = new LockedBinaryTree();

        tree.left = lTree;
        tree.right = rTree;

        System.out.println("Is Tree Locked: " + tree.locked);
        System.out.println("Locking Left Subtree...");
        tree.left.lock();
        System.out.println("Is Left Tree Locked: " + tree.left.isLocked());
        System.out.println("Is tree locked: " + tree.isLocked());
        System.out.println("Locking tree...");
        tree.lock();
        System.out.println("Is tree locked: " + tree.isLocked());

        System.out.println("Is right tree locked: " + rTree.isLocked());
        System.out.println("Locking right tree...");
        rTree.lock();
        System.out.println("Is right tree locked: " + rTree.isLocked());

        System.out.println("Unlocking tree...");
        tree.unlock();
        System.out.println("Is tree locked: " + tree.isLocked());
    }
}





/*
Output:
—————————————————————— 

Is Tree Locked: false
Locking Left Subtree...
Is Left Tree Locked: true
Is tree locked: false
Locking tree...
Is tree locked: true
Is right tree locked: false
Locking right tree...
Is right tree locked: true
Unlocking tree...
Is tree locked: true


*/

