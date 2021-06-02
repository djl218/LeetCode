// n = wordsDict.length
// Time:  O(n) for instantiation of WordDistance class
//        O(n) for shortest method
// Space: O(n)
class WordDistance {
    Map<String, List<Integer>> map;
    String[] wordsDict;

    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        this.wordsDict = wordsDict;
        
        for (int i = 0; i < wordsDict.length; i++) {
            map.putIfAbsent(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        int minDist = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            minDist = Math.min(minDist, Math.abs(list1.get(i) - list2.get(j)));
            if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        
        return minDist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
