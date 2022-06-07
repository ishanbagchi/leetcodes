class Solution {
    public int jump(int[] nums) {
        int moves = 0, pos = 0, i;
        int maxJump, nextPos, idx, localJump;
        int len = nums.length;
        
        while (pos != len - 1) {
            maxJump = -1;
            nextPos = 0;
			
            for (i = 1; i <= nums[pos]; i++) {
                idx = Math.min(len - 1, pos + i);
                localJump = idx + nums[idx];
                localJump = Math.min(len - 1, localJump);
                
                if (localJump >= maxJump) {
                    maxJump = localJump;
                    nextPos = idx;
                }
            }
			
            pos = nextPos;
            moves++;
        }
        
        return moves;
    }
}