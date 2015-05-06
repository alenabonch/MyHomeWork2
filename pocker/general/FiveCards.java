package hw7.pocker.general;

import java.awt.*;

public class FiveCards extends CardPile {

    public FiveCards(int x, int y) {
        super(x, y);
    }

    public void takeFive(DeckPile deckPile) {
        for (int i = 0; i < 5; i++) {
            addCard(deckPile.pop());
            top().flip();
        }
    }

    public void display(Graphics g) {
        displayInRow(g, top());
    }

    private int displayInRow(Graphics g, Card card) {
        int localy;
        if (card == null) {
            return x;
        }
        localy = displayInRow(g, card.link);
        card.draw(g, localy, y);
        return localy + 60;
    }

}
