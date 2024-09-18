package practice.random;

public class q4 {

	private static int output1;
	
	public static void main(String[] args) {
		int input1=4;
		String input2="{1,7,5,2},{5,12,3,6},{100,9,23,16},{16,4,5,9}";
		CollectMoney(input1, input2);
		
	}

	private static void CollectMoney(int input1, String input2) {
		Integer[][] field=new Integer[input1][input1];//  {{1,7,5,2},{5,12,3,6},{100,9,23,16},{16,4,5,9}};

		String temp1[]=input2.replace("{","").replace("}", "").split(",");
		int k=0;
		for(int i=0;i<input1;i++){
			for(int j=0;j<input1;j++){
				field[i][j]=Integer.parseInt(temp1[k++]);
			}
		}
		output1=maxValue(field);
		System.out.println(output1);
		
	}

	static int maxValue(Integer[][] field) {
	    int r = field.length;
	    int c = field[0].length;
	    int[][] maxValues = new int[r][c];
	    for (int i = 0, l=0; i < r; i++) {
	        for (int j = 0; j < c; j++) {
	            if (i == 0 && j == 0) {
	                maxValues[i][j] = field[i][j];
	            } else if (i == 0) {
	                maxValues[i][j] = maxValues[i][j-1] + field[i][j];
	            } else if (j == 0) {
	                maxValues[i][j] = maxValues[i-1][j] + field[i][j];
	            } else {
	                maxValues[i][j] = Math.max(maxValues[i][j-1], maxValues[i-1][j]) + field[i][j];
	            }
	        }
	    }
	    return maxValues[r-1][c-1];
	}
	
}
