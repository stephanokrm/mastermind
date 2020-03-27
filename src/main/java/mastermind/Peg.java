package mastermind;

import java.util.Objects;

public class Peg {
    private final String color;

    public Peg(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peg peg = (Peg) o;
        return Objects.equals(color, peg.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
