package hw7.pocker.combinations;

import hw7.pocker.general.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by alena on 03.05.15.
 */
public class ThreeOfAKindRecognizer extends AbstractCombinationRecognizer {
    @Override
    protected boolean isRecognized(List<Card> fiveCards) {
        List<Integer> rankList = getRankRepresentation(fiveCards);
        Set<Integer> uniqueRankSet = getUniqueRankSet(fiveCards);
        List<Integer> rankFriquences = new ArrayList<>();

        for (Integer rank : uniqueRankSet) {
            rankFriquences.add(Collections.frequency(rankList, rank));
        }
        return (Collections.max(rankFriquences) == 3);
    }

    @Override
    protected String tellCombination() {
        return Combination.THREE_OF_A_KIND.getDescription();
    }
}
