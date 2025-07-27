import java.util.*;

class Solution {

    public void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse_array(int[] arr,int left, int right){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        //given
        int n = nums.length;
        int pivot =-1;
        //To prove
        //start from the end
        //find the pivot
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1){
            reverse_array(nums, 0, n - 1);
            return;
        }
        //find immediate smaller of the pivot element
        int smallestIndex = n - 1;
        while(nums[smallestIndex] <= nums[pivot]){
            smallestIndex--;
        }
        //swap both
        swap(nums, pivot, smallestIndex);
        reverse_array(nums, pivot + 1, n - 1);
    }

    //complete the function od SumNumbers retruning the sum of all numbers in the array
    public int sumNumbers(int[] nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        return sum;
    }

    //complete the function of Sum1stNumbers returning the sum of first n natural numbers
    public int sum1stNumbers(int[] nums){
        int n = nums.length;
        return (n * (n + 1)) / 2;
    }
    //complete the function of SumSquare returning the sum of squares in the array
    public int sumSquare(int[] nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i] * nums[i];
        }
        return sum;
    }
    //complete the function of Sum1stSqaure returning the sum of squares of first n natural numbers
    public int sum1stSqaure(int[] nums){
        int n = nums.length;
        return (n * (n + 1) * (2 * n + 1)) / 6;
    }
    public int[] missingAndRepeating(int[] nums){
        int Sum = sumNumbers(nums);
        int Sum_1stN_NaturalNumbers = sum1stNumbers(nums);
        int Sum_SquareNaturalNumbers = sumSquare(nums);
        int Sum_1stN_SqiareNatualNumbers = sum1stSqaure(nums);
        int val1 = Sum_1stN_NaturalNumbers - Sum;
        int val2 = Sum_1stN_SqiareNatualNumbers/Sum_SquareNaturalNumbers;
        int repeating = (val1 + val2) / 2;
        int missing = val2 - repeating;
        return new int[]{missing, repeating};
    }
    // complete the function of fourSum returning all unique quadruplets in the array that sum up to the target
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++; // skip duplicates
                        while (left < right && nums[right] == nums[right - 1]) right--; // skip duplicates
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}