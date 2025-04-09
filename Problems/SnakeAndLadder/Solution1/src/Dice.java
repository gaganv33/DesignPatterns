import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int count;

    public Dice(int count) {
        this.count = count;
    }

    public int getRandomValue() {
        int totalValue = 0;
        for(int i = 0; i < count; i++) {
            int value = ThreadLocalRandom.current().nextInt(DiceData.MIN_VALUE, DiceData.MAX_VALUE + 1);
            totalValue += value;
        }
        return totalValue;
    }
}
