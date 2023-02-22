package assortedRecruiters;

public class SpecialCard {
    public static int findSpecialCard(int[] cards) {
        int specialCard = 0;
        for (int i = 0; i < cards.length; i++) {
            specialCard ^= cards[i];
        }
        return specialCard;
    }
    public void go() {
/*
A special card is the card that only exists once in a pack of cards.
A pack of cards has exactly one special card.
Every other card in the pack exists two times.
Given a set of cards, write a java program that outputs the special card with a linear time complexity.
Example 1: cards=[5, 5, 3]; output=3.
Example 2: cards=[8, 5, 8, 4, 4]; output=5.
*/
        System.out.println( findSpecialCard(new int[]{5, 5, 3}));
        System.out.println( findSpecialCard(new int[]{8, 5, 8, 4, 4}));
    }
}
