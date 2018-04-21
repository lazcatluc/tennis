package ro.contezi.tennis.tiebreak;

import static org.assertj.core.api.Assertions.assertThat;
import static ro.contezi.tennis.tiebreak.TiebreakGameEvaluator.POINTS_TO_WIN;

import org.junit.Test;

public class TiebreakStateTest {
    @Test
    public void servesFirstInTheBeginning() throws Exception {
        assertThat(new TiebreakState(0, 0).firstServerServesNow()).isTrue();
    }

    @Test
    public void servesSecondForTheSecondPoint() throws Exception {
        assertThat(new TiebreakState(1, 0).firstServerServesNow()).isFalse();
    }

    @Test
    public void servesSecondForTheThirdPoint() throws Exception {
        assertThat(new TiebreakState(2, 0).firstServerServesNow()).isFalse();
    }

    @Test
    public void servesFirstForTheFourthPoint() throws Exception {
        assertThat(new TiebreakState(3, 0).firstServerServesNow()).isTrue();
    }

    @Test
    public void serversFirstOnDeuce() throws Exception {
        assertThat(new TiebreakState(POINTS_TO_WIN, POINTS_TO_WIN).firstServerServesNow()).isTrue();
    }

    @Test
    public void serversSecondOnDeucePlus1() throws Exception {
        assertThat(new TiebreakState(POINTS_TO_WIN + 1, POINTS_TO_WIN).firstServerServesNow()).isFalse();
    }

    @Test
    public void serversSecondOnDeucePlus2() throws Exception {
        assertThat(new TiebreakState(POINTS_TO_WIN + 1, POINTS_TO_WIN + 1).firstServerServesNow()).isFalse();
    }
}