package hw7.pocker.combinations;

import hw7.pocker.general.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alena on 03.05.15.
 */
public class StraightFlushRecognizer extends AbstractCombinationRecognizer {
    @Override
    protected boolean isRecognized(List<Card> fiveCards) {
        return  (isInSequenceRanks(fiveCards) && isOneSuit(fiveCards));
    }

    @Override
    protected String tellCombination() {
        return Combination.STRAIGHT_FLUSH.getDescription();
    }
}
