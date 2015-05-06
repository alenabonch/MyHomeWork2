package hw7.pocker.general;

import hw7.pocker.combinations.AbstractCombinationRecognizer;

import java.applet.Applet;
import java.awt.*;

public class Pocker extends Applet {
    private static DeckPile deckPile;
    private static FiveCards fiveCards;
    private static String pockerCombination;

    public void init() {
        deckPile = new DeckPile();
        deckPile.createDeckPile(30, 5);
        fiveCards = new FiveCards(45, 80);
        fiveCards.takeFive(deckPile);
        pockerCombination = AbstractCombinationRecognizer.recognize(fiveCards);
    }

    public boolean mouseDown(final Event evt, final int x, final int y) {
        new Pocker().init();
        repaint();
        return true;
    }

    public void paint(final Graphics g) {
        fiveCards.display(g);
        g.drawString(pockerCombination, 150, 200);
    }
}
