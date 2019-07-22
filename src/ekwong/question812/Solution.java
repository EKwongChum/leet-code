package ekwong.question812;

public class Solution {
    public double largestTriangleArea(int[][] points) {
        double squre = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length && j != i; j++) {
                for (int k = 0; k < points.length && k != i && k != j; k++) {
                    double tem = (points[i][0] * (points[j][1] - points[k][1])
                            + points[j][0] * (points[k][1] - points[i][1]
                    ) + points[k][0] * (points[i][1] - points[j][1]))
                            * 0.5;
                    if (Math.abs(tem) > squre) {
                        squre = Math.abs(tem);
                    }
                }
            }
        }
        return squre;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        /*
            创建了一个二维数组
            二维数组当中有2个一维数组
            每一个一维数组长度为3
         */
        int[][] arr = new int[2][3];

        //为每一个一维数组进行赋值
        // 给二维数组中的第一个一维数组的0索引赋值为10
        arr[0][0] = 10;
        // 给二维数组中的第一个一维数组的1索引赋值为20
        arr[0][1] = 20;
        // 给二维数组中的第一个一维数组的2索引赋值为30
        arr[0][2] = 30;

        // 给二维数组中的第二个一维数组的0索引赋值为60
        arr[1][0] = 60;
        // 给二维数组中的第二个一维数组的1索引赋值为70
        arr[1][1] = 70;
        // 给二维数组中的第二个一维数组的2索引赋值为80
        arr[1][2] = 80;

        //优化
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
