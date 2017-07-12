package ro.contezi.tennis.set;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TieBreakSetStateTest extends SetStateTest {

    @Test
    public void firstServerWinsAt76() {
        assertThat(new TieBreakSetState(7, 6).getResult()).isEqualTo(SetResult.FIRST_SERVER_WINS);
    }

    @Override
    protected SetState newSetState(int firstServerGamesWon, int firstReceiverGamesWon) {
        return new TieBreakSetState(firstServerGamesWon, firstReceiverGamesWon);
    }

}
