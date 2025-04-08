package costComputation;

import car.CarType;

public class CostComputationFactory {
    public static CostComputation getCostComputation(CarType carType) {
        return switch (carType) {
            case SMALL -> SmallCostComputation.getInstance();
            case MEDIUM -> MediumCostComputation.getInstance();
            case LARGE -> LargeCostComputation.getInstance();
        };
    }
}
