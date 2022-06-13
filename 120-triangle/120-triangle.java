class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        
        int len = triangle.size();
        int currLen, i, j;
        int a[] = new int[len + 1];
        for (i = len - 1; i >= 0; i--) {
            currLen = triangle.get(i).size();
            
            for (j = 0; j < currLen; j++) {
                a[j] = Math.min(a[j], a[j + 1]) + triangle.get(i).get(j);
            }
        }
        return a[0];
    }
}