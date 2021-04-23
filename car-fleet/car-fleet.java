// n = position.length
// Time: O(n logn)
// Space: O(n)
class CarSort implements Comparator<double[]> {
    @Override
    public int compare(double[] a, double[] b) {
        return Double.compare(a[0], b[0]);
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int fleetCount = 0;
        
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = (double) position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        
        Arrays.sort(cars, new CarSort());
        double slowCar = 0;
        for (int i = n - 1; i >= 0; i--) {
           if (cars[i][1] > slowCar) {
               fleetCount++;
               slowCar = cars[i][1];
           } 
        }
        
        return fleetCount;
    }
}
