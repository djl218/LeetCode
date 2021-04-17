// Time: O(n!)
// Space: O(n)
class Solution {
    private List<List<String>> result = new ArrayList<>();
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diags = new HashSet<>();
    private Set<Integer> antis = new HashSet<>(); 
    
    public List<List<String>> solveNQueens(int n) {
        findQueenPlaces(n, 0, new ArrayList<>());
        return result;
    }
    
    private void findQueenPlaces(int n, int row, List<String> potentialBoard) {
        if (row == n) {
            result.add(new ArrayList<>(potentialBoard));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (cols.contains(i) || diags.contains(row + i) || antis.contains(row - i))
                continue;
            
            char[] singleRowArr = new char[n];
            for (int j = 0; j < n; j++) {
                singleRowArr[j] = j == i ? 'Q' : '.';
            }
            String singleRow = String.valueOf(singleRowArr);
            
            cols.add(i);
            diags.add(row + i);
            antis.add(row - i);
            
            potentialBoard.add(singleRow);
            findQueenPlaces(n, row + 1, new ArrayList<>(potentialBoard));
            potentialBoard.remove(potentialBoard.size() - 1);
            
            cols.remove(i);
            diags.remove(row + i);
            antis.remove(row - i);
        }
    }
}