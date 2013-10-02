package Algorithm;

import java.util.ArrayList;
import java.util.Hashtable;

public class BracketPair {
	
	public ArrayList<String> removeDup(ArrayList<String> list){
		ArrayList<String> newList = new ArrayList<String>();
		Hashtable<String, Boolean> hash = new Hashtable<String, Boolean>();
		for(String str: list){
			if(!hash.containsKey(str)){
				newList.add(str);
				hash.put(str, true);
			}
		}
		return newList;
		
	}
	
	public ArrayList<String> get(int n){
		if(n==1){
			String result = "()";
			ArrayList<String> list = new ArrayList<String>();
			list.add(result);
			return list;
		}
		
		ArrayList<String> preResult = get(n-1);
		ArrayList<String> curResult = new ArrayList<String>();
		for(String str: preResult){
			for(int i=0; i<=str.length(); i++){
				String newBracket = connect(str, i);
				curResult.add(newBracket);
			}
		}
		return curResult;
		
	}
	
	public String connect(String old, int j){
		String one = "()";
		String firstPart = old.substring(0, j);
		String secondPart = old.substring(j);
		String newString = firstPart+one+secondPart;
		return newString;
	}

	public static void main(String [] args){
		int n;
		BracketPair bp = new BracketPair();
		System.out.println(bp.removeDup(bp.get(2)));
		
	}
}
