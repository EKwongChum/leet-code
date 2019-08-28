package ekwong.question231;

import java.nio.ByteBuffer;

public class Solution {

    /**
     * 耗时 1 ms，哈哈，又一次战胜100%
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo2(int n) {

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

    public static boolean isPowerOfTwo3(int n) {

        if (n < 0) {
            return false;
        }
        boolean notZero = false;
        byte notZeroByte = 0;
        byte[] bytes = ByteBuffer.allocate(4).putInt(n).array();
        for (byte b : bytes) {
            if (b != 0) {
                if (notZero) {
                    return false;
                }
                notZero = true;
                notZeroByte = b;
            }
        }
        byte pow = 1;
        for (int i = 0; i < 8; i++) {
            if ((notZeroByte ^ pow) == 0) {
                return true;
            } else {
                pow <<= 1;
            }
        }
        return false;
    }

    public static boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }
        boolean hasUp = false;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                if (hasUp) {
                    return false;
                }
                hasUp = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("1 returns " + isPowerOfTwo(1));
        System.out.println("16 returns " + isPowerOfTwo(16));
        System.out.println("218 returns " + isPowerOfTwo(218));
    }
}
