package com.ade.T57.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
	/**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	Arrays.sort(numbers);
    	int head,tail,target,r;
    	for (int i = 0; i < numbers.length - 2; i++) {
    		tail = numbers.length - 1;
			target =  0 - numbers[i];
			head = i + 1;
			while ( head < tail ){
				r = numbers[head] + numbers[tail];
				if ( r == target ){
					List<Integer> list = new ArrayList<Integer>();
					list.add(numbers[i]);
					list.add(numbers[head]);
					list.add(numbers[tail]);
					result.add(list);
					
					//收敛
					while( head < tail && numbers[head] == numbers[head + 1]) head++;
					while( head < tail && numbers[tail] == numbers[tail - 1]) tail--;
					//最后一组重复值 所以head tail 都需要移动
					head++;
					tail--;
					
				} else if ( r < target ) {
					head++;
				} else {
					tail--;
				}
			}
			while ( (i < numbers.length - 2) && numbers[i] == numbers[ i + 1 ] ) 
				i++;
			
		}
    	return result;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		List<List<Integer>> result = s.threeSum(new int[]{-2,-3,-4,-5,-100,99,1,4,4,4,5,1,0,-1,2,3,4,5});
		for (List<Integer> list : result) {
			System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
		}
	}
}
