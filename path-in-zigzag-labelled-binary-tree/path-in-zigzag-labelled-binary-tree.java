// Time: O(logn)
// Space: O(logn)
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> result = new LinkedList<>();
        int parent = label;
        result.addFirst(parent);

        while(parent != 1) {
            int depth = (int)(Math.log(parent)/Math.log(2));
            int offset = (int)Math.pow(2, depth + 1) - 1 - parent;
            parent = ((int)Math.pow(2, depth) + offset) / 2;
            result.addFirst(parent);   
        }
        
        return result;
    }
}