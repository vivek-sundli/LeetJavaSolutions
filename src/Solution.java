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
}