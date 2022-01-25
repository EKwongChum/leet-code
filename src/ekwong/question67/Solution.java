package ekwong.question67;

public class Solution {
    /**
     * 给出两个二进制数字字符串形式
     * 返回他们的和（以二进制数字的字符串形式）
     * <p>
     * 把两个字符串都转换成char数组
     * 创建一个新的 char 数组，长度与原两数组最大长度相同
     * 从尾部开始，遍历两个 char 数组，把每位相加（两数组的元素及进位情况），结果放入新 char 数组的对应位置，记录进位情况
     * 遍历完任意数组后，另一个数组剩余部分 + 进位情况，放入新数组前
     * 若新数组组装完后，依然有进位情况未结算，则在新数组最前面 + 1
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        int len = Math.max(al, bl);
        char[] arr = new char[len];
        boolean more = false;
        for (int i = len - 1, j = al - 1, k = bl - 1; i >= 0; i--, j--, k--) {
            if (j < 0) {
                more = isMore(b, arr, more, i, k);
            } else if (k < 0) {
                more = isMore(a, arr, more, i, j);
            } else {
                char q = b.charAt(k);
                char p = a.charAt(j);
                int qi = q - '0';
                int pi = p - '0';
                if (more) {
                    int sum = pi + qi + 1;
                    switch (sum) {
                        case 3:
                            arr[i] = '1';
                            break;
                        case 2:
                            arr[i] = '0';
                            break;
                        case 1:
                            arr[i] = '1';
                            more = false;
                            break;
                        case 0:
                            arr[i] = '0';
                            more = false;
                            break;
                    }
                } else {
                    int sum = pi + qi;
                    switch (sum) {
                        case 2:
                            arr[i] = '0';
                            more = true;
                            break;
                        case 1:
                            arr[i] = '1';
                            break;
                        case 0:
                            arr[i] = '0';
                            break;
                    }
                }
            }
        }
        String result = new String(arr);
        if (more) {
            return "1" + result;
        } else {
            return result;
        }
    }

    private static boolean isMore(String b, char[] arr, boolean more, int i, int k) {
        char q = b.charAt(k);
        if (more) {
            int qi = q - '0';
            qi += 1;
            if (qi > 1) {
                arr[i] = '0';
            } else {
                more = false;
                arr[i] = '1';
            }
        } else {
            arr[i] = q;
        }
        return more;
    }

    public static void main(String[] args) {
        String result = addBinary("11", "1");
        System.out.println(result);
    }
}
