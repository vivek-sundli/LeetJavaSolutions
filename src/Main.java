import java.util.*;


public class Main{


    public static void main(String[] args){
        //write input for nextPermutation from Solution class
        Solution s = new Solution();
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        s.nextPermutation(nums1);
        //print nums1
        System.out.println(Arrays.toString(nums1));

    }
}