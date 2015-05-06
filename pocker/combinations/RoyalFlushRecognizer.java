package hw7.pocker.combinations;

import hw7.pocker.general.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alena on 03.05.15.
 */
public class RoyalFlushRecognizer extends AbstractCombinationRecognizer {
    @Override
    protected boolean isRecognized(List<Card> fiveCards) {
        List<Integer> fiveCardsRanks = getRankRepresentation(fiveCards);
        // 10, J, Q, K, A, one suit
        List<Integer> royalFlushRanks = new ArrayList<>();
        for (int i = 8; i < 13; i++) {
            royalFlushRanks.add(i);
        }

        return (fiveCardsRanks.containsAll(royalFlushRanks)
                && isOneSuit(fiveCards));
    }

    @Override
    protected String tellCombination() {
        return Combination.ROYAL_FLUSH.getDescription();
    }
}
