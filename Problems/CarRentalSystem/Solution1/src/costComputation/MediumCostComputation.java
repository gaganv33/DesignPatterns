package costComputation;

public class MediumCostComputation extends CostComputation {
    private static volatile CostComputation instance;
    private MediumCostComputation(double basePrice, double pricePerDay, double penaltyPerDay) {
        super(basePrice, pricePerDay, penaltyPerDay);
    }

    public static CostComputation getInstance() {
        if(instance == null) {
            synchronized (MediumCostComputation.class) {
                if(instance == null) {
                    instance = new MediumCostComputation(CostComputationData.MEDIUM_CAR_BASE_PRICE, CostComputationData.MEDIUM_CAR_PRICE_PER_DAY, CostComputationData.MEDIUM_CAR_PENALTY_PER_DAY);
                }
            }
        }
        return instance;
    }
}
