// n = cpdomains.length
// Time: O(n)
// Space: O(n)
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] cp = cpdomain.split("\\s+");
            
            int count = Integer.valueOf(cp[0]);
            String[] url = cp[1].split("\\.");
            
            StringBuilder sb = new StringBuilder();
            for (int i = url.length - 1; i >= 0; i--) {
                sb.insert(0, url[i]);
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