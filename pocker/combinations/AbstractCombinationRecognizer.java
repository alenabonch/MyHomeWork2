package hw7.pocker.combinations;

import hw7.pocker.general.Card;
import hw7.pocker.general.FiveCards;
import hw7.pocker.general.Pocker;

import java.util.*;

/**
 * Created by alena on 03.05.15.
 */
public abstract class AbstractCombinationRecognizer implements CombinationRecognizer {

    public static String recognize(FiveCards fiveCards) {
        List<Card> fiveCardsList = saveAsList(fiveCards);
        // Create the recognizer objects
        CombinationRecognizer royalFlush = new RoyalFlushRecognizer();
        CombinationRecognizer straightFlush = new StraightFlushRecognizer();
        CombinationRecognizer fourOfAKind = new FourOfAKindRecognizer();
        CombinationRecognizer fullHouse = new FullHouseRecognizer();
        CombinationRecognizer flush = new FlushRecognizer();
        CombinationRecognizer straight = new StraightRecognizer();
        CombinationRecognizer threeOfAKind = new ThreeOfAKindRecognizer();
        CombinationRecognizer twoPair = new TwoPairRecognizer();
        CombinationRecognizer onePair = new OnePairRecognizer();
        CombinationRecognizer highCard = new HighCardRecognizer();

        // Chain them together
        royalFlush.setNextCombinationRecognizer(straightFlush);
        straightFlush.setNextCombinationRecognizer(fourOfAKind);
        fourOfAKind.setNextCombinationRecognizer(fullHouse);
        fullHouse.setNextCombinationRecognizer(flush);
        flush.setNextCombinationRecognizer(straight);
        straight.setNextCombinationRecognizer(threeOfAKind);
        threeOfAKind.setNextCombinationRecognizer(twoPair);
        twoPair.setNextCombinationRecognizer(onePair);
        onePair.setNextCombinationRecognizer(highCard);

        // start the ball rolling
        return royalFlush.processRecognizer(fiveCardsList);
    }

    private CombinationRecognizer nextCombinationRecognizer;

    @Override
    public void setNextCombinationRecognizer(CombinationRecognizer recognizer) {
        nextCombinationRecognizer = recognizer;
    }

    @Override
    public String processRecognizer(List<Card> cards) {
        String combination;

        if (isRecognized(cards)) {
            combination = tellCombination();

        } else {
            combination = nextCombinationRecognizer.processRecognizer(cards);
        }
        return combination;
    }

    protected abstract boolean isRecognized(List<Card> fiveCards);

    protected abstract String tellCombination();

    protected static List<Card> saveAsList(FiveCards fiveCards) {
        List fiveCardsList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            fiveCardsList.add(fiveCards.pop());
        }
        for (int i = 0; i < 5; i++) {
            fiveCards.addCard((Card) fiveCardsList.get(i));
        }
        return fiveCardsList;
    }

    protected List<Integer> getRankRepresentation(List<Card> cards) {
        List<Integer> rankRepresentation = new ArrayList<>();
        for (Card card : cards) {
            rankRepresentation.add(card.getRank());
        }
        return rankRepresentation;
    }

    protected Set<Integer> getUniqueSuitSet(List<Card> cards) {
        Set<Integer> suitSet = new TreeSet<>();
        for (Card card : cards) {
            suitSet.add(card.getSuit());
        }
        return suitSet;
    }

    protected Set<Integer> getUniqueRankSet(List<Card> cards) {
        Set<Integer> rankSet = new TreeSet<>();
        for (Card card : cards) {
            rankSet.add(card.getRank());
        }
        return rankSet;
    }

    protected boolean isOneSuit(List<Card> cards) {
        return getUniqueSuitSet(cards).size() == 1;
    }

    protected boolean isDifferentRanks(List<Card> cards) {
        return getUniqueRankSet(cards).size() == cards.size();
    }

    protected boolean isInSequenceRanks(List<Card> cards) {
        SortedSet<Integer> rankSet = new TreeSet<>();
        for (Card card : cards) {
            rankSet.add(card.getRank());
        }
        return rankSet.last() - rankSet.first() == cards.size() - 1
                && isDifferentRanks(cards);
    }
}
