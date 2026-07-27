import java.util.*;

public class tcs {

    // 1. Two Sum
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};

            map.put(nums[i], i);
        }

        return new int[]{};
    }

    // 2. Best Time to Buy and Sell Stock
    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }

        return profit;
    }

    // 3. Valid Parentheses
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);

            else {

                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '['))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    // 4. Merge Sorted Arrays
    public static int[] mergeSortedArray(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int[] result = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {

            if (nums1[i] <= nums2[j])
                result[k++] = nums1[i++];
            else
                result[k++] = nums2[j++];
        }

        while (i < n)
            result[k++] = nums1[i++];

        while (j < m)
            result[k++] = nums2[j++];

        return result;
    }

    // 5. Contains Duplicate
    public static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(num))
                return true;

            set.add(num);
        }

        return false;
    }

    // 6. Maximum Subarray (Kadane)
    public static int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int current = nums[0];

        for (int i = 1; i < nums.length; i++) {

            current = Math.max(nums[i], current + nums[i]);
            maxSum = Math.max(maxSum, current);
        }

        return maxSum;
    }

    // 7. Product of Array Except Self
    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;

        for (int i = 1; i < n; i++)
            result[i] = result[i - 1] * nums[i - 1];

        int right = 1;

        for (int i = n - 1; i >= 0; i--) {

            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }

    // 8. Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLen = Math.max(maxLen,
                    right - left + 1);
        }

        return maxLen;
    }

    // 9. Binary Search
    public static int binarySearch(int[] nums,
                                   int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left +
                    (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    // 10. Number of Islands
    public static int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0;
                 j < grid[0].length;
                 j++) {

                if (grid[i][j] == '1') {

                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid,
                            int row,
                            int col) {

        if (row < 0 ||
            col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            grid[row][col] == '0')
            return;

        grid[row][col] = '0';

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    // Main Method
    public static void main(String[] args) {

        // Two Sum
        System.out.println(
                Arrays.toString(
                        twoSum(
                                new int[]{2,7,11,15},
                                9)));

        // Stock Profit
        System.out.println(
                maxProfit(
                        new int[]{7,1,5,3,6,4}));

        // Valid Parentheses
        System.out.println(
                isValid("()[]{}"));

        // Merge Arrays
        System.out.println(
                Arrays.toString(
                        mergeSortedArray(
                                new int[]{1,2,3},
                                new int[]{2,5,6})));

        // Contains Duplicate
        System.out.println(
                containsDuplicate(
                        new int[]{1,2,3,1}));

        // Maximum Subarray
        System.out.println(
                maxSubArray(
                        new int[]{
                                -2,1,-3,4,-1,2,1,-5,4
                        }));

        // Product Except Self
        System.out.println(
                Arrays.toString(
                        productExceptSelf(
                                new int[]{1,2,3,4})));

        // Longest Substring
        System.out.println(
                lengthOfLongestSubstring(
                        "abcabcbb"));

        // Binary Search
        System.out.println(
                binarySearch(
                        new int[]{
                                -1,0,3,5,9,12
                        }, 9));

        // Number of Islands
        char[][] grid = {
                {'1','1','0','0'},
                {'1','1','0','0'},
                {'0','0','1','0'},
                {'0','0','0','1'}
        };

        System.out.println(
                numIslands(grid));
    }
}