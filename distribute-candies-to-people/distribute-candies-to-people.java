/* 
    n = num_people
    Time: O(n) 
        - the amount of candies plays a factor,
        but I think it is just asymptotically constant.
        - Let's disregard the candies that are distributed,
        based on index for now.
        - Also assume that n = 4.
        - For the first round, 0 additional candies are distributed.
        - For the second round, 4 * 4 = 16 additional candies are distributed.
        - For the third round, 8 * 4 = 32 additional candies are distributed.
        - ....0, 16, 32, 48, 64 ... c so an arithmetic sequence
        - so I think time is just O(n)... could be wrong though
        
    Space: O(n)
    
    Also be sure to check out other solutions on the discussion board that 
    utilize super neat math tricks. :)
*/
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        
        int round = 0;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                int candyForPerson = i + 1 + round;
                if (candies - candyForPerson < 0) {
                    result[i] += candies;
                    candies = 0;
                    break;
                } else {
                    result[i] += candyForPerson;
                }
                
                candies -= candyForPerson;
            }
            round += num_people;
        }
        
        return result;
    }
}