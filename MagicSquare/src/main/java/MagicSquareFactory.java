public class MagicSquareFactory {
    public static MagicSquare createMatrix(String numbers) {
        int [][] nxn = new int[3][3];
        String[] splitNumbers = numbers.split(" ");
        for(int r = 0, i = 0 ; r < 3 ; r++) 
            for(int c = 0 ; c < 3 ; c++)
                nxn[r][c] = Integer.parseInt(splitNumbers[i++]);

        return new MagicSquare(nxn);
    }
}