public class Solution {
    public static boolean validUtf8(int[] data) {
        int varCharLeft = 0;
        for (int b : data) {
            if (varCharLeft == 0) {
                if ((b & 0b010000000) == 0) {
                    varCharLeft = 0;
                } else if ((b & 0b011100000) == 0b11000000) {
                    varCharLeft = 1;
                } else if ((b & 0b011110000) == 0b11100000) {
                    varCharLeft = 2;
                } else if ((b & 0b011111000) == 0b11110000) {
                    varCharLeft = 3;
                } else {
                    return false;
                }
            } else {
                if ((b & 0b011000000) != 0b10000000) {
                    return false;
                }
                varCharLeft--;
            }
        }
        return varCharLeft == 0;
    }
}
