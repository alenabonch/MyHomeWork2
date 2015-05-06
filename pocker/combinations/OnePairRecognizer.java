package hw7.pocker.combinations;

import hw7.pocker.general.Card;

import java.util.List;

/**
 * Created by alena on 03.05.15.
 */
public class OnePairRecognizer extends AbstractCombinationRecognizer {
    @Override
    protected boolean isRecognized(List<Card> fiveCards) {
        return (getUniqueRankSet(fiveCards).size() == 4);
    }

    @Override
    protected String tellCombination() {
        return Combination.ONE_PAIR.getDescription();
    }
}
