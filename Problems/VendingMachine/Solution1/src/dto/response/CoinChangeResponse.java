package dto.response;

import data.CoinType;

import java.util.Map;

public class CoinChangeResponse {
    private final int amount;
    private final Map<CoinType, Integer> coins;

    public CoinChangeResponse(int amount, Map<CoinType, Integer> coins) {
        this.amount = amount;
        this.coins = coins;
    }

    public int getAmount() {
        return amount;
    }

    public Map<CoinType, Integer> getCoins() {
        return coins;
    }
}
