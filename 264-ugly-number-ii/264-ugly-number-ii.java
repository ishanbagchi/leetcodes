class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> q = new TreeSet<>();
        int i = 1;
        q.add(1l);
        while (i < n) {
            long temp = q.pollFirst();
            
            q.add(temp * 2);
            q.add(temp * 3);
            q.add(temp * 5);
            
            i++;
        }
        
        return q.pollFirst().intValue();
    }
}