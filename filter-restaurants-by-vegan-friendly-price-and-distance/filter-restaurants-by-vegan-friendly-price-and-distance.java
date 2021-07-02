// n = restaurants.length
// Time: O(n log n)
// Space: O(n)
class RestaurantSort implements Comparator<int[]> {
    @Override
    public int compare(int[] restaurantA, int[] restaurantB) {
        if (restaurantA[1] == restaurantB[1]) {
            return restaurantB[0] - restaurantA[0];
        }
        return restaurantB[1] - restaurantA[1];
    }
}

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> restaurantsToConsider = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (veganFriendly == 1) {
                if (restaurant[2]  == 1 && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                    restaurantsToConsider.add(restaurant);
                }
            }
            if (veganFriendly == 0) {
                if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                    restaurantsToConsider.add(restaurant);
                }
            }
        }
        
        Collections.sort(restaurantsToConsider, new RestaurantSort());
        
        List<Integer> result = new ArrayList<>();
        for (int[] restaurant : restaurantsToConsider) {
            result.add(restaurant[0]);
        }
        
        return result;
    }
}