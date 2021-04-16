// C = length of all words in input added together
// Time: O(C)
// Space: O(1) - because only lower case letters are used
class Solution {
    public String alienOrder(String[] words) {
        Set<char[]> orderings = new HashSet<>();
        for (int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String currWord = words[i];
            if (prevWord.length() > currWord.length() && prevWord.startsWith(currWord)) {
                return "";
            }
            int minLength = Math.min(prevWord.length(), currWord.length());
            char[] ordering = new char[2];
            for (int j = 0; j < minLength; j++) {
                if (prevWord.charAt(j) != currWord.charAt(j)) {
                    ordering[0] = prevWord.charAt(j);
                    ordering[1] = currWord.charAt(j);
                    orderings.add(ordering);
                    break;
                }
            }
        }

        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.put(c, new ArrayList<>());
                inDegrees.put(c, 0);
            }
        }
        
        for (char[] ordering : orderings) {
            char parent = ordering[0];
            char child = ordering[1];
            adjList.get(parent).add(child);
            inDegrees.put(child, inDegrees.get(child) + 1);
        }
        
        Queue<Character> queue = new LinkedList<>();
        for (char key : inDegrees.keySet()) {
            if (inDegrees.get(key) == 0)
                queue.offer(key);
        }
        
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);
            List<Character> neighbors = adjList.get(curr);
            for (char neighbor : neighbors) {
                inDegrees.put(neighbor, inDegrees.get(neighbor) - 1);
                if (inDegrees.get(neighbor) == 0) { 
                    queue.offer(neighbor);
                }
            }
        }
        
        return result.length() < inDegrees.size() ? "" : result.toString();
    }
}