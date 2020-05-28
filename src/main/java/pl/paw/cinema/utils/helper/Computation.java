package pl.paw.cinema.utils.helper;

import java.util.List;

public class Computation {

    public static double calcAvg(List<Integer> numbers) {
        double sum = numbers.stream().reduce(0, Integer::sum).doubleValue();
        return (sum / numbers.size());
    }
}
