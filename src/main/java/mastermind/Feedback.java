package mastermind;

import java.util.*;

public class Feedback {

    private final List<String> pins = new ArrayList<>();

    public Feedback(String... pins) {
        Collections.addAll(this.pins, pins);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(pins, feedback.pins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pins);
    }

    public void addPin(String color) {
        pins.add(color);
    }

    public List<String> getPins() {
        return pins;
    }
}
