package ro.contezi.tennis.set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.junit.Test;

public class TiebreakSetTreeEvaluatorTest {

    @Test
    public void deuceValueIsHalfWhenProbabilitiesEqual() {
        assertThat(new TiebreakSetTreeEvaluator(0.61, 0.61)
                .getEstimatedScore(new SetState(6, 6))).isCloseTo(0.5, offset(0.00001));
    }
    
    @Test
    public void deuceValueIsOneWhenFirstServerIsInfinitelyBetter() {
        assertThat(new TiebreakSetTreeEvaluator(1.0, 0)
                .getEstimatedScore(new SetState(6, 6))).isEqualTo(1.0);
    }
    
    @Test
    public void deuceValueIsZeroWhenFirstReceiverIsInfinitelyBetter() {
        assertThat(new TiebreakSetTreeEvaluator(1.0, 0)
                .getEstimatedScore(new SetState(6, 6))).isEqualTo(1.0);
    }

    @Test
    public void initialValueIsHalfWhenProbabilitiesEqual() {
        assertThat(new TiebreakSetTreeEvaluator(0.3, 0.3)
                .getEstimatedScore(new SetState(0, 0))).isCloseTo(0.5, offset(0.00001));
    }
    
    @Test
    public void initialValueIsOneWhenFirstServerHasWon() {
        assertThat(new TiebreakSetTreeEvaluator(0.3, 0.3)
                .getEstimatedScore(new SetState(6, 0))).isEqualTo(1.0);
    }
    
    @Test
    public void initialValueIsZeroWhenFirstReceiverHasWon() {
        assertThat(new TiebreakSetTreeEvaluator(0.3, 0.3)
                .getEstimatedScore(new SetState(0, 6))).isEqualTo(0.0);
    }
}
