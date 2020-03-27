package mastermind;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

        // when
        CodeMaker codeMaker = new CodeMaker(code);
        Feedback feedback = codeMaker.attemptToBreak(code);

        // then
        assertEquals(new Feedback("RED", "RED", "RED", "RED"), feedback);
    }
}
