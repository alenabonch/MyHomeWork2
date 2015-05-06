package hw7.pocker.combinations;

import hw7.pocker.general.Card;

import java.util.List;

public class HighCardRecognizer extends AbstractCombinationRecognizer {
    @Override
    protected boolean isRecognized(List<Card> fiveCards) {
        return true;
    }

    @Override
    protected String tellCombination() {
        return Combination.HIGH_CARD.getDescription();
    }
}
