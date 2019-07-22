package ekwong.question1128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int numEquivDominoPairs1(int[][] dominoes) {
        int sum = 0;
        for (int i = 0; i < dominoes.length - 1; i++) {
            for (int j = i + 1; j < dominoes.length; j++) {
                if (((dominoes[i][0] == dominoes[j][0]) && (dominoes[i][1] == dominoes[j][1])) ||
                        ((dominoes[i][0] == dominoes[j][1]) && (dominoes[i][1] == dominoes[j][0]))) {
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
     * 阶乘运算
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n <= 0) {
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int sum = 0, count = 0;
        Set<int[][]> ints = new HashSet<>();
        for (int i = 0; i < dominoes.length - 1; i++) {
            for (int j = i + 1; j < dominoes.length; j++) {
                if (!ints.contains(new int[][]{{dominoes[i][0], dominoes[i][1]}}) ||
                        !ints.contains(new int[][]{{dominoes[j][0], dominoes[j][1]}})) {
                    if ((((dominoes[i][0] ^ dominoes[j][0]) == 0) && ((dominoes[i][1] ^ dominoes[j][1]) == 0)) ||
                            (((dominoes[i][0] ^ dominoes[j][1]) == 0) && ((dominoes[i][1] ^ dominoes[j][0]) == 0))) {
                        count += 1;
                        ints.add(new int[][]{{dominoes[i][0], dominoes[i][1]}});
                        ints.add(new int[][]{{dominoes[j][0], dominoes[j][1]}});
                    }
                    if (count > 1) {
                        sum += factorial(count) / (2 * factorial(count - 2));
                    } else if (count == 1) {
                        sum += 1;
                    }
                    count = 0;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] dominoes = new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println("result = " + numEquivDominoPairs(dominoes));
    }
}
