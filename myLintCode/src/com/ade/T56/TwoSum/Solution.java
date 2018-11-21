package com.ade.T56.TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
    	Map<Integer, Integer> m = new HashMap<>();
    	for (int i = 0; i < numbers.length; i++) {
			m.put(numbers[i], i);
		}
    	int[] result = new int[2];
    	for (int i = 0; i < numbers.length; i++) {
			int other = target - numbers[i];
			if ( m.containsKey(other) && m.get(other) != i) {
				result[0] = i;
				result[1] = m.get(other);
				break;
			}
		}
    	return result;
    }
    
    public static void main(String[] args) {
    	int[] numbers = new int[]{2, 7, 11, 15};
    	Solution s = new Solution();
    	int[] result = s.twoSum(numbers, 9);

    	for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
