package ro.contezi.tennis.set;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SetStateTest {

    @Test
    public void resultIsUndecidedInitially() {
        assertThat(new SetState().getResult()).isEqualTo(SetResult.UNDECIDED);
    }

    @Test
    public void resultIsFirstServerWinsAt64() {
        assertThat(new SetState(6, 4).getResult()).isEqualTo(SetResult.FIRST_SERVER_WINS);
    }
    
    @Test
    public void resultIsUndecidedAt65() {
        assertThat(new SetState(6, 5).getResult()).isEqualTo(SetResult.UNDECIDED);
    }
    
    @Test
    public void resultIsFirstServerWinsAt75() {
        assertThat(new SetState(7, 5).getResult()).isEqualTo(SetResult.FIRST_SERVER_WINS);
    }
    
    @Test
    public void resultIsFirstReceiverWinsAt46() {
        assertThat(new SetState(4, 6).getResult()).isEqualTo(SetResult.FIRST_RECEIVER_WINS);
    }
    
    @Test
    public void resultIsUndecidedAt56() {
        assertThat(new SetState(5, 6).getResult()).isEqualTo(SetResult.UNDECIDED);
    }
    
    @Test
    public void resultIsFirstReceiverWinsAt57() {
        assertThat(new SetState(5, 7).getResult()).isEqualTo(SetResult.FIRST_RECEIVER_WINS);
    }
}
