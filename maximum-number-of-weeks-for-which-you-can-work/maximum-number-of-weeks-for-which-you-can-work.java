// Third Attempt
// n = milestones.length
// Time: O(n)
// Space: O(1)
class Solution {
    public long numberOfWeeks(int[] milestones) {
        int n = milestones.length;
        long max = -1, sum = 0;
        for (int i = 0; i < n; i++) {
            if (milestones[i] > max) {
                sum = max == -1 ? 0 : sum + max;
                max = milestones[i];
            } else {
                sum += milestones[i];
            }
        }
        return sum >= max ? sum + max : sum + sum + 1;
    }
}
/*

// Second Atttempt

class Solution {
    public long numberOfWeeks(int[] milestones) {
        int n = milestones.length;
        int max = -1, sum = 0, second = -1;
        for (int i = 0; i < n; i++) {
            if (milestones[i] > max) {
                sum = max == -1 ? 0 : sum + max;
                second = max;
                max = milestones[i];
            } else {
                sum += milestones[i];
                if (milestones[i] < max && milestones[i] > second) {
                    second = milestones[i];
                }
            }
        }
        if (second != -1 && max - second == 1) {
            return max + sum;
        }
        return sum == max ? sum + max : sum + sum + 1;
    }
}
*/
/*

// First Attempt

class Project {
    int milestones;
    int index;
    
    public Project(int milestones, int index) {
        this.milestones = milestones;
        this.index = index;
    }
}

class MySort implements Comparator<Project> {
    @Override
    public int compare(Project a, Project b) {
        return b.milestones - a.milestones;
    }
}

class Solution {
    public long numberOfWeeks(int[] milestones) {
        PriorityQueue<Project> heap = new PriorityQueue<>(new MySort());
        for (int i = 0; i < milestones.length; i++) {
            heap.add(new Project(milestones[i], i));
        }
        int weeks = 0;
        int prev = -1;
        while (!heap.isEmpty()) {
            Project curr = heap.poll();
            if (curr.index == prev) {
                if (heap.isEmpty()) {
                    break;
                }
                weeks++;
                Project next = heap.poll();
                prev = next.index;
                next.milestones = --next.milestones;
                if (next.milestones > 0) {
                    heap.add(next);
                }
            } else {
                weeks++;
                if (heap.isEmpty()) {
                    break;
                }
                prev = curr.index;
                curr.milestones = --curr.milestones;
            }
            if (curr.milestones > 0) {
                heap.add(curr);
            }
        }
        return weeks;
    }
}
*/