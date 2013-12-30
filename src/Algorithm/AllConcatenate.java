package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class AllConcatenate {
	
	public HashMap<String, Boolean> getAll(ArrayList<String> list){
		
		if(list.size()==1){
			HashMap<String, Boolean> result = new HashMap<String, Boolean>();
			result.put(list.get(0), true);
			return result;
		}
		
		String top = list.get(0);
		list.remove(top);
		
		HashMap<String, Boolean> cur = new HashMap<String, Boolean>();
		HashMap<String, Boolean> last = getAll(list);
		for(String s: last.keySet()){
			for(int i=0; i<=s.length(); i=i+top.length()){
				String first = s.substring(0,i);
				String second = s.substring(i);
				String newString = first+top+second;
				cur.put(newString, true);
			}
		}
		return cur;
	}
	
	public static void main(String [] args){
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, Boolean> result = new HashMap<String, Boolean>();
		list.add("ab");
		list.add("cd");
		list.add("ef");
		
		AllConcatenate a = new AllConcatenate();
		result = a.getAll(list);
		for(String s: result.keySet()){
			System.out.println(s);
		}
	}
}
