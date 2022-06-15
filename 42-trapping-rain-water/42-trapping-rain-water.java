class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int lmax = 0, rmax = 0, result = 0;
        
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] > lmax)
                    lmax = height[left];
                else
                    result += lmax - height[left];
            
                left++;
            } else {
                if (height[right] > rmax)
                    rmax = height[right];
                else
                    result += rmax - height[right];
                
                right--;
            }
        }
        return result;
    }
}