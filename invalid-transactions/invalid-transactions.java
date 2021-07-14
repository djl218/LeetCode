// n = transactions.length
// Time: O(n)
// Space: O(n)
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        boolean[] marked = new boolean[n];
        List<String> result = new ArrayList<>();
        Map<String, List<String[]>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String[] t = transactions[i].split(",");
            if (Integer.valueOf(t[2]) > 1000) {
                result.add(transactions[i]);
                marked[i] = true;
            }
            map.putIfAbsent(t[0], new ArrayList<>());
            map.get(t[0]).add(new String[]{t[1], t[3]});
        }
        
        for (int i = 0; i < n; i++) {
            if (marked[i]) continue;
            String[] t = transactions[i].split(",");
            for (String[] arr : map.get(t[0])) {
                if (Math.abs(Integer.valueOf(t[1]) - Integer.valueOf(arr[0])) <= 60
                    && !t[3].equals(arr[1]))
                {
                    result.add(transactions[i]);
                    break;
                }
            }
        }
        
        return result;
    }
}
