package assortedRecruiters;

import java.util.HashMap;
import java.util.Map;

/*
In a card game each player is given one set of random cards.
Players will throw on the table their one winning card.
The player with the highest card wins.
Awinning card is the one that only exists once in a set of card, and it is the highest.
Given an array of sets of integers cards, return the card of the winning player.
Return -1 if no such card is found.
example sets are [[5,7,3,9,4,9,8,3,1], [1,2,2,4,4,1], [1,2,3]].
 */

public class CardGame {
    public void go() {
        int[][] cards = {{5,7,3,9,4,9,8,3,1}, {1,2,2,4,4,1}, {1,2,3}};
        int winningCard = getWinningCard(cards);
        System.out.println("The winning card is: " + winningCard);

    }

    private int getWinningCard(int[][] cards) {
        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int[] playerCards : cards) {
            for (int card : playerCards) {
                int count = cardCount.getOrDefault(card, 0);
                cardCount.put(card, count + 1);
            }
        }
        int winningCard = -1;
        for (int card : cardCount.keySet()) {
            int count = cardCount.get(card);
            if (count == 1 && (winningCard == -1 || card > winningCard))
                winningCard = card;
        }
        return winningCard;
    }
}
