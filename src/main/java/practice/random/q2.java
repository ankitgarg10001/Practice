package practice.random;

public class q2 {

	public static void main(String[] args) {
		String a = "hi my name is ankit";
		System.out.println(reverseString(a));

	}

	private static String reverseString(String str) {

		int strLeng = str.length() - 1;
		String reverse = "", temp = "";

		for (int i = 0; i <= strLeng; i++) {
			
			if (str.charAt(i) != ' ') {
				temp += str.charAt(i);
			}

			if ((str.charAt(i) == ' ') || (i == strLeng)) {
				boolean caps=true;
				for (int j = temp.length()-1; j >= 0; j--) {
					if(caps){
						reverse += Character.toUpperCase(temp.charAt(j));
						caps=false;
					}else
					{
						reverse += temp.charAt(j);
					}
//					if ((j == 0) && (i != strLeng))
//						reverse += " ";
					
				}
				if(str.charAt(i)==' '){
					reverse+=" ";
				}
				temp = "";
			}
		}
		return reverse;
	}

}
