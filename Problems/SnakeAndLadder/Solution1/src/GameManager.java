import java.util.Deque;
import java.util.LinkedList;

public class GameManager {
    private final Dice dice;
    private final Board board;
    private final Deque<Player> players;
    private final int target;

    public GameManager(int size, int playerCount, int diceCount, int snakeCount, int ladderCount) {
        this.target = (size * size) - 1;
        dice = new Dice(diceCount);
        board = new Board(size, snakeCount, ladderCount);
        players = new LinkedList<>();
        initializePlayers(playerCount);
    }

    public void playGame() {
        while(true) {
            Player player = getNextPlayer();
            int diceValue = dice.getRandomValue();
            int newPosition = player.getPosition() + diceValue;

            if(!checkIfValidCellPosition(newPosition)) {
                System.out.println(player.getName() + " new position exceeding target " + newPosition);
                addPlayerBackToQueue(player);
                continue;
            }

            Cell cell = board.getCell(newPosition);
            Jump jump = cell.getJump();
            if(jump != null) {
                newPosition = getNewPositionUsingJump(jump);
            }

            player.setPosition(newPosition);
            if(newPosition == target) {
                System.out.println(player.getName() + " has reached the target " + target);
                break;
            }
            System.out.println(player.getName() + " new position " + newPosition);
            addPlayerBackToQueue(player);
        }
    }

    private int getNewPositionUsingJump(Jump jump) {
        if(jump.getStart() > jump.getEnd()) {
            return getNewPositionUsingSnake(jump);
        } else {
            return getNewPositionUsingLadder(jump);
        }
    }

    private int getNewPositionUsingSnake(Jump jump) {
        System.out.println("Snake");
        return jump.getEnd();
    }

    private int getNewPositionUsingLadder(Jump jump) {
        System.out.println("Ladder");
        return jump.getEnd();
    }

    private void initializePlayers(int playerCount) {
        for(int i = 0; i < playerCount; i++) {
            String name = "Name-" + Integer.toString(i);
            players.offerLast(new Player(name));
        }
    }

    private Player getNextPlayer() {
        return players.pollFirst();
    }

    private void addPlayerBackToQueue(Player player) {
        players.offerLast(player);
    }

    private boolean checkIfValidCellPosition(int position) {
        return (position <= target);
    }
}
