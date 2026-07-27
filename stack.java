import java.util.*;

public class stack {

    // 1. Reverse String
    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) stack.push(ch);

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.toString();
    }

    // 2. Balanced Brackets
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);

            else if (ch == ')' || ch == ']' || ch == '}') {

                if (stack.isEmpty()) return "Not Balanced";

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{'))
                    return "Not Balanced";
            }
        }

        return stack.isEmpty() ? "Balanced" : "Not Balanced";
    }

    // 3. Next Greater Element
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();

            res[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return res;
    }

    // 4. Postfix Evaluation
    public static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {

            if (Character.isDigit(ch))
                stack.push(ch - '0');

            else {

                int b = stack.pop();
                int a = stack.pop();

                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }

        return stack.pop();
    }

    // 5. Infix To Postfix
    static int precedence(char op) {
        switch (op) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char ch : exp.toCharArray()) {

            if (Character.isLetterOrDigit(ch))
                result.append(ch);

            else if (ch == '(')
                stack.push(ch);

            else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());

                stack.pop();
            }

            else {

                while (!stack.isEmpty() &&
                       stack.peek() != '(' &&
                       precedence(stack.peek()) >= precedence(ch))
                    result.append(stack.pop());

                stack.push(ch);
            }
        }

        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.toString();
    }

    // 6. Remove Adjacent Duplicates
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!stack.isEmpty() && stack.peek() == ch)
                stack.pop();
            else
                stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);

        return sb.toString();
    }

    // 7. Stock Span
    public static int[] stockSpan(int[] prices) {

        int n = prices.length;
        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   prices[stack.peek()] <= prices[i])
                stack.pop();

            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            stack.push(i);
        }

        return span;
    }

    // 8. Min Stack
    static class MinStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int x) {
            stack.push(x);

            if (minStack.isEmpty() || x <= minStack.peek())
                minStack.push(x);
        }

        public void pop() {
            int x = stack.pop();

            if (x == minStack.peek())
                minStack.pop();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    // 9. Daily Temperatures
    public static int[] dailyTemperatures(int[] temp) {

        int n = temp.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   temp[i] > temp[stack.peek()]) {

                int idx = stack.pop();
                ans[idx] = i - idx;
            }

            stack.push(i);
        }

        return ans;
    }

    // 10. Simplify Path
    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        for (String part : path.split("/")) {

            if (part.equals("") || part.equals("."))
                continue;

            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(part);
            }
        }

        return "/" + String.join("/", stack);
    }

    // 11. Browser Back
    public static String browserBack(String[] visits) {

        Stack<String> stack = new Stack<>();

        for (String page : visits)
            stack.push(page);

        stack.pop();

        return stack.peek();
    }

    // 12. Validate Stack Sequence
    public static boolean validateStackSequence(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int x : pushed) {

            stack.push(x);

            while (!stack.isEmpty() &&
                   stack.peek() == popped[j]) {

                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }

    // 13. Decode String
    public static String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch))
                k = k * 10 + (ch - '0');

            else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);

                current = new StringBuilder();
                k = 0;
            }

            else if (ch == ']') {

                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();

                for (int i = 0; i < repeat; i++)
                    prev.append(current);

                current = prev;
            }

            else current.append(ch);
        }

        return current.toString();
    }

    // 14. Largest Rectangle Histogram
    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int curr = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() &&
                   heights[stack.peek()] > curr) {

                int height = heights[stack.pop()];

                int width = stack.isEmpty()
                        ? i
                        : i - stack.peek() - 1;

                maxArea = Math.max(maxArea,
                                   height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    // 15. Sort Stack
    public static Stack<Integer> sortStack(Stack<Integer> stack) {

        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {

            int x = stack.pop();

            while (!temp.isEmpty() &&
                   temp.peek() > x)
                stack.push(temp.pop());

            temp.push(x);
        }

        return temp;
    }

    // 16. Maximum Nesting Depth
    public static int maxDepth(String s) {

        int current = 0;
        int max = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                current++;
                max = Math.max(max, current);
            }

            else if (ch == ')')
                current--;
        }

        return max;
    }

    // 17. Asteroid Collision
    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty() &&
                    a < 0 &&
                    stack.peek() > 0) {

                if (stack.peek() < -a)
                    stack.pop();

                else if (stack.peek() == -a) {
                    stack.pop();
                    destroyed = true;
                    break;
                }

                else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed)
                stack.push(a);
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }

    // 18. Remove K Digits
    public static String removeKDigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            while (k > 0 &&
                   !stack.isEmpty() &&
                   stack.peek() > digit) {

                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        while (k-- > 0)
            stack.pop();

        StringBuilder sb = new StringBuilder();

        for (char c : stack)
            sb.append(c);

        while (sb.length() > 0 &&
                sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.length() == 0 ? "0" : sb.toString();
    }

    // 19. Reverse Stack Using Recursion
    static void insertBottom(Stack<Integer> stack, int item) {

        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }

        int temp = stack.pop();

        insertBottom(stack, item);

        stack.push(temp);
    }

    public static void reverseStack(Stack<Integer> stack) {

        if (stack.isEmpty())
            return;

        int temp = stack.pop();

        reverseStack(stack);

        insertBottom(stack, temp);
    }

    // 20. Previous Greater Element
    public static int[] previousGreater(int[] arr) {

        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() &&
                   stack.peek() <= arr[i])
                stack.pop();

            res[i] = stack.isEmpty()
                    ? -1
                    : stack.peek();

            stack.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(reverseString("hello"));
        System.out.println(isBalanced("{[()]}"));
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));

        System.out.println(
            Arrays.toString(
                nextGreaterElement(new int[]{4,5,2,10})
            )
        );
    }
}