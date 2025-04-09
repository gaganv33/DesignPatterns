import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private final Cell[][] cells;
    private final int size;

    public Board(int size, int snakeCount, int ladderCount) {
        cells = new Cell[size][size];
        this.size = size;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
        initializeLadders(ladderCount);
        initializeSnakes(snakeCount);
    }

    private void initializeSnakes(int snakeCount) {
        int i = 0;
        while(i < snakeCount) {
            int snakeHead = ThreadLocalRandom.current().nextInt(0, (size * size));
            int snakeTail = ThreadLocalRandom.current().nextInt(0, (size * size));

            if(snakeHead <= snakeTail) continue;
            System.out.println("Snake Placed at: " + snakeHead + " " + snakeTail);
            Cell cell = getCell(snakeHead);
            cell.setJump(new Jump(snakeHead, snakeTail));
            i++;
        }
    }

    private void initializeLadders(int ladderCount) {
        int i = 0;
        while(i < ladderCount) {
            int ladderHead = ThreadLocalRandom.current().nextInt(0, (size * size));
            int ladderTail = ThreadLocalRandom.current().nextInt(0, (size * size));

            if(ladderHead >= ladderTail) continue;
            System.out.println("Ladder Placed at: " + ladderHead + " " + ladderTail);
            Cell cell = getCell(ladderHead);
            cell.setJump(new Jump(ladderHead, ladderTail));
            i++;
        }
    }

    public Cell getCell(int position) {
        int row = position / size;
        int col;
        if(row % 2 == 0) {
            col = (position % 10);
        } else {
            col = (size - 1 - (position % 10));
        }
        return cells[row][col];
    }
}
