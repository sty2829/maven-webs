package test;

public class SortTest {

	public static void main(String[] args) {
		
		int[] nums = {5, 1, 10, 3};
		
		for(int i=0; i<nums.length-1; i++) {
			for(int j=0; j<nums.length-1; j++) {
				if(nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		
		for(int n : nums) {
			System.out.println(n);
		}
		
	}
}
