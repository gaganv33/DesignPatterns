package costComputation;

public class SmallCostComputation extends CostComputation {
    private static volatile CostComputation instance;
    private SmallCostComputation(double basePrice, double pricePerDay, double penaltyPerDay) {
        super(basePrice, pricePerDay, penaltyPerDay);
    }

    public static CostComputation getInstance() {
        if(instance == null) {
            synchronized (SmallCostComputation.class) {
                if(instance == null) {
                    instance = new SmallCostComputation(CostComputationData.SMALL_CAR_BASE_PRICE, CostComputationData.SMALL_CAR_PRICE_PER_DAY, CostComputationData.SMALL_CAR_PENALTY_PER_DAY);
                }
            }
        }
        return instance;
    }
}
