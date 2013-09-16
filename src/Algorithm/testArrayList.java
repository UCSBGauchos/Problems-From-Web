package Algorithm;

import java.util.ArrayList;

public class testArrayList {
	public static void main(String [] args){
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
//		ArrayList<Integer> list2 = new ArrayList<Integer>();
//		list2.add(2);
//		list2.add(1);
//		lists.add(list1);
		for(int i = 0; i<list1.size();i++){
			list1.set(i, 3);
		}
		for(int i: list1){
			System.out.println(i);
		}
	}
}
