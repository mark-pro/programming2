public class MatrixHelper {
    public static int[][] createMatrix(String numbers) {
        int [][] nxn = new int[3][3];
        String[] splitNumbers = numbers.split(" ");
        for(int r = 0, k = 0 ; r < 3 ; r++) 
            for(int c = 0 ; c < 3 ; c++, k++)
                nxn[r][c] = Integer.parseInt(splitNumbers[k]);

        return nxn;
    }
}