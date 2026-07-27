import java.util.*;

public class QueueProblems {

    // 1. Process Customer Requests
    public static void processRequests(int[] requests) {
        Queue<Integer> q = new LinkedList<>();
        for (int r : requests) q.offer(r);

        while (!q.isEmpty())
            System.out.print(q.poll() + " ");
        System.out.println();
    }

    // 2. Front Customer
    public static int frontCustomer(int[] customers) {
        Queue<Integer> q = new LinkedList<>();
        for (int c : customers) q.offer(c);
        return q.peek();
    }

    // 3. Print Jobs Order
    public static void printJobs(String[] jobs) {
        Queue<String> q = new LinkedList<>();

        for (String job : jobs)
            q.offer(job);

        while (!q.isEmpty())
            System.out.print(q.poll() + " ");

        System.out.println();
    }

    // 4. First Non-Repeating Character Stream
    public static List<String> firstNonRepeating(char[] stream) {

        Queue<Character> q = new LinkedList<>();
        Map<Character, Integer> freq = new HashMap<>();

        List<String> result = new ArrayList<>();

        for (char ch : stream) {

            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            q.offer(ch);

            while (!q.isEmpty() && freq.get(q.peek()) > 1)
                q.poll();

            if (q.isEmpty())
                result.add("-1");
            else
                result.add(String.valueOf(q.peek()));
        }

        return result;
    }

    // 5. Circular Queue Simulation
    public static List<Integer> circularQueueSimulation(int capacity,
                                                        int[] enqueue,
                                                        int dequeueCount) {

        Queue<Integer> q = new ArrayDeque<>();

        for (int x : enqueue) {
            if (q.size() < capacity)
                q.offer(x);
        }

        while (dequeueCount-- > 0 && !q.isEmpty())
            q.poll();

        return new ArrayList<>(q);
    }

    // 6. Serve Patients
    public static void servePatients(String[] patients) {

        Queue<String> q = new LinkedList<>();

        for (String p : patients)
            q.offer(p);

        while (!q.isEmpty())
            System.out.print(q.poll() + " ");

        System.out.println();
    }

    // 7. Generate Binary Numbers
    public static List<String> generateBinary(int n) {

        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.offer("1");

        for (int i = 0; i < n; i++) {

            String curr = q.poll();

            result.add(curr);

            q.offer(curr + "0");
            q.offer(curr + "1");
        }

        return result;
    }

    // 8. Process Packets
    public static void processPackets(int[] packets) {

        Queue<Integer> q = new LinkedList<>();

        for (int p : packets)
            q.offer(p);

        while (!q.isEmpty())
            System.out.print(q.poll() + " ");

        System.out.println();
    }

    // 9. Reverse Queue
    public static Queue<Integer> reverseQueue(Queue<Integer> q) {

        Stack<Integer> stack = new Stack<>();

        while (!q.isEmpty())
            stack.push(q.poll());

        while (!stack.isEmpty())
            q.offer(stack.pop());

        return q;
    }

    // 10. Serve Customers
    public static void serveCustomers(String[] customers) {

        Queue<String> q = new LinkedList<>();

        for (String c : customers)
            q.offer(c);

        while (!q.isEmpty())
            System.out.print(q.poll() + " ");

        System.out.println();
    }

    // 11. Sliding Window Maximum
    public static int[] slidingWindowMaximum(int[] arr, int k) {

        int n = arr.length;

        if (n == 0)
            return new int[0];

        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            while (!dq.isEmpty() &&
                    dq.peekFirst() <= i - k)
                dq.pollFirst();

            while (!dq.isEmpty() &&
                    arr[dq.peekLast()] <= arr[i])
                dq.pollLast();

            dq.offerLast(i);

            if (i >= k - 1)
                result[i - k + 1] = arr[dq.peekFirst()];
        }

        return result;
    }

    // 12. Cafeteria Queue
    public static Queue<Integer> cafeteriaQueue(int[] values,
                                                 int dequeueCount) {

        Queue<Integer> q = new LinkedList<>();

        for (int v : values)
            q.offer(v);

        while (dequeueCount-- > 0 && !q.isEmpty())
            q.poll();

        return q;
    }

    // 13. Even Before Odd
    public static Queue<Integer> evenBeforeOdd(Queue<Integer> q) {

        Queue<Integer> even = new LinkedList<>();
        Queue<Integer> odd = new LinkedList<>();

        while (!q.isEmpty()) {

            int x = q.poll();

            if (x % 2 == 0)
                even.offer(x);
            else
                odd.offer(x);
        }

        even.addAll(odd);

        return even;
    }

    // 14. Queue Size
    public static int queueSize(Queue<Integer> q) {
        return q.size();
    }

    // 15. Check Queue Empty
    public static String checkEmpty(Queue<Integer> q) {
        return q.isEmpty() ? "Empty" : "Not Empty";
    }

    // 16. Last Customer Remaining
    public static int lastCustomer(Queue<Integer> q) {

        int last = -1;

        while (!q.isEmpty())
            last = q.poll();

        return last;
    }

    // 17. Interleave Queue
    public static Queue<Integer> interleaveQueue(Queue<Integer> q) {

        int n = q.size();

        Queue<Integer> firstHalf = new LinkedList<>();

        for (int i = 0; i < n / 2; i++)
            firstHalf.offer(q.poll());

        Queue<Integer> result = new LinkedList<>();

        while (!firstHalf.isEmpty()) {

            result.offer(firstHalf.poll());

            if (!q.isEmpty())
                result.offer(q.poll());
        }

        return result;
    }

    // 18. Jobs Before Target
    public static int jobsBeforeTarget(Queue<String> q,
                                       String target) {

        int count = 0;

        for (String job : q) {

            if (job.equals(target))
                return count;

            count++;
        }

        return -1;
    }

    // 19. Sum of Queue Elements
    public static int sumQueue(Queue<Integer> q) {

        int size = q.size();
        int sum = 0;

        for (int i = 0; i < size; i++) {

            int x = q.poll();

            sum += x;

            q.offer(x);
        }

        return sum;
    }

    // 20. Kth Element From Front
    public static int kthElement(Queue<Integer> q, int k) {

        int count = 1;

        for (int x : q) {

            if (count == k)
                return x;

            count++;
        }

        return -1;
    }

    public static void main(String[] args) {

        // Q1
        processRequests(new int[]{101,102,103});

        // Q2
        System.out.println(frontCustomer(new int[]{1,2,3}));

        // Q4
        System.out.println(
                firstNonRepeating(
                        new char[]{'a','a','b','c'}
                )
        );

        // Q7
        System.out.println(generateBinary(5));

        // Q11
        int[] ans =
                slidingWindowMaximum(
                        new int[]{1,3,-1,-3,5,3,6,7},
                        3
                );

        System.out.println(Arrays.toString(ans));

        // Q20
        Queue<Integer> q = new LinkedList<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);

        System.out.println(kthElement(q,3));
    }
}