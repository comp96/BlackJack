package blackjackgame;

import java.util.Random;

/**
 *
 * @author  emily 
 */
public final class Deck {

    private Cards[] deckCards;      //cards in deck
    private int totalCards;         //no of cards in deck
    private final int SIZE = 52;    //total cards in deck

    /**
     * default constructor
     */
    public Deck() {

        this(1);
    }

    /**
     *
     * @param numPacks total packs
     */
    public Deck(int numPacks) {

        this.totalCards = numPacks * this.SIZE;
        this.deckCards = new Cards[this.totalCards];

        int l = 0;
        for (int i = 0; i < numPacks; i++) {

            for (int j = 0; j < 4; j++) {

                for (int k = 1; k <= 13; k++) {

                    this.deckCards[l] = new Cards(Suits.values()[j], k);
                    l++;
                }
            }
        }

        shuffle();

    }

    /**
     * shuffles the deck
     */
    public void shuffle() {

        Random rand = new Random(); //random to random select ids of cards

        Cards temp;

        int j;
        for (int i = 0; i < this.getTotalCards(); i++) {

            j = rand.nextInt(this.getTotalCards());

            temp = this.getDeckCards()[i];
            this.deckCards[i] = this.getDeckCards()[j];
            this.deckCards[j] = temp;
        }
    }

    public Cards getCard(String code) {
        char typeCode = code.charAt(0);
        char cardCode = code.charAt(1);
        int x = 0, y = 0;
        switch (typeCode) {
            case 'H':
                x = 0;
                break;
            case 'S':
                x = 1;
                break;
            case 'C':
                x = 2;
                break;
            case 'D':
                x = 3;
                break;
        }
        switch (cardCode) {
            case 'A':
                y = 0;
                break;
            case '2':
                y = 1;
                break;
            case '3':
                y = 2;
                break;
            case '4':
                y = 3;
                break;
            case '5':
                y = 4;
                break;
            case '6':
                y = 5;
                break;
            case '7':
                y = 6;
                break;
            case '8':
                y = 7;
                break;
            case '9':
                y = 8;
                break;
            case '1':
                y = 9;
                break;
            case 'J':
                y = 10;
                break;
            case 'Q':
                y = 11;
                break;
            case 'K':
                y = 12;
                break;
        }
        y++;
        Cards[] temp = new Cards[this.getTotalCards()];
        Cards card = this.getDeckCards()[0];
        int k = 0;
        for (int i = 0; i < this.getTotalCards(); i++) {

            if (this.getDeckCards()[i].getCardNumber() == y && this.getDeckCards()[i].getCardType() == x) {
                card = this.getDeckCards()[i];
            }
            temp[k++] = this.getDeckCards()[i];
        }
        this.deckCards = temp;
        this.setTotalCards(this.getTotalCards() - 1);
        return card;
    }

    /**
     *
     * @return top card in deck
     */
    public Cards nextCard() {

        Cards card = this.getDeckCards()[0];

        for (int l = 1; l < this.getTotalCards(); l++) {

            this.deckCards[l - 1] = this.getDeckCards()[l];
        }

        this.deckCards[this.getTotalCards() - 1] = null;
        this.setTotalCards(this.getTotalCards() - 1);

        return card;
    }

    /**
     * @return the deckCards
     */
    public Cards[] getDeckCards() {
        return deckCards;
    }

    /**
     * @return the totalCards
     */
    public int getTotalCards() {
        return totalCards;
    }

    /**
     * @param totalCards the totalCards to set
     */
    public void setTotalCards(int totalCards) {
        this.totalCards = totalCards;
    }
}
