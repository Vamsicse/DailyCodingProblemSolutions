/**
 * Implement Trie
 * Approach: Mark leaf nodes as true when the word ends
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class PrefixSearchTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("value");
        trie.insert("vampire");
        trie.insert("vamsi");
        trie.insert("vulture");
        trie.insert("value");

        System.out.println("Searching word vam        " + trie.search("vam"));
        System.out.println("Searching word vamsi      " + trie.search("vamsi"));
        System.out.println("Searching word vampire    " + trie.search("vampire"));
        System.out.println("Searching word val        " + trie.search("val"));
        System.out.println("Searching word value:     " + trie.search("value"));

        System.out.println("Inserting vam into Trie");
        trie.insert("vam");

        System.out.println("Searching word vam:       " + trie.search("vam"));

        System.out.println("Searching Prefix vamsi:   " + trie.startsWith("vamsi"));
        System.out.println("Searching Prefix val:     " + trie.startsWith("val"));
        System.out.println("Searching Prefix vam:     " + trie.startsWith("vam"));
        System.out.println("Searching Prefix va:      " + trie.startsWith("va"));
    }

}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[26];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}


/*
Output:
Searching word vam        false
Searching word vamsi      true
Searching word vampire    true
Searching word val        false
Searching word value:     true
Inserting vam into Trie
Searching word vam        true
Searching Prefix vamsi:   true
Searching Prefix val:     true
Searching Prefix vam:     true
Searching Prefix va:      true
*/
