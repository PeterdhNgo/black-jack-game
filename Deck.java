import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards;

    public Deck()
    {
        this.cards = new ArrayList();
        // CONSTRUCTION OF THE DECK
        ArrayList<String> suits = new ArrayList(Arrays.asList("diamond", "heart", "club", "spade"));
        ArrayList<String> cardNums = new ArrayList(Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"));
        ArrayList<Integer> values = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10));

        for (String suit: suits)
        {
            for (int i = 0; i < cardNums.size(); i++)
            {
                String cardNum = cardNums.get(i);
                int value = values.get(i);

                Card myCard = new Card(cardNum, suit, value);
                this.cards.add(myCard);
            }
        }
    }

    public void setCards(ArrayList<Card> cards)
    {
        this.cards = cards;
    }

    public ArrayList<Card> getCards()
    {
        return this.cards;
    }

    public void shuffleDeck()
    {
        Collections.shuffle(this.cards);
    }
}