package blackjackgame;

/**
 *
 * @author  emily 
 */
public class Players {

    private final String name;      //name of player
    private final Cards[] cards = new Cards[10];    //cards of player
    private int cardCount;  //card count

    public Players(String name) {

        this.name = name;
        dropCards();    //drop all cards
    }

    /**
     * drop all cards in hand
     */
    public void dropCards() {

        for (int hc = 0; hc < 10; hc++) {

            this.cards[hc] = null;
        }

        this.cardCount = 0;

    }

    /**
     *
     * @return name of player
     */
    public String getPlayerName() {
        return name;
    }

    /**
     *
     * @param card card to add in hand of player
     * @return true if success
     */
    public boolean addCard(Cards card) {

        if (this.getNumCardsInHand() == 10) {
            System.exit(1);
        }

        this.cards[this.getNumCardsInHand()] = card;
        this.cardCount++;

        return (getScore() <= 21);

    }

    /**
     *
     * @return total no of cards score in hands
     */
    public int getScore() {

        int count = 0;
        int cardId;
        int aceCount = 0;       //counting total no of aces in hands

        for (int c = 0; c < this.getNumCardsInHand(); c++) {

            cardId = this.cards[c].getCardNumber();

            if (cardId == 1) {

                aceCount++;
                count += 11;
            } else if (cardId >= 10) {

                count += 10;
            } else {

                count += cardId;
            }
        }

        while (count > 21 && aceCount > 0) {

            count -= 10;
            aceCount--;
        }

        return count;
    }

    public void print(boolean showFirstCard) {
        System.out.println(name + "'s cards in hand");
        System.out.print("[ ");
        for (int c = 0; c < this.getNumCardsInHand(); c++) {

            if (!showFirstCard && c == 0) {

                System.out.print("Face Down, ");
            } else {

                if (c == this.getNumCardsInHand() - 1) {
                    System.out.println(cards[c] + " ]\n");
                } else {
                    System.out.print(cards[c] + ", ");
                }
            }

        }
    }

    /**
     * @return the cardCount
     */
    public int getNumCardsInHand() {
        return cardCount;
    }
}
