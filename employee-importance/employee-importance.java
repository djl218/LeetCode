// n = employees.length
// Time: O(n)
// Space: O(n)

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int total = 0;
        
        for (Employee emp : employees) {
            map.put(emp.id, emp.importance);
            adjList.put(emp.id, emp.subordinates);
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(id);
        
        while (!stack.isEmpty()) {
            int currId = stack.pop();
            total += map.get(currId);
            for (int sub : adjList.get(currId))
                stack.push(sub);
        }
        
        return total;
    }
}
