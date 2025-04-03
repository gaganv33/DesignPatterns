import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class GameManager {
    private final Deque<Player> players;
    private final Board board;
    private final int size;

    public GameManager(Deque<Player> players, int size) {
        this.players = players;
        this.board = new Board(size);
        this.size = size;
    }

    public void play() {
        if(players.isEmpty()) {
            System.out.println("no players");
            return;
        }
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < (size * size); i++) {
            Player player = getFrontPlayer();
            if(player == null) {
                continue;
            }
            board.printBoard();
            System.out.println(player.name() + " turn");

            System.out.println("Enter the row(0-" + Integer.toString(size - 1) + "): ");
            int row = sc.nextInt();
            System.out.println("Enter the col(0-" + Integer.toString(size - 1) + "): ");
            int col = sc.nextInt();

            if(checkRow(player, row)) continue;
            if(checkCol(player, col)) continue;

            if(!board.isEmptyAtRowAndCol(row, col)) {
                System.out.println("The slot is already filled");
                addPlayerAtFront(player);
                continue;
            }
            board.playAtRowAndCol(row, col, player.symbol());
            if(board.isWinner(row, col)) {
                System.out.println(player.name() + " is the winner");
                return;
            }
            addPlayerAtEnd(player);
        }
        System.out.println("Tie");
    }

    private boolean checkRow(Player player, int row) {
        if(row < 0 || row >= size) {
            System.out.println("Invalid row");
            addPlayerAtFront(player);
            return true;
        }
        return false;
    }

    private boolean checkCol(Player player, int col) {
        if(col < 0 || col >= size) {
            System.out.println("Invalid col");
            addPlayerAtFront(player);
            return true;
        }
        return false;
    }

    private Player getFrontPlayer() {
        return players.pollFirst();
    }

    private void addPlayerAtEnd(Player player) {
        players.addLast(player);
    }

    private void addPlayerAtFront(Player player) {
        players.addFirst(player);
    }
}
