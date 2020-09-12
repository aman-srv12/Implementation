class Solution {
    public int maxProduct(int[] nums) {
        
        int min = nums[0]; 
        int max = nums[0];
        int p = nums[0];
        int i = 1;
        while(i < nums.length){
            int x = min * nums[i];
            int y = max * nums[i];
            min = Math.min(nums[i], Math.min(x, y));
            max = Math.max(nums[i], Math.max(x, y));
            p = Math.max(p, max);
            i++;
        }
        return p;
    }
}
