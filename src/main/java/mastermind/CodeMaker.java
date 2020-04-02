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

        for(int attemptPosition = 0; attemptPosition < attemptPegs.size() ; attemptPosition++){
            if (codePegs.contains(attemptPegs.get(attemptPosition))) {
                for (int codePosition = 0; codePosition < codePegs.size() ; codePosition++){
                    if (isSameColorAndPosition(attemptPegs, codePegs, attemptPosition, codePosition)){
                        feedback.addPin("RED");
                        return feedback;
                    }
                }

                feedback.addPin("WHITE");
                return feedback;
            }
        }


        return feedback;
    }

    private boolean isSameColorAndPosition(List<Peg> attemptPegs, List<Peg> codePegs, int attemptPosition, int codePosition) {
        return attemptPegs.get(attemptPosition).equals(codePegs.get(codePosition)) && attemptPosition == codePosition;
    }
}
