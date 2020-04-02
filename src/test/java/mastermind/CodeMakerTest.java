package mastermind;

import org.assertj.core.api.Assertions;
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
        Assertions.assertThat(feedback.getPins()).containsExactly("RED", "RED", "RED", "RED");
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
        Assertions.assertThat(feedback.getPins()).isEmpty();
    }

    @Test
    public void oneMatchingColorOnWrongPlaceGetsOneWhitePin(){
        //given
        Row code = new Row();
        code.addPeg(new Peg("BLUE"));
        code.addPeg(new Peg("RED"));
        code.addPeg(new Peg("YELLOW"));
        code.addPeg(new Peg("GREEN"));

        Row oneMatchingColorWithWrongPlaceCode = new Row();
        oneMatchingColorWithWrongPlaceCode.addPeg(new Peg("BLACK"));
        oneMatchingColorWithWrongPlaceCode.addPeg(new Peg("PURPLE"));
        oneMatchingColorWithWrongPlaceCode.addPeg(new Peg("BLUE"));
        oneMatchingColorWithWrongPlaceCode.addPeg(new Peg("MAGENTA"));

        // when
        CodeMaker codeMaker = new CodeMaker(code);
        Feedback feedback = codeMaker.attemptToBreak(oneMatchingColorWithWrongPlaceCode);

        // then
        Assertions.assertThat(feedback.getPins()).containsExactly("WHITE");
    }

    @Test
    public void oneMatchingColorOnRightPlaceGetsOneRedPin(){
        //given
        Row code = new Row();
        code.addPeg(new Peg("BLUE"));
        code.addPeg(new Peg("RED"));
        code.addPeg(new Peg("YELLOW"));
        code.addPeg(new Peg("GREEN"));

        Row oneMatchingColorWithRightPlaceCode = new Row();
        oneMatchingColorWithRightPlaceCode.addPeg(new Peg("BLUE"));
        oneMatchingColorWithRightPlaceCode.addPeg(new Peg("PURPLE"));
        oneMatchingColorWithRightPlaceCode.addPeg(new Peg("ORANGE"));
        oneMatchingColorWithRightPlaceCode.addPeg(new Peg("MAGENTA"));

        // when
        CodeMaker codeMaker = new CodeMaker(code);
        Feedback feedback = codeMaker.attemptToBreak(oneMatchingColorWithRightPlaceCode);

        // then
        Assertions.assertThat(feedback.getPins()).containsExactly("RED");
    }

    @Test
    public void twoMatchingColorsOneBeingRightPositionedGetsOneRedPinAndOneWhitePin(){
        //given
        Row code = new Row();
        code.addPeg(new Peg("BLUE"));
        code.addPeg(new Peg("MAGENTA"));
        code.addPeg(new Peg("YELLOW"));
        code.addPeg(new Peg("GREEN"));

        Row twoMatchingColorsOneRightPlaceOneWrongPlaceCode = new Row();
        twoMatchingColorsOneRightPlaceOneWrongPlaceCode.addPeg(new Peg("BLUE"));
        twoMatchingColorsOneRightPlaceOneWrongPlaceCode.addPeg(new Peg("PURPLE"));
        twoMatchingColorsOneRightPlaceOneWrongPlaceCode.addPeg(new Peg("ORANGE"));
        twoMatchingColorsOneRightPlaceOneWrongPlaceCode.addPeg(new Peg("MAGENTA"));

        // when
        CodeMaker codeMaker = new CodeMaker(code);
        Feedback feedback = codeMaker.attemptToBreak(twoMatchingColorsOneRightPlaceOneWrongPlaceCode);

        // then
        Assertions.assertThat(feedback.getPins()).containsExactlyInAnyOrder("RED", "WHITE");
    }

    @Test
    public void getTwoWhitsAndOneRedAsFeedback(){
        //given
        Row code = new Row();
        code.addPeg(new Peg("BLUE"));
        code.addPeg(new Peg("MAGENTA"));
        code.addPeg(new Peg("YELLOW"));
        code.addPeg(new Peg("GREEN"));

        Row twoRightColorsAndOneRightPositionCode = new Row();
        twoRightColorsAndOneRightPositionCode.addPeg(new Peg("BLUE"));
        twoRightColorsAndOneRightPositionCode.addPeg(new Peg("YELLOW"));
        twoRightColorsAndOneRightPositionCode.addPeg(new Peg("ORANGE"));
        twoRightColorsAndOneRightPositionCode.addPeg(new Peg("MAGENTA"));

        // when
        CodeMaker codeMaker = new CodeMaker(code);
        Feedback feedback = codeMaker.attemptToBreak(twoRightColorsAndOneRightPositionCode);

        // then
        Assertions.assertThat(feedback.getPins()).containsExactlyInAnyOrder("RED", "WHITE", "WHITE");
    }

    @Test
    public void getTwoRedsAndOneWhiteAsFeedback(){
        //given
        Row code = new Row();
        code.addPeg(new Peg("BLUE"));
        code.addPeg(new Peg("MAGENTA"));
        code.addPeg(new Peg("YELLOW"));
        code.addPeg(new Peg("GREEN"));

        Row twoRightPositionsAndOneRightColorCode = new Row();
        twoRightPositionsAndOneRightColorCode.addPeg(new Peg("BLUE"));
        twoRightPositionsAndOneRightColorCode.addPeg(new Peg("MAGENTA"));
        twoRightPositionsAndOneRightColorCode.addPeg(new Peg("ORANGE"));
        twoRightPositionsAndOneRightColorCode.addPeg(new Peg("YELLOW"));

        // when
        CodeMaker codeMaker = new CodeMaker(code);
        Feedback feedback = codeMaker.attemptToBreak(twoRightPositionsAndOneRightColorCode);

        // then
        Assertions.assertThat(feedback.getPins()).containsExactlyInAnyOrder("RED", "RED", "WHITE");
    }

    @Test
    public void getOneRedAndOneWhiteForTheSameColorAsFeedback(){
        //given
        Row code = new Row();
        code.addPeg(new Peg("BLUE"));
        code.addPeg(new Peg("MAGENTA"));
        code.addPeg(new Peg("MAGENTA"));
        code.addPeg(new Peg("GREEN"));

        Row oneRightPositionAndOneRightColorCode = new Row();
        oneRightPositionAndOneRightColorCode.addPeg(new Peg("RED"));
        oneRightPositionAndOneRightColorCode.addPeg(new Peg("MAGENTA"));
        oneRightPositionAndOneRightColorCode.addPeg(new Peg("ORANGE"));
        oneRightPositionAndOneRightColorCode.addPeg(new Peg("MAGENTA"));

        // when
        CodeMaker codeMaker = new CodeMaker(code);
        Feedback feedback = codeMaker.attemptToBreak(oneRightPositionAndOneRightColorCode);

        // then
        Assertions.assertThat(feedback.getPins()).containsExactlyInAnyOrder("RED", "WHITE");
    }
}
