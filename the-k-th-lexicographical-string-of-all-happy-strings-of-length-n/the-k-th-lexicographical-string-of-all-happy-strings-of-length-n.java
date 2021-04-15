
// My original approach. Doesn't work. sb wont add to happies,
// results in stack overflow. Why?
// Time Complexity: O(n * k); we evaluate k strings of the size n
// Space Complexity: O(n) for the recursion stack
/*
class Solution {
    int count = 0;
    String result = "";
    int k;
    
    public String getHappyString(int n, int k) {
        this.k = k;
        char[] abc = {'a', 'b', 'c'};
        StringBuilder sb = new StringBuilder("");
        backtrack(sb, abc, n);
        return result;
    }
    
    private void backtrack(StringBuilder sb, char[] abc, int remain) {
        if (count > k) return;
        if (remain == 0) { 
            count++;
            if (count == k) result = sb.toString();
            return;
        }
        
        for (int i = 0; i < abc.length; i++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == abc[i])
                continue;
                
            sb.append(abc[i]);
            backtrack(sb, abc, remain - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
*/

// Time Complexity: O(3 * 2^(n-1))
// Space Complexity: O(3 * 2^(n-1) + n)
/*
class Solution {
    public String getHappyString(int n, int k) {
        List<String> happies = new ArrayList<>();
        char[] abc = {'a', 'b', 'c'};
        dfs("", abc, happies, n);
        if (happies.size() < k) return "";
        return happies.get(k - 1);
    }
    
    private void dfs(String str, char[] abc, List<String> happies, int n) {
        if (str.length() == n) {
            happies.add(str);
            return;
        }
        
        for (int i = 0; i < abc.length; i++) {
            if (str.length() == 0 || str.charAt(str.length() - 1) != abc[i])
                dfs(str + abc[i], abc, happies, n);
        }
    }
}
*/

// Time: O(n)
// Space: O(1)
class Solution {
    public String getHappyString(int n, int k) {
        int prem = 1 << (n-1);
        if (k > 3 * prem) return "";
        int ch = 'a' + (k - 1) / prem;
        StringBuilder sb = new StringBuilder(Character.toString(ch));
        while (prem > 1) {
            k = (k - 1) % prem + 1;
            prem >>= 1;
            ch = (k - 1) / prem == 0 ? 'a' + (ch == 'a' ? 1 : 0) : 'b' + (ch != 'c' ? 1 : 0);
            sb.append((char)ch);
        }
        return sb.toString();
    }
}


