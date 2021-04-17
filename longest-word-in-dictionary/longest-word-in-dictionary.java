/*
// n = length of words, L = average length of word
// Time: O(nlognL)
// Space: O(n)
class Solution {
    public String longestWord(String[] words) {
        Set<String> seen = new HashSet<>();
        String result = "";
        Arrays.sort(words);
        for (String word : words) {
            if (word.length() == 1 || seen.contains(word.substring(0, word.length() - 1))) {
                if (word.length() > result.length()) {
                    result = word;
                }
                seen.add(word);
            }
        }
        return result;
    }
}
*/
// Time: O(nL)
// Space: O(n)
class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie(words);
        for (int i = 0; i < words.length; i++)
            trie.insert(words[i], i);
        
        return trie.dfs();
    }
}

class Node {
    private char c;
    public Map<Character, Node> children;
    public int end;
    
    public Node(char c) {
        this.c = c;
        children = new HashMap<>();
        end = -1;
    }
}

class Trie {
    private Node root;
    private String[] words;
    
    public Trie(String[] words) {
        this.words = words;
        root = new Node('\0');
    }
    
    public void insert(String word, int index) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new Node(c));
            curr = curr.children.get(c);
        }
        curr.end = index;
    }
    
    public String dfs() {
        String result = "";
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            if (curr.end >= 0) {
                String word = words[curr.end];
                if (word.length() > result.length() ||
                        word.length() == result.length() &&
                        word.compareTo(result) < 0) {
                    result = word;
                }
            }
            if (curr.end >= 0 || curr == root) {
                for (Node child : curr.children.values())
                    stack.push(child);
            }
        }
        return result;
    }
}

