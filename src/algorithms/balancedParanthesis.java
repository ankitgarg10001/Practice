package algorithms;
/**
 * 1. To check if the parenthesis are balanced.
 * @author Admin
 *
 */
public class balancedParanthesis {

	
	public static void main(String[] args) {
		String s="1=)(283)-4+(8/2)(";
		boolean b=check(s);
		System.out.println(b);
		
	}
public static boolean check(String s){
	int k=0;
	for(int i=0;i<s.length();i++){
		if(k<0){
			return false;
		}
		else if(s.charAt(i)=='('){
			k++;
		}else if(s.charAt(i)==')'){
			k--;
		}
		
	}
	if(k==0){
		return true;
	}
	return false;
}

	
}
