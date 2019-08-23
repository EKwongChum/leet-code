package ekwong.question939;

public class Solution {

    public static int minAreaRect(int[][] points) {
        if (points.length < 4) {
            return 0;
        } else {
            int minSquare = Integer.MAX_VALUE, square = 0;
            int x1, y1, x2, y2, x3, y3, x4, y4;
            int ab, cd, ac, bd, ad, bc;
            for (int i = 0; i < points.length; i++) {
                x1 = points[i][0];
                y1 = points[i][1];
                for (int j = i + 1; j < points.length; j++) {
                    x2 = points[j][0];
                    y2 = points[j][1];
                    for (int k = j + 1; k < points.length; k++) {
                        x3 = points[k][0];
                        y3 = points[k][1];
                        for (int l = k + 1; l < points.length; l++) {
                            x4 = points[l][0];
                            y4 = points[l][1];
                            // 满足 ab = cd 、ac = bd 和 ad = bc , 说明是矩形
                            if ((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))
                                    == (Math.pow(x4 - x3, 2) + Math.pow(y4 - y3, 2))) {
                                if ((Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2))
                                        == (Math.pow(x4 - x2, 2) + Math.pow(y4 - y2, 2))) {
                                    if ((Math.pow(x4 - x1, 2) + Math.pow(y4 - y1, 2))
                                            == (Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2))) {
                                        square = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
                                        if (square < minSquare) {
                                            minSquare = square;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (minSquare != Integer.MAX_VALUE) {
                return minSquare;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] ints1 = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}};
        int[][] ints2 = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}};
        int[][] ints3 = {{1, 2}, {1, 3}, {3, 3}, {4, 4}, {2, 1}, {1, 4}, {2, 2}, {1, 0}, {0, 2}};
        // leetcode 官网竟然认为  {3, 3},{2, 1},  {1, 4}, {0, 2} 这四个点无法构成矩形。。。。
//        System.out.println("1 returns " + minAreaRect(ints1));
//        System.out.println("2 returns " + minAreaRect(ints2));
        System.out.println("3 returns " + minAreaRect(ints3));

    }
}
