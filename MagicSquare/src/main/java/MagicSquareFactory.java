import java.lang.Math;
public class MagicSquareFactory {
    public static MagicSquare createMatrix(String numbers) {
        String[] splitNumbers = numbers.split(" ");
        int root = (int) Math.sqrt(splitNumbers.length);
        int [][] nxn = new int[root][root];
        for(int r = 0, i = 0 ; r < root ; r++) 
            for(int c = 0 ; c < root ; c++)
                nxn[r][c] = Integer.parseInt(splitNumbers[i++]);

        return new MagicSquare(nxn);
    }
}