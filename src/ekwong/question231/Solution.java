package ekwong.question231;

public class Solution {

    /**
     * 耗时 1 ms，哈哈，又一次战胜100%
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {

        if (n < 0) {
            return false;
        }
        int pow = 0b01;
        for (int i = 0; i < 32; i++) {
            if ((pow ^ n) == 0) {
                return true;
            } else {
                pow = pow << 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("1 returns " + isPowerOfTwo(1));
        System.out.println("16 returns " + isPowerOfTwo(16));
        System.out.println("218 returns " + isPowerOfTwo(218));
    }
}
