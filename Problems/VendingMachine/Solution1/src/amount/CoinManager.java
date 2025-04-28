package amount;

import data.CoinType;
import dto.response.CoinChangeResponse;
import utility.AmountComputation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinManager {
    private static volatile CoinManager instance;
    private Map<CoinType, Integer> coins;

    private CoinManager() {
        this.coins = new HashMap<>();
    }

    public static CoinManager getInstance() {
        if(instance == null) {
            instance = new CoinManager();
        }
        return instance;
    }

    public Map<CoinType, Integer> getCoins() {
        return coins;
    }

    private void setCoins(Map<CoinType, Integer> coins) {
        this.coins = coins;
    }

    public void addCoins(Map<CoinType, Integer> newCoins) {
        for(var entrySet : newCoins.entrySet()) {
            CoinType key = entrySet.getKey();
            int value = entrySet.getValue();
            coins.put(key, coins.getOrDefault(key, 0) + value);
        }
    }

    public void clearCoins() {
        setCoins(new HashMap<>());
    }

    public int getAmount() {
        return AmountComputation.getAmountCoins(coins);
    }

    public CoinChangeResponse getCoinChange(int balanceAmount) {
        int amount = 0;
        Map<CoinType, Integer> coinChange = new HashMap<>();
        List<CoinType> coinTypeList = CoinType.getCoinTypeList();

        int i = 0;
        int n = coinTypeList.size();
        while(i < n && balanceAmount > 0) {
            CoinType coinType = coinTypeList.get(i);
            int requiredCoins = (balanceAmount / coinType.getValue());
            if(requiredCoins > 0 && checkIfEnoughCoins(coinType, requiredCoins)) {
                removeCoins(coinType, requiredCoins);
                coinChange.put(coinType, requiredCoins);
                balanceAmount -= (coinType.getValue() * requiredCoins);
                amount += (coinType.getValue() * requiredCoins);
            }
            i++;
        }
        return new CoinChangeResponse(amount, coinChange);
    }

    private void removeCoins(CoinType coinType, int quantity) {
        if(coins.get(coinType) == quantity) coins.remove(coinType);
        else coins.put(coinType, coins.get(coinType) - quantity);
    }

    private boolean checkIfEnoughCoins(CoinType coinType, int target) {
        return (coins.getOrDefault(coinType, 0) >= target);
    }
}
