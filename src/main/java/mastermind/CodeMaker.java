package mastermind;

public class CodeMaker {
    private Row row;

    public CodeMaker(Row row) {
        this.row = row;
    }

    public Feedback attemptToBreak(Row code) {
        if (code.equals(row)) {
            return new Feedback("RED", "RED", "RED", "RED");
        }

        return new Feedback();
    }
}
