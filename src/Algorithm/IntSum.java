package Algorithm;

import java.util.ArrayList;
import java.util.Hashtable;

public class IntSum {
	
	
	public ArrayList<ArrayList<Integer>> removeDup(ArrayList<ArrayList<Integer>> result){
		Hashtable<ArrayList<Integer>, Boolean> hash = new Hashtable<ArrayList<Integer>, Boolean>();
		ArrayList<ArrayList<Integer>> modifiedResult = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> path: result){
			int [] tmpArray = new int[path.size()];
			int tmpIndex = 0;
			for(int j: path){
				tmpArray[tmpIndex] = j;
				tmpIndex++;
			}
			java.util.Arrays.sort(tmpArray);
			
//			for(int i: tmpArray){
//				System.out.print(i+" ");
//			}
//			System.out.println();
			
			ArrayList<Integer> tmpList = new ArrayList<Integer>();
			for(int number: tmpArray){
				tmpList.add(number);
			}
			
			if(!hash.containsKey(tmpList)){
				hash.put(tmpList, true);
				modifiedResult.add(tmpList);
			}
		}
		return modifiedResult;
		
	}
	
	
	public ArrayList<ArrayList<Integer>> getAllPossible(int [] numberArray){
		int i = numberArray[0];
		int [] remain = new int[numberArray.length-1]; 
		for(int index=1;index<numberArray.length;index++){
			remain[index-1] = numberArray[index];
			//System.out.print(remain[index-1]+" ");
		}
		//System.out.println();
		if(numberArray.length==1){
			ArrayList<Integer> list = new ArrayList<Integer>();
			ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
			list.add(1);
			lists.add(list);
			return lists;
		}
		ArrayList<ArrayList<Integer>> previouslists = getAllPossible(remain);
		ArrayList<ArrayList<Integer>> newLists = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> prevuiousList: previouslists){
			for(int j=0;j<prevuiousList.size();j++){
				int number = prevuiousList.get(j);
				prevuiousList.set(j, number+1);
				ArrayList<Integer> newList = new ArrayList<Integer>();
				newList.addAll(prevuiousList);
				newLists.add(newList);
				prevuiousList.set(j, number);
				
			}
			prevuiousList.add(i);
			newLists.add(prevuiousList);
		}
		return newLists;
	}
	
	public int [] intToArray(int number){
		int [] result = new int[number];
		for(int i=0;i<number;i++){
			result[i] = 1;
		}
		return result;
	}
	
	public static void main(String [] args){
		IntSum is = new IntSum();
		int [] array = is.intToArray(4);
		ArrayList<ArrayList<Integer>> result = is.getAllPossible(array);
		ArrayList<ArrayList<Integer>> modifiedResult = is.removeDup(result);
		for(ArrayList<Integer> possible: modifiedResult){
			for(int i: possible){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
