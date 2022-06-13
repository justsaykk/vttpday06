package cards;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public void see(ArrayList<String> deck) {
        for (int i = 0; i < deck.size(); i++) {
            System.out.printf("%d: Card No. %s\n", i, deck.get(i));
        }
    }

    public ArrayList<String> take(int toRemove, ArrayList<String> deck) {
        for (int i = 0; i < toRemove; i++) {
            deck.remove(i);
        }
        return deck;
    }

    public static void main(String[] args) {
        Console cons = System.console();
        Main methods = new Main();

        // Instantiating a new list of 52 strings (cards)
        ArrayList<String> deck = new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            deck.add(Integer.toString(i));
        }

        boolean stop = false;
        while (!stop) {
            // Getting user-input from command line
            String userInput = cons
                    .readLine(">>Shuffle (shuffle), Take Cards (take n) or See remaining cards (see) or exit? \n");
            String[] splitString = userInput.split(" ");
            String userCommand = splitString[0].toLowerCase();

            switch (userCommand) {
                case "shuffle":
                    Collections.shuffle(deck);
                    System.out.println("Deck has been shuffled");
                    break;

                case "see":
                    methods.see(deck);
                    break;

                case "take":
                    int toRemove = Integer.parseInt(splitString[1]);
                    deck = methods.take(toRemove, deck);
                    break;

                case "exit":
                    System.out.println("Bye Bye!");
                    stop = true;
                    break;

                default:
                    break;
            }
        }
    }
}
