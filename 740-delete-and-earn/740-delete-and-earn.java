class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10001];
        int i, choose, notChoose;
        for (int a : nums)
            freq[a]++;
        
        int arr[] = new int[10001];
        arr[0] = 0;
        arr[1] = freq[1] * 1;
        for (i = 2; i < freq.length; i++) {
            choose = freq[i] * i + arr[i - 2];
            notChoose = arr[ i - 1];
            arr[i] = Math.max(choose, notChoose);
        }
        return arr[arr.length - 1];
    }
}