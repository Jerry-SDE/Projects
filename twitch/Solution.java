public class Solution {
    public static int canWin(int[] nums) {
        // Write your solution here
        int[] max = new int[]{0};
        helper(nums,0,nums.length-1,0,max);
        return max[0];
    }

    public static void helper(int[] nums, int left, int right, int points,int[] max){
        if(left>=right){
            if(nums.length%2 == 1){
                points+=nums[nums.length/2];
            }
            max[0] = Math.max(points,max[0]);
            if(nums.length%2 == 1){
                points-=nums[nums.length/2];
            }
            return;
        }
        points+=nums[left];
        if(nums[left+1]>nums[right]){
            helper(nums,left+2,right,points,max);
        } else{
            helper(nums,left+1,right-1,points,max);
        }
        points=-nums[left];

        points+=nums[right];
        if(nums[left]>nums[right-1]){
            helper(nums,left+1,right-1,points,max);
        } else{
            helper(nums,left,right-2,points,max);
        }
        points-=nums[right];
    }

    public static void main(String[] args) {
        System.out.println(new int[]{10,11});
    }
}
