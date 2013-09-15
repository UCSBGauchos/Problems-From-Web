package Algorithm;

import java.util.Stack;

public class StringBracket {
	
	boolean hasRight;
	Stack<Character> rightCol = new Stack<Character>();
	public boolean isPair(String str){
		char c = str.charAt(0);
		String remain = str.substring(1);
		if(remain.length()==1){
			if(remain.charAt(0)=='('){
				return false;
			}
			if(remain.charAt(0)==')'){
				hasRight = true;
			}
			if(c==')'&&hasRight==false){
				hasRight=true;
				return true;
			}else if(c==')'&&hasRight==true){
				rightCol.push(')');
				return true;
			}else if(c=='('&&hasRight==false){
				return false;
			}else if(c=='('&&hasRight==true&&rightCol.size()==0){
				hasRight = false;
				return true;
			}else if(c=='('&&hasRight==true&&rightCol.size()!=0){
				rightCol.pop();
				return true;
			}else{
				return true;
			}
		}
		boolean result = isPair(remain);
		if(result){
			if(c==')'&&hasRight==false){
				hasRight=true;
			}else if(c==')'&&hasRight==true){
				rightCol.push(')');
			}else if(c=='('&&hasRight==false){
				return false;
			}else if(c=='('&&hasRight==true&&rightCol.size()==0){
				hasRight = false;
			}else if(c=='('&&hasRight==true&&rightCol.size()!=0){
				rightCol.pop();
			}
		}
		if((c+remain).equals("(abcd(e)))")){
			if(rightCol.size()!=0||hasRight==true){
				return false;
			}
		}
		return result;
	}
	
	public static void main(String [] args){
		StringBracket sb = new StringBracket();
		String str = "(abcd(e))";
		sb.hasRight = false;
		if(sb.isPair(str)){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}
}
