import java.util.function.BiFunction;

public class MagicSquare {
    private int[][] nxn;
    private int[] sums;
    public MagicSquare(int[][] nxn) {
        this.nxn = nxn;
        this.sums = new int[nxn.length * 2 + 2];
        this.calculateSums();
    }

    public boolean isMagicSquare() {
        for(int v : sums)
            if(Integer.compare(v, sums[0]) != 0)
                return false;
        return true;
    }

    /* 
        To sum a row the row number does not change, the column does
        To so a colum the row number changes but the column does not
        To sum a diagnal the row number increases by one a the column number decreases by one
     */
    private void sum(BiFunction<Integer, Integer, int[]> func) {
        for(int i = 0, j = 0; i < nxn.length && j < nxn.length;) {
            int[] result = func.apply(i, j);
            i += result[0]; j+= result[1];
        }
    }

    private void calculateSums() {
        // Sum rows
        sum((r , c) -> {
            sums[r] += nxn[r][c];
            if(c == nxn.length - 1 && r < nxn.length) { r = 1; c = 0 - nxn.length + 1; }
            else { r = 0; c = 1; }
            return new int[] {r, c};
        });
        
        // Sum cols
        sum((r , c) -> {
            sums[r + nxn.length] += nxn[c][r];
            if(c == nxn.length - 1 && r < nxn.length) { r = 1; c = 0 - nxn.length + 1; }
            else { r = 0; c = 1; }
            return new int[] {r, c};
        });

        // Sum diag down
        sum((r , c) -> {
            sums[sums.length - 2] += nxn[r][c];
            r = 1; c = 1;
            return new int[] {r, c};
        });

        // Sum diag up
        sum((r , c) -> {
            sums[sums.length - 1] += nxn[r][c + 2 - r];
            r = 1; c = 1;
            return new int[] {r, c};
        });
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