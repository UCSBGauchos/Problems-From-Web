package Algorithm;

import java.util.ArrayList;
import java.util.Hashtable;

public class MaxTowerDP {
	
	Hashtable<Box, Integer> hash = new Hashtable<Box, Integer>();
	public boolean isValid(Box top, Box bot){
		if(bot == null){
			return true;
		}
		return(top.height<bot.height);
	}
	
	public int getMaxHeight(ArrayList<Box> list, Box bottom){
		int newHeight = 0;
		int oneLoopMax = 0;
		if(bottom!=null){
			oneLoopMax = bottom.height;
		}
		for(Box b: list){
			if(isValid(b, bottom)){
				int height = 0;
				if(!hash.containsKey(b)){
					height = getMaxHeight(list, b);
					hash.put(b, height);
				}else{
					height = hash.get(b);
				}
				if(bottom!=null){
					newHeight = height+bottom.height;
				}else{
					newHeight = height;
				}
				if(newHeight>oneLoopMax){
					oneLoopMax = newHeight;
				}
			}
		}
		return oneLoopMax;
	}
	
	public static void main(String [] args){
		Box b1 = new Box(1);
		Box b2 = new Box(2);
		Box b3 = new Box(7);
		Box b4 = new Box(4);
		Box b5 = new Box(2);
		ArrayList<Box> list = new ArrayList<Box>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		
		MaxTowerDP mt = new MaxTowerDP();
		//mt.getMaxHeight(list, null);
		System.out.println(mt.getMaxHeight(list, null));
	}
}
