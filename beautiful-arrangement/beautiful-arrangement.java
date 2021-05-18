// Initial attempt - TLE
// 10/15 test cases passed
class Solution {
    int beautifulCount = 0;
    
    public int countArrangement(int n) {
        if (n == 1) return n;
        backtrack(n, new ArrayList<>());
        return beautifulCount;
    }
    
    private void backtrack(int n, List<Integer> arrangement) {
        if (arrangement.size() == n) {
            for (int i = 1; i <= n; i++) {
                boolean isBeautiful1 = true;
                boolean isBeautiful2 = true;
                
                if (arrangement.get(i - 1) % i != 0)
                    isBeautiful1 = false;
                if (i % arrangement.get(i - 1) != 0)
                    isBeautiful2 = false;
                
                if (!isBeautiful1 && !isBeautiful2)
                    return;
            }
            beautifulCount++;
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (arrangement.contains(i)) continue;
            arrangement.add(i);
            backtrack(n, new ArrayList<>(arrangement));
            arrangement.remove(arrangement.size() - 1);
        }
    }
}
/************************************************************/
// clever solution inspired by Leet Elite
class Solution {
    int beautifulCount = 0;
    
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return beautifulCount;
    }
    
    private void backtrack(int n, int idx, boolean[] visited) {
        if (idx > n) {
            beautifulCount++;
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (idx % i == 0 || i % idx == 0)) {
                visited[i] = true;
                backtrack(n, idx + 1, visited);
                visited[i] = false;
            }
        }
    }
}
