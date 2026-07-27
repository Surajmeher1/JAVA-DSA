/**
 * leetcode
 */
public class leetcode {
    public static int[] twoSum(int[] nums, int target){
        int one = -1;
        int two = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x = nums[i];
                if (x + nums[j] == target) {
                    one = i;
                    two = j;
                }
            }
        }
        return new int[]{one, two};
        

    }
    public static void main(String[] args) {
        int nums[]={2,7,11,15};
        int target=9;
        System.out.println(java.util.Arrays.toString(twoSum(nums, target)));
    }
}