// n = s.length()
// Time: O(n^2)
// Space: O(n)
class Solution {
    public int countPalindromicSubsequence(String s) {
        int palindromicSubsequenceCount = 0;
        int n = s.length();
        Set<Character> singleLetterSet = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            if (!singleLetterSet.contains(s.charAt(i))) {
                int prev = 0;
                Set<String> twoLetterSet = new HashSet<>();
                for (int j = i + 1; j < n; j++) {
                    if (j == i + 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(s.charAt(i));
                        sb.append(s.charAt(j));
                        twoLetterSet.add(sb.toString());
                    }
                    if (j > i + 1 && s.charAt(i) != s.charAt(j)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(s.charAt(i));
                        sb.append(s.charAt(j));
                        twoLetterSet.add(sb.toString());
                    }
                    if (j > i + 1 && s.charAt(i) == s.charAt(j)) {
                        palindromicSubsequenceCount -= prev;
                        palindromicSubsequenceCount += twoLetterSet.size();
                        prev = twoLetterSet.size();
                        StringBuilder sb = new StringBuilder();
                        sb.append(s.charAt(i));
                        sb.append(s.charAt(j));
                        twoLetterSet.add(sb.toString());
                    }
                }
            }
            singleLetterSet.add(s.charAt(i));
        }
        return palindromicSubsequenceCount;
    }
    /*
    ***Second attempt***
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Set<Character> letterSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!letterSet.contains(s.charAt(i))) {
                letterSet.add(s.charAt(i));
                for (int j = i + 2; j < n; j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        for (int k = i + 1; k < j; k++) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(s.charAt(i));
                            sb.append(s.charAt(k));
                            sb.append(s.charAt(j));
                            wordSet.add(sb.toString());
                        }
                    }
                }
            }
        }
        return wordSet.size();
    }
    */
    /*
    ***First attempt***  
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    char[] word = new char[3];
                    word[0] = s.charAt(i);
                    word[1] = s.charAt(j);
                    word[2] = s.charAt(k);
                    if (isPalindrome(word)) {
                        set.add(new String(word));
                    }
                }
            }
        }
        return set.size();
    }
    
    private boolean isPalindrome(char[] word) {
        int i = 0, j = word.length - 1;
        while (i < j) {
            if (word[i] != word[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    */
}