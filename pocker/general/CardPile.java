package hw7.pocker.general;

import java.awt.*;
import java.util.List;

class CardPile {

    private Card firstCard;

    // coordinates of the card pile
    protected int x;
    protected int y;

    public CardPile(final int xl, final int yl) {
        x = xl;
        y = yl;
        firstCard = null;
    }

    public CardPile() {
    }

    // the following are sometimes overridden
    public void addCard(Card aCard) {
        aCard.link = firstCard;
        firstCard = aCard;
    }


    public void display(final Graphics g) {
        g.setColor(Color.black);
        if (firstCard == null) {
            g.drawRect(x, y, Card.WIDTH, Card.HEIGHT);
        } else {
            firstCard.draw(g, x, y);
        }
    }

    public boolean isEmpty() {
        return firstCard == null;
    }

    public Card pop() {
        Card result = null;
        if (firstCard != null) {
            result = firstCard;
            firstCard = firstCard.link;
        }
        return result;
    }

    public Card top() {
        return firstCard;
    }


}
