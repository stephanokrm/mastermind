package mastermind;

import java.util.List;

public class CodeMaker {
    private Row row;
    public CodeMaker(Row row) {
        this.row = row;
    }

    public Feedback attemptToBreak(Row code) {
        return new Feedback("RED","RED","RED","RED");
    }
}
