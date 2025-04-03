import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player-1", PieceType.O);
        Player player2 = new Player("Player-2", PieceType.X);
        Deque<Player> players = new ArrayDeque<>();
        players.addLast(player1);
        players.addLast(player2);
        GameManager gameManager = new GameManager(players, 3);
        gameManager.play();
    }
}
