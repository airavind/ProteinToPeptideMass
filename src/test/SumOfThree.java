package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThree {
	
	public static List<List<Integer>> sumOfThreeNaive(int[] a, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < a.length - 2; i++) {
			for (int j = i + 1; j < a.length - 1; j++) {
				for (int k = j + 1; k < a.length; k++) {
					if (a[i] + a[j] + a[k] == sum) {
						result.add(Arrays.asList(a[i], a[j], a[k]));
					}
				}
			}
		}
		return result;
	}
	
	// first sort the array
	// start from the index after i and last index
	// move those indices towards each other
	public static List<List<Integer>> sumOfThree(int[] a, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(a);
		int l, r;
		for (int i = 0; i < a.length - 2; i++) {
			l = i + 1;
			r = a.length - 1;
			while (l < r) {
				if (a[i] + a[l] + a[r] == sum) {
					result.add((Arrays.asList(a[i], a[l], a[r])));
					l++;
				} else if (a[i] + a[l] + a[r] < sum) {
					l++;
				} else {
					r--;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 3, 7, 8, 3, 9, 2, 4, 10 };
		List<List<Integer>> triplets;
		triplets = sumOfThreeNaive(a, 13);
		// triplets = sumOfThree(a, 13);
		for (List<Integer> list : triplets) {
			for (int triplet : list) {
				System.out.print(triplet + " ");
			}
			System.out.println();
		}
	}
}