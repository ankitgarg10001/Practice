package recursion.backtracking;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ankit
 */
public class Eightqueen2 {

    static int a[][] = new int[8][8];
    static int q = 0;

    /**
     * @param args the command line arguments
     */
    static boolean putqueen(int i) {
        if (q == 8) {

            return true;

        }

        for (int k = 0; k < 8; k++) {
            if (issafe(k, i)) {
                a[k][i] = 1;
                ++q;
                if (putqueen((i + 1) % 8)) {
                    return true;
                }
                a[k][i] = 0;
                --q;

            }

        }
        return false;
    }

    static boolean issafe(int row, int col) {
        int i, j;
        for (i = 0; i < 8; i++) {
            if (a[row][i] > 0) {
                return false;
            }
            if (a[i][col] > 0) {
                return false;
            }
        }


//check for upper diagonal 
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (a[i][j] > 0) {
                return false;
            }
        } //check for lower diagonal 
        for (i = row, j = col; i < 8 && j >= 0; i++, j--) {
            if (a[i][j] > 0) {
                return false;
            }
        }
        for (i = row, j = col; i < 8 && j < 8; i++, j++) {
            if (a[i][j] > 0) {
                return false;
            }
        } //check for lower diagonal 
        for (i = row, j = col; i >= 0 && j < 8; i--, j++) {
            if (a[i][j] > 0) {
                return false;
            }
        }


        return true;


    }

    public static void main(String[] args) {
        // TODO code application logic here
        //for (int x = 0; x < 8; x++) {
            q=0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    a[i][j]=0;
                }
            }
            putqueen(1);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(a[i][j] + "  ");
                }
                System.out.println("");
            }
            System.out.println("" + q);
       // }
    }
}
