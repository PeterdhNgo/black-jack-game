import java.util.ArrayList;

public class Card
{
    private String suit;
    private String cardNum;
    private int value;

    public void setSuit(String suit)
    {
        this.suit = suit;
    }

    public String getSuit()
    {
        return this.suit;
    }

    public void setCardNum(String cardNum)
    {
        this.cardNum = cardNum;
    }

    public String getCardNum()
    {
        return this.cardNum;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }

    public Card(String cardNum, String suit, int value)
    {
        this.suit = suit;
        this.cardNum = cardNum;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "> " + this.cardNum + " of " + this.suit + "s - Value: " + this.value;
    }

}