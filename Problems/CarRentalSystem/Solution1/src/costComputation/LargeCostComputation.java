package costComputation;

public class LargeCostComputation extends CostComputation {
    private static volatile CostComputation instance;
    private LargeCostComputation(double basePrice, double pricePerDay, double penaltyPerDay) {
        super(basePrice, pricePerDay, penaltyPerDay);
    }

    public static CostComputation getInstance() {
        if(instance == null) {
            synchronized (LargeCostComputation.class) {
                if(instance == null) {
                    instance = new LargeCostComputation(CostComputationData.LARGE_CAR_BASE_PRICE, CostComputationData.LARGE_CAR_PRICE_PER_DAY, CostComputationData.LARGE_CAR_PENALTY_PER_DAY);
                }
            }
        }
        return instance;
    }
}
