package test;

import java.util.ArrayList;
import java.util.List;

public class twoLists {
	
	static double[] arr1 = { 1.0, 2.0, 3.0 };
	static double[] arr2 = { 4.0, 5.0 };
	
	static void print(Double[] store, int depth) {
		
		for (double c : arr2) {
			List<Double> result = new ArrayList<Double>();
			List<ArrayList<Double>> listResult = new ArrayList<ArrayList<Double>>();
			if (depth < store.length) {
				store[depth] = c;
				print(store, depth + 1);
			} else {
				for (int i = 0; i < store.length; i++) {
					result.add((double) (arr1[i] + store[i]));
					listResult.add(new ArrayList(result));
				}
				result.add((double) (arr1[depth] + c));
				listResult.add(new ArrayList(result));
				System.out.println(result);
			}
		}
	}
	
	public static void main(String[] args) {
		
		List<Double> result = new ArrayList<Double>();
		print(new Double[arr1.length - 1], 0);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println("Hello");
		}
	}
}