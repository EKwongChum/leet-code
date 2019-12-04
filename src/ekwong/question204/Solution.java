package ekwong.question204;

public class Solution {

    /**
     * 检测系统认为这个超时了。。。
     * 暴力破解法
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        if (1 == n) {
            return 0;
        }
        int count = 0;
        long start = System.currentTimeMillis();
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count += 1;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("it spend time: " + (end - start) + "ms");
        return count;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                // 说明能整除，非质数
                return false;
            }
        }
        return true;
    }

    public static int countPrimes2(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        long start = System.currentTimeMillis();
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("it spend time: " + (end - start) + "ms");
        return count;
    }
}
