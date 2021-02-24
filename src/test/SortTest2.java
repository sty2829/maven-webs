package test;

public class SortTest2 {

	public static void main(String[] args) {
		
		int[] nums = {5, 1, 10, 3};
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		for(int n : nums) {
			System.out.println(n);
		}
		
	}
}
