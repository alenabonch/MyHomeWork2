package hw7.pocker.combinations;

public enum Combination {
    ROYAL_FLUSH("Royal Flush"), STRAIGHT_FLUSH("Straight Flush"),
    FOUR_OF_A_KIND("Four of a Kind"), FULL_HOUSE("Full House"),
    FLUSH("Flush"), STRAIGHT("Straight"),
    THREE_OF_A_KIND("Three of a Kind"), TWO_PAIR("Two Pair"),
    ONE_PAIR("One Pair"), HIGH_CARD("High Card");

    private String description;

    Combination(String description) {

        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
