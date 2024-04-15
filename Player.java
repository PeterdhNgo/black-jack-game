import java.util.ArrayList;

public class Player
{
    private ArrayList<Card> hand;
    private String playerName;
    private boolean hasStuck;

    public Player(String playerName)
    {
        this.playerName = playerName;
        hand = new ArrayList();
        hasStuck = false;
    }

    public String getPlayerName()
    {
        return this.playerName;
    }

    public void drawCard(Deck deck)
    {
        Card card = deck.getCards().get(0);
        deck.getCards().remove(0);
        hand.add(card);
        System.out.println(playerName + " draws a card! " + card.toString());
    }

    public int getTotalValue()
    {
        int total = 0;
        int numAces = 0;

        // Calculate total value of non-Ace cards
        for (Card card: hand)
        {
            if (!card.getCardNum().equals("Ace"))
            {
                total += card.getValue();
            }
            else
            {
                numAces++;
            }
        }

        // calculate Ace value based on different situations
        for (int i = 0; i < numAces; i++)
        {
            if (total + 11 <= 21)
            {
                total += 11; // count Ace as 11 if it doesn't cause bust
            }
            else
            {
                total += 1; // otherwise, count Ace as 1
            }
        }

        return total;
    }

    public void setHasStuck(boolean hasStuck)
    {
        this.hasStuck = hasStuck;
    }

    public boolean isHasStuck()
    {
        return this.hasStuck;
    }

}