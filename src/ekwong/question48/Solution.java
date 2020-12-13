package ekwong.question48;

public class Solution {
    public void rotate(int[][] matrix) {
        int[] nums = new int[matrix.length * matrix.length];
        int y = 0;
        int x = matrix.length - 1;
        int countY = 1;
        int countX = 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = matrix[x][y];
            if (countX == matrix.length) {
                x = matrix.length - 1;
                countX = 1;
            } else {
                x--;
                countX++;
            }
            if (countY == matrix.length) {
                y++;
                countY = 1;
            } else {
                countY++;
            }
        }
        int more = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = nums[more];
                more++;
            }
        }
    }

}
