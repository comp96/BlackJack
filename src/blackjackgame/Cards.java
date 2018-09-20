package blackjackgame;

/**
 *
 * @author  emily 
 */
public class Cards {

    private final Suits cardType;       //store card type
    private final int cardNum;          //store card number
    private final String[] cardId = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"}; //all cards ids

    /**
     *
     * @param stype
     * @param snum
     */
    public Cards(Suits stype, int snum) {

        this.cardType = stype;
        this.cardNum = snum;

    }

    /**
     *
     * @return card number
     */
    public int getCardNumber() {

        return this.cardNum;
    }

    @Override
    public String toString() {

        return this.cardId[this.cardNum - 1] + " of " + this.cardType.toString();
    }

    /**
     * @return the cardType
     */
    public int getCardType() {
        int x = 0;
        switch (cardType) {
            case Hearts:
                x = 0;
                break;
            case Spades:
                x = 1;
                break;
            case Clubs:
                x = 2;
                break;
            case Diamonds:
                x = 3;
                break;
        }
        return x;
    }

}
