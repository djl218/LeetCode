// n = all characters in each string in sentence array
//     plus 1 for every string in that array for spacing
// Time: O((rows * cols) / n)
// Space: O(1)
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int sentenceCount = 0;
        int rowCount = 1;
        int currRowWidth = 0;
        boolean isRoom = true;
        while (rowCount <= rows) {
            for (String word : sentence) {
                if (word.length() > cols) {
                    return 0;
                }
                currRowWidth += word.length() + 1;
                if (currRowWidth == cols + 1) {
                    currRowWidth--;
                }
                if (currRowWidth > cols) {
                    rowCount++;
                    if (rowCount > rows) {
                        isRoom = false;
                        break;
                    }
                    currRowWidth = word.length() + 1;
                }
            }
            if (isRoom) sentenceCount++;
        }
        return sentenceCount;
    }
}