package ro.contezi.tennis.set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.junit.Test;

public class SetTreeEvaluatorTest {

    @Test
    public void deuceValueIsHalfWhenProbabilitiesEqual() {
        assertThat(new SetTreeEvaluator(0.61, 0.61).computeDeuceValue()).isCloseTo(0.5, offset(0.00001));
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
