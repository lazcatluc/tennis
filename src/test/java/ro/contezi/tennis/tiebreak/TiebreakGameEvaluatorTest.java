package ro.contezi.tennis.tiebreak;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.junit.Test;

public class TiebreakGameEvaluatorTest {

    @Test
    public void deuceValueFavorsPlayerWithGreaterProbability() {
        assertThat(new TiebreakGameEvaluator(0.71, 0.61)
                .getEstimatedScore(new TiebreakState(6, 6))).isGreaterThan(0.5);

        assertThat(new TiebreakGameEvaluator(0.61, 0.71)
                .getEstimatedScore(new TiebreakState(6, 6))).isLessThan(0.5);
    }

    @Test
    public void deuceValueIsHalfWhenProbabilitiesEqual() {
        assertThat(new TiebreakGameEvaluator(0.71, 0.71)
                .getEstimatedScore(new TiebreakState(6, 6))).isCloseTo(0.5, offset(0.00001));
    }

    @Test
    public void deuceValueIsOneWhenFirstServerIsInfinitelyBetter() {
        assertThat(new TiebreakGameEvaluator(1.0, 0)
                .getEstimatedScore(new TiebreakState(6, 6))).isEqualTo(1.0);
    }

    @Test
    public void deuceValueIsZeroWhenFirstReceiverIsInfinitelyBetter() {
        assertThat(new TiebreakGameEvaluator(1.0, 0)
                .getEstimatedScore(new TiebreakState(6, 6))).isEqualTo(1.0);
    }

    @Test
    public void initialValueIsHalfWhenProbabilitiesEqual() {
        assertThat(new TiebreakGameEvaluator(0.3, 0.3)
                .getEstimatedScore(new TiebreakState(0, 0))).isCloseTo(0.5, offset(0.00001));
    }

    @Test
    public void initialValueIsOneWhenFirstServerHasWon() {
        assertThat(new TiebreakGameEvaluator(0.3, 0.3)
                .getEstimatedScore(new TiebreakState(6, 0))).isEqualTo(1.0);
    }

    @Test
    public void initialValueIsZeroWhenFirstReceiverHasWon() {
        assertThat(new TiebreakGameEvaluator(0.3, 0.3)
                .getEstimatedScore(new TiebreakState(0, 6))).isEqualTo(0.0);
    }
}