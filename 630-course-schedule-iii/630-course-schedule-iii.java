class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (x1, x2) -> x1[1] - x2[1]);
        int cnt = 0, time = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x1, x2) -> x2[0] - x1[0]);
        
        for (int[] course : courses) {
            int start = course[1] - course[0];
            if (start >= time) {
                pq.offer(course);
                time += course[0];
            } else {
                if (!pq.isEmpty() 
                    && course[0] < pq.peek()[0] 
                    && start >= time - pq.peek()[0]) {
                    
                    time += course[0] - pq.peek()[0];
                    pq.poll();
                    pq.offer(course);
                }
            }
        }
        return pq.size();
    }
}