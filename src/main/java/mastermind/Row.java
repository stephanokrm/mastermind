package mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Row {
    private List<Peg> pegs = new ArrayList<>();

    public void addPeg(Peg peg) {
        pegs.add(peg);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return Objects.equals(pegs, row.pegs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pegs);
    }
}
