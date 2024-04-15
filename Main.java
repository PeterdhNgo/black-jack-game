import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Deck mainDeck = new Deck();
        // GOLD MEDAL STARTS HERE
        // input from user
        Scanner scanner = new Scanner(System. in );

        // shuffle the deck (I guess)
        mainDeck.shuffleDeck();

        ArrayList<Player > players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));


        // Deal starting cards to each player
        for (Player player: players)
        {
            player.drawCard(mainDeck);
        }

        // Loop until all player choose to stick or go above 21
        boolean allPlayersStuckOrBust = false;

        while (!allPlayersStuckOrBust)
        {
            allPlayersStuckOrBust = true;

            for (Player player: players)
            {
                if (!player.isHasStuck() && player.getTotalValue() <= 21)
                {
                    allPlayersStuckOrBust = false;

                    System.out.println(player.getPlayerName() + "'s turn. The total value: " + player.getTotalValue());

                    // if the player hasn't stuck and hasn't busted, ask for their action
                    System.out.println("Do you want to stick or twist with your hand? (s/t)");
                    String choice = scanner.nextLine().trim().toLowerCase();

                    if (choice.equals("t"))
                    {
                        player.drawCard(mainDeck);
                        // check if the player busts after drawing a card
                        if (player.getTotalValue() > 21)
                        {
                            System.out.println(player.getPlayerName() + " busts!!!!. The total value: " + player.getTotalValue());
                            player.setHasStuck(true);
                        }
                    }
                    else if (choice.equals("s"))
                    {
                        System.out.println(player.getPlayerName() + " sticks!");
                        player.setHasStuck(true);
                    }
                    else
                    {
                        System.out.println("Invalid input! Choose either 's' or 't'!");
                    }
                }
            }
        }

        // determine the winner after the game loop ends
        Player winPlayer = null;
        int maxTotal = 0;
        for (Player player: players)
        {
            if (player.getTotalValue() <= 21 && player.getTotalValue() > maxTotal)
            {
                maxTotal = player.getTotalValue();
                winPlayer = player;
            }
        }

        if (winPlayer != null)
        {
            System.out.println("The winner is: " + winPlayer.getPlayerName() + " with a total value of " + winPlayer.getTotalValue());
        }
        else
        {
            System.out.println("Both players bust or stick with the same total value.");
        }

        scanner.close();
    }
}