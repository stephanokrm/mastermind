package mastermind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CodeMakerTest {
    @Test
    public void exactMatchGetsFourRedPegs() {

        // given
        Row code = new Row();
        code.addPeg(new Peg("BLUE"));
        code.addPeg(new Peg("RED"));
        code.addPeg(new Peg("YELLOW"));
        code.addPeg(new Peg("GREEN"));

        Row rightCode = new Row();
        rightCode.addPeg(new Peg("BLUE"));
        rightCode.addPeg(new Peg("RED"));
        rightCode.addPeg(new Peg("YELLOW"));
        rightCode.addPeg(new Peg("GREEN"));

        // when
        CodeMaker codeMaker = new CodeMaker(code);
        Feedback feedback = codeMaker.attemptToBreak(rightCode);

        // then
        assertEquals(new Feedback("RED", "RED", "RED", "RED"), feedback);
    }

    @Test
    public void noMatchingColorsGetsNoPins(){
        //given
        Row code = new Row();
        code.addPeg(new Peg("BLUE"));
        code.addPeg(new Peg("RED"));
        code.addPeg(new Peg("YELLOW"));
        code.addPeg(new Peg("GREEN"));

        Row wrongCode = new Row();
        wrongCode.addPeg(new Peg("BLACK"));
        wrongCode.addPeg(new Peg("PURPLE"));
        wrongCode.addPeg(new Peg("ORANGE"));
        wrongCode.addPeg(new Peg("MAGENTA"));

        // when
        CodeMaker codeMaker = new CodeMaker(code);
        Feedback feedback = codeMaker.attemptToBreak(wrongCode);

        // then
        assertEquals(new Feedback(), feedback);
    }
}
