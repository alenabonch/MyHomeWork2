package hw7.pocker.combinations;

import hw7.pocker.general.Card;

import java.util.List;


public interface CombinationRecognizer {

    void setNextCombinationRecognizer(CombinationRecognizer recognizer);

    String processRecognizer(List<Card> cards);

}
