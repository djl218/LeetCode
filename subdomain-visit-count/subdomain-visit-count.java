// Time: O(1) - it is specified that length of cpdomains will not exceed 100
// Space: O(1) - for same reason as above
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] cp = cpdomain.split("\\s+");
            
            int count = Integer.valueOf(cp[0]);
            String[] urls = cp[1].split("\\.");
            
            StringBuilder sb = new StringBuilder();
            for (int i = urls.length - 1; i >= 0; i--) {
                sb.insert(0, urls[i]);
                String key = sb.toString();
                map.put(key, map.getOrDefault(key, 0) + count);
                sb.insert(0, ".");
            }
        }
        
        for (String key : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(key));
            sb.append(" ");
            sb.append(key);
            result.add(sb.toString());
        }
        
        return result;
    }
}