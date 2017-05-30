import java.util.function.BiFunction;

public class MagicSquare {
    private int[][] nxn = new int[3][3];
    private int[] sums = new int[8];
    public MagicSquare(int[][] nxn) {
        this.nxn = nxn;
    }

    public boolean isMagicSquare() {

        return false;
    }

    /* 
        To sum a row the row number does not change, the column does
        To so a colum the row number changes but the column does not
        To sum a diagnal the row number increases by one a the column number decreases by one
     */
    public int sum(BiFunction<Integer, Integer, int[]> func) {
        int sum = 0;
        for(int i = 0, j = 0; i < 3 && j < 3;) {
            int[] result = func.apply(i, j);
            i += result[0]; j+= result[1]; sum += result[2];
        }

        return sum;
    }

    @Override
    public String toString() {
        String matrixString = "";
        for(int i = 0 ; i < this.nxn.length; i++) {
            for(int j = 0; j < this.nxn[0].length; j++)
                matrixString += String.format("%d ", this.nxn[i][j]);
            
            matrixString += '\n';
        }


        return matrixString.trim();
    }
}