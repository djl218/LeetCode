class Sort3s implements Comparator<Map.Entry<List<String>, Integer>> {
    @Override
    public int compare(Map.Entry<List<String>, Integer> a, Map.Entry<List<String>, Integer> b) {
        if (a.getValue() == b.getValue()) {
            for (int i = 0; i < 3; i++) {
                if (a.getKey().get(i).compareTo(b.getKey().get(i)) == 0) {
                    continue;
                } else {
                    return a.getKey().get(i).compareTo(b.getKey().get(i));
                }
            }
        }
        return b.getValue() - a.getValue();
    }
} 

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        String[][] tuples = new String[n][3];
        for (int i = 0; i < n; i++)
            tuples[i] = new String[]{username[i], String.valueOf(timestamp[i]), website[i]};
        
        Arrays.sort(tuples, (a, b) -> Integer.valueOf(a[1]) - Integer.valueOf(b[1]));
        
        Map<String, List<String>> userSites = new HashMap<>();
        for (String[] tup : tuples) {
            userSites.putIfAbsent(tup[0], new ArrayList<>());
            userSites.get(tup[0]).add(tup[2]);
        }
        
        Set<List<String>> all3s = new HashSet<>();
        Map<String, Set<List<String>>> user3s = new HashMap<>();
        for (String user : userSites.keySet()) {
            user3s.putIfAbsent(user, new HashSet<>());
            List<String> sites = userSites.get(user);
            if (sites.size() < 3) continue;
            for (int i = 0; i < sites.size(); i++) {
                for (int j = i + 1; j < sites.size(); j++) {
                    for (int k = j + 1; k < sites.size(); k++) {
                        List<String> new3 = List.of(sites.get(i), sites.get(j), sites.get(k));
                        all3s.add(new3);
                        user3s.get(user).add(new3);
                    }
                }
            }
        }
        
        Map<List<String>, Integer> count3s = new HashMap<>();
        for (List<String> seq3 : all3s) {
            for (String user : user3s.keySet()) {
                if (user3s.get(user).contains(seq3)) {
                    count3s.put(seq3, count3s.getOrDefault(seq3, 0) + 1);
                }
            }
        }
        
        PriorityQueue<Map.Entry<List<String>, Integer>> pq =
            new PriorityQueue<>(new Sort3s());
        for (Map.Entry<List<String>, Integer> entry : count3s.entrySet()) {
            pq.offer(entry);
        }
        
        return pq.poll().getKey();
    }
}