import java.util.ArrayList;
import java.util.List;


/**
 * 1 2 3 5 7 9
 * 0 2 4 6 8
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        List<Integer> mList = new ArrayList<>();
        int size = nums1.length + nums2.length;
        int i = 0, j = 0;
        while (size-- > 0) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    mList.add(nums1[i]);
                    i++;
                } else {
                    mList.add(nums2[j]);
                    j++;
                }
            } else {
                if (i < nums1.length) {
                    mList.add(nums1[i]);
                    i++;
                }
                if (j < nums2.length) {
                    mList.add(nums2[j]);
                    j++;
                }
            }
        }
        double index = mList.size() / 2.0;
        if (index % 1 == 0) {
            median = (mList.get((int) index) + mList.get((int) (index - 1))) / 2.0;
        } else {
            median = mList.get((int) index);
        }
        return median;
    }

    public static void main(String args[]) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
