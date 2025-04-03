public class Board {
    private final PieceType[][] grid;
    private final int size;

    public Board(int size) {
        this.size = size;
        grid = new PieceType[size][size];
    }

    public void printBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(grid[i][j] == null) System.out.print("_ ");
                else System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isEmptyAtRowAndCol(int row, int col) {
        return grid[row][col] == null;
    }

    public void playAtRowAndCol(int row, int col, PieceType pieceType) {
        grid[row][col] = pieceType;
    }

    public boolean isWinner(int row, int col) {
        PieceType target = grid[row][col];
        boolean isRowWinner = isRowValid(target, row);
        boolean isColWinner = isColValid(target, col);
        boolean isDiagonalWinner = isDiagonalValid(target);
        boolean isAntiDiagonalWinner = isAntiDiagonalValid(target);

        return (isRowWinner || isColWinner || isDiagonalWinner || isAntiDiagonalWinner);
    }

    private boolean isRowValid(PieceType target, int row) {
        boolean isValid = true;
        for(int i = 0; i < this.size; i++) {
            if(grid[row][i] != target) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private boolean isColValid(PieceType target, int col) {
        boolean isValid = true;
        for(int i = 0; i < this.size; i++) {
            if(grid[i][col] != target) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private boolean isDiagonalValid(PieceType target) {
        boolean isValid = true;
        for(int i = 0, j = 0; i < this.size && j < this.size; i++, j++) {
            if(grid[i][j] != target) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private boolean isAntiDiagonalValid(PieceType target) {
        boolean isValid = true;
        for(int i = 0, j = this.size - 1; i < size && j >= 0; i++, j--) {
            if(grid[i][j] != target) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}
