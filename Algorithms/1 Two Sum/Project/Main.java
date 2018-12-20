public class Main {
    public static void main(String args[]) {
        Solution s = new Solution();
        int n[]={2, 7, 11, 15};
        for (int i = 0; i < 2; i++)
            System.out.println(s.twoSum(n, 9)[i]);
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] n=new int[]{-1,-1};
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(target==nums[i]+nums[j]) {
                    n[0] = i;
                    n[1] = j;
                    return n;
                }
            }
        }
        return n;
    }
}