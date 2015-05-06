package hw7.pocker.general;

import hw7.pocker.combinations.AbstractCombinationRecognizer;
import hw7.pocker.combinations.Combination;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class PockerTest {

    private final String expected;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;

    private Pocker pocker;

    @Before
    public void setUp() {
        pocker = new Pocker();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                        {Combination.ROYAL_FLUSH.getDescription(), new Card(0, 8), new Card(0, 9),
                                                new Card(0, 10), new Card(0, 11), new Card(0, 12)},
                        {Combination.STRAIGHT_FLUSH.getDescription(), new Card(3, 2), new Card(3, 3),
                                                new Card(3, 4), new Card(3, 5), new Card(3, 6)},
                        {Combination.FOUR_OF_A_KIND.getDescription(), new Card(0, 11), new Card(1, 11),
                                                new Card(2, 11), new Card(3, 11), new Card(2, 4)},
                        {Combination.FULL_HOUSE.getDescription(), new Card(0, 8), new Card(1, 8),
                                                new Card(2, 8), new Card(0, 12), new Card(1, 12)},
                        {Combination.FLUSH.getDescription(), new Card(1, 2), new Card(1, 5),
                                                new Card(1, 8), new Card(1, 12), new Card(1, 10)},
                        {Combination.STRAIGHT.getDescription(), new Card(0, 2), new Card(1, 3),
                                                new Card(2, 4), new Card(3, 5), new Card(0, 6)},
                        {Combination.THREE_OF_A_KIND.getDescription(), new Card(0, 3), new Card(1, 3),
                                                new Card(2, 3), new Card(0, 10), new Card(1, 12)},
                        {Combination.TWO_PAIR.getDescription(), new Card(0, 5), new Card(1, 5),
                                                new Card(2, 10), new Card(3, 10), new Card(0, 11)},
                        {Combination.ONE_PAIR.getDescription(), new Card(0, 7), new Card(1, 7),
                                                new Card(0, 2), new Card(1, 5), new Card(2, 9)},
                        {Combination.HIGH_CARD.getDescription(), new Card(0, 12), new Card(3, 10),
                                                new Card(0, 4), new Card(2, 1), new Card(0, 2)}
                }
        );
    }

    public PockerTest(String expected, Card card1, Card card2, Card card3,
                                    Card card4, Card card5) {
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.card4 = card4;
        this.card5 = card5;
        this.expected = expected;
    }

    @Test
    public void testCombinations() {
        DeckPile deckPile = new DeckPile();

        deckPile.addCard(card1);
        deckPile.addCard(card2);
        deckPile.addCard(card3);
        deckPile.addCard(card4);
        deckPile.addCard(card5);

        FiveCards fiveCards = new FiveCards(0, 0);
        fiveCards.takeFive(deckPile);

        assertEquals(expected, AbstractCombinationRecognizer.recognize(fiveCards));
    }
}