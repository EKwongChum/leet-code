package ekwong.question717;

public class Solution {

    public static boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        } else if (bits[bits.length - 2] == 0) {
            return true;
        } else if (bits.length == 3) {
            return bits[0] != 0;
        } else {
            int i = 0;
            while (i < bits.length - 1) {
                i += bits[i] + 1;
            }
            return i == (bits.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] bits1 = new int[]{1, 0, 0};
        int[] bits2 = new int[]{1, 1, 1, 0};
        int[] bits3 = new int[]{1, 0, 1, 0};
        int[] bits4 = new int[]{0, 1, 0, 1, 0};
        int[] bits5 = new int[]{1, 0, 0, 1, 0};
        System.out.println("1 =" + isOneBitCharacter(bits1));
        System.out.println("2 =" + isOneBitCharacter(bits2));
        System.out.println("3 =" + isOneBitCharacter(bits3));
        System.out.println("4 =" + isOneBitCharacter(bits4));
        System.out.println("5 =" + isOneBitCharacter(bits5));

    }
}
