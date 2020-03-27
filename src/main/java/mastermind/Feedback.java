package mastermind;

import java.util.Arrays;

public class Feedback {

    private final String[] pins;

    public Feedback(String... pins) {
        this.pins = pins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Arrays.equals(pins, feedback.pins);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pins);
    }
}
