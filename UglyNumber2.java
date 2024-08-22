import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumber2 {
    /**
     * approach -2
     * 3 variables associated with three prime factors 2, 3, 5
     * 3 pointers associated with all three numbers
     * an array with length n. at index 0 we add 1.
     * at n2, n3 n5 we store balues multipled by element at index o
     * so n2, n3, n5 will hold 2, 3, 5.
     * pick min of three and add it to aray at next available index. thats ts 1 here
     * and move pointer2 by 1.
     * multiply the variable picked by element at index 1.
     Time - o(n)
     Space -o(n)
     */
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int[] result = new int[n];
        int n2 = 2;
        int n3 = 3;
        int n5 = 5;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = Math.min(n2, Math.min(n3, n5));
            if (result[i] == n2) {
                p2++;
                n2 = result[p2] * 2;
            }
            if (result[i] == n3) {
                p3++;
                n3 = result[p3] * 3;
            }
            if (result[i] == n5) {
                p5++;
                n5 = result[p5] * 5;
            }
        }
        return result[n - 1];
    }
    public int nthUglyNumber2(int n) {
        if (n == 1) {
            return 1;
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        // first add the first number is pq and set
        set.add((long) (1));
        pq.add((long) (1));
        // variable to keep counting until count is less than n
        int count = 0;
        //polled element that we will return in the last iteration as that will be nth number
        long curr =0;
        int[] primes = { 2, 3, 5 };
        /**until count is less than n, poll the element, multiply it with all
         the given primes and check if its in hashset,
         if not add it to hashset and add to pq and
         at the end lst curr is the nth number whose prime factors are 2,3 amd 5
         TIme complexity - nLogm (n number of elements iterate, and m elements in priorityq )
         Space complexity - n+m

         */
        while (count < n) {
            curr = pq.poll();
            count ++;
            for (int prime : primes) {
                long newNumber = curr*prime;
                if(!set.contains(newNumber)){
                    set.add(newNumber);
                    pq.add(newNumber);
                }

            }

        }
        return (int)(curr);
    }
}
