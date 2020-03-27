package mastermind;

public class CodeMaker {
    private Row code;

    public CodeMaker(Row code) {
        this.code = code;
    }

    public Feedback attemptToBreak(Row attempt) {
        if (attempt.equals(code)) {
            return new Feedback("RED", "RED", "RED", "RED");
        }

        for (Peg codePeg : attempt.getPegs()) {
            if (code.getPegs().contains(codePeg)) {
                return new Feedback("WHITE");
            }
        }

        return new Feedback();
    }
}
