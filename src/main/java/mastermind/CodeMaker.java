package mastermind;

import java.util.List;

public class CodeMaker {
    private Row code;

    public CodeMaker(Row code) {
        this.code = code;
    }

    public Feedback attemptToBreak(Row attempt) {
        if (attempt.equals(code)) {
            return new Feedback("RED", "RED", "RED", "RED");
        }

        List<Peg> attemptPegs = attempt.getPegs();
        List<Peg> codePegs = code.getPegs();
        Feedback feedback = new Feedback();

        for (int attemptPosition = 0; attemptPosition < attemptPegs.size(); attemptPosition++) {
            if (codePegs.contains(attemptPegs.get(attemptPosition))) {
                boolean hasRedFeedback = currentPositionHasRedFeedback(attemptPegs, codePegs, attemptPosition);
                giveFeedback(feedback, hasRedFeedback);
            }
        }


        return feedback;
    }

    private boolean currentPositionHasRedFeedback(List<Peg> attemptPegs, List<Peg> codePegs, int attemptPosition) {
        for (int codePosition = 0; codePosition < codePegs.size(); codePosition++) {
            if (isSameColorAndPosition(attemptPegs, codePegs, attemptPosition, codePosition)) {
                return true;
            }
        }
        return false;
    }

    private void giveFeedback(Feedback feedback, boolean hasRedFeedback) {
        if (hasRedFeedback) {
            feedback.addPin("RED");
        } else {
            feedback.addPin("WHITE");
        }
    }

    private boolean isSameColorAndPosition(List<Peg> attemptPegs, List<Peg> codePegs, int attemptPosition, int codePosition) {
        return attemptPegs.get(attemptPosition).equals(codePegs.get(codePosition)) && attemptPosition == codePosition;
    }
}
