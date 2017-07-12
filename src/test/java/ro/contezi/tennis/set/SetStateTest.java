package ro.contezi.tennis.set;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SetStateTest {

    @Test
    public void resultIsUndecidedInitially() {
        assertThat(newSetState(0, 0).getResult()).isEqualTo(SetResult.UNDECIDED);
    }

    @Test
    public void resultIsFirstServerWinsAt64() {
        assertThat(newSetState(6, 4).getResult()).isEqualTo(SetResult.FIRST_SERVER_WINS);
    }
    
    @Test
    public void resultIsUndecidedAt65() {
        assertThat(newSetState(6, 5).getResult()).isEqualTo(SetResult.UNDECIDED);
    }
    
    @Test
    public void resultIsFirstServerWinsAt75() {
        assertThat(newSetState(7, 5).getResult()).isEqualTo(SetResult.FIRST_SERVER_WINS);
    }
    
    @Test
    public void resultIsFirstReceiverWinsAt46() {
        assertThat(newSetState(4, 6).getResult()).isEqualTo(SetResult.FIRST_RECEIVER_WINS);
    }
    
    @Test
    public void resultIsUndecidedAt56() {
        assertThat(newSetState(5, 6).getResult()).isEqualTo(SetResult.UNDECIDED);
    }
    
    @Test
    public void resultIsFirstReceiverWinsAt57() {
        assertThat(newSetState(5, 7).getResult()).isEqualTo(SetResult.FIRST_RECEIVER_WINS);
    }
    
    @Test
    public void resultIsUndecidedAt89() {
        assertThat(newSetState(8, 9).getResult()).isEqualTo(SetResult.UNDECIDED);
    }
    
    protected SetState newSetState(int firstServerGamesWon, int firstReceiverGamesWon) {
        return new SetState(firstServerGamesWon, firstReceiverGamesWon);
    }
}
