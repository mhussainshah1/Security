package review;

import java.util.ArrayList;

public class Turkey {
    private ArrayList<Double> weights;

    public Turkey(ArrayList<Double> weights) {
        this.weights = new ArrayList<>(weights);
        this.weights = (ArrayList) weights.clone();
    }
}
