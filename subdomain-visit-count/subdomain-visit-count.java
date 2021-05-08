class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String cp : cpdomains) {
            String[] cpSplit = cp.split("\\s+");
            
            String[] urlSplit = cpSplit[1].split("\\.");
            int count = Integer.valueOf(cpSplit[0]);
            
            StringBuilder sb = new StringBuilder();
            for (int i = urlSplit.length - 1; i >= 0; i--) {
                sb.insert(0, urlSplit[i]);
                String key = sb.toString();
                map.put(key, map.getOrDefault(key, 0) + count);
                sb.insert(0, '.');
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