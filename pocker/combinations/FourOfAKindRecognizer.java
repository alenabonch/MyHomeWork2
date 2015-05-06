package hw7.pocker.combinations;

import hw7.pocker.general.Card;

import java.util.List;

public class FourOfAKindRecognizer extends AbstractCombinationRecognizer {
    @Override
    protected boolean isRecognized(List<Card> fiveCards) {
        return (getUniqueRankSet(fiveCards).size() == 2 &&
            getUniqueSuitSet(fiveCards).size() == 4);
    }

    @Override
    protected String tellCombination() {
        return Combination.FOUR_OF_A_KIND.getDescription();
    }
}
