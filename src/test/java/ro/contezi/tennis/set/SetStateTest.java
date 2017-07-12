package ro.contezi.tennis.set;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SetStateTest {

    @Test
    public void resultIsUndecidedInitially() {
        assertThat(new SetState().getResult()).isEqualTo(SetResult.UNDECIDED);
    }

}
