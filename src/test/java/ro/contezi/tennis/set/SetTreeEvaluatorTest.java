package ro.contezi.tennis.set;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SetTreeEvaluatorTest {

    @Test
    public void deuceValueIsHalfWhenProbabilitiesEqualToHalf() {
        assertThat(new SetTreeEvaluator(0.5, 0.5).computeDeuceValue()).isEqualTo(0.5);
    }
    
    @Test
    public void deuceValueIsOneWhenFirstServerIsInfinitelyBetter() {
        assertThat(new SetTreeEvaluator(1.0, 0).computeDeuceValue()).isEqualTo(1.0);
    }
    @Test
    public void deuceValueIsZeroWhenFirstReceiverIsInfinitelyBetter() {
        assertThat(new SetTreeEvaluator(1.0, 0).computeDeuceValue()).isEqualTo(1.0);
    }

}
