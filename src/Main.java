import java.util.*;


public class Main{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> st = new HashSet<>();
        //        int[] nums = {1, -2, 3, 5, 7, 9};
        //        int target = 7;
        for(int i=0 ; i<nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j=i+1 ; j<nums.length ; j++){
                int complement = target-nums[i]-nums[j];
                int right = nums.length-1;
                int left = j+1;

                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                while(left < right){
                    if(complement == nums[left]+nums[right]){
                        List<Integer> temp = Arrays.asList(nums[left],nums[right],nums[i],nums[j]);
                        Collections.sort(temp);
                        st.add(temp);
                        while(left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right-1]){
                            right--;
                        }
                    }
                    if(complement < nums[left]+nums[right]){
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> x : st){
            ans.add(x);
        }
        return ans;
    }

    public static void main(String[] args){
        //write input for nextPermutation from Solution class
        Solution s = new Solution();
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        s.nextPermutation(nums1);
        //print nums1
        System.out.println(Arrays.toString(nums1));

    }
}