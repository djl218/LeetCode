// Time: O(1) - it is specified that length of cpdomains will not exceed 100
// Space: O(1) - for same reason as above
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String cpd : cpdomains) {
            String[] cpdSplit = cpd.split("\\s+");
            
            int count = Integer.valueOf(cpdSplit[0]);
            String[] urlSplit = cpdSplit[1].split("\\.");
            
            StringBuilder sb = new StringBuilder();
            for (int i = urlSplit.length - 1; i >=0; i--) {
                sb.insert(0, urlSplit[i]);
                
                String key = sb.toString();
                counts.put(key, counts.getOrDefault(key, 0) + count);
                
                if (i > 0) sb.insert(0, ".");
            }
        }
        
        List<String> result = new ArrayList<>();
        for (String key : counts.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(counts.get(key));
            sb.append(" ");
            sb.append(key);
            result.add(sb.toString());
        }
        
        return result;
    }
}
