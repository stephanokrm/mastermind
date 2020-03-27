package mastermind;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Peg> pegs = new ArrayList<>();

    public void addPeg(Peg peg) {
        pegs.add(peg);
    }
}
