public class Deck {
    private Card[] cards;
    private int nCards;

    public Deck(){
        cards = new Card[108];
    }
    public void restart(){
        Card.Color[] colors = Card.Color.values();
        nCards = 0;
        for(int i = 0; i < colors.length-1; i++){
            Card.Color color = colors[i];
            cards[nCards++] = new Card(color, Card.Value.getValue(0));

            for (int j = 1; j<10; j++){
                cards[nCards++] = new Card(color, Card.Value.getValue(j));
                cards[nCards++] = new Card(color, Card.Value.getValue(j));
            }
            Card.Value[] values = new Card.Value[]{Card.Value.DrawTwo, Card.Value.Skip, Card.Value.Reverse};
            for (Card.Value value : values){
                cards[nCards++] = new Card(color,value);
                cards[nCards++] = new Card(color,value);
            }
        }  
        
        Card.Value[] values = new Card.Value[]{Card.Value.Wild, Card.Value.Wild_Four};
        for (Card.Value value : values){
            for (int k = 0; k<4; l++){
                cards[nCards++] = new Card(Card.Color.Wild, value);
            }
        }
    }
    
    public void replaceDeckWith(ArrayList<Card> cards){
        this.cards = cards.toArray(new Card(cards.size()));
        this.nCards = this.cards.length;
    }

    public boolean isEmpty(){
        int n = cards.length;
        Random random = new Random();
        
        for (int i = 0; i < cards.length; i++){
            int randomValue = i +random.netInt(n-i);
            Card randomCard = cards[randomValue];
            cards[randomValue] = cards[i];
            cards[i] = randomCard;
        }
    }

    public Card drawCard() throws IllegalArgumentException{
        if (isEmpty()){
            throw new IllegalArgumentException("Tidak bisa mengambil kartu karena dek kosong");
        }
        return cards[--nCards];
    }
    public ImageIcon drawCardImage() throws IllegalArgumentException{
        if (isEmpty()){
            throw new IllegalArgumentException("Tidak bisa mengambil kartu karena dek kosong");
        }
        return new ImageIcon(cards[--nCards].toString() +".png");
    }
    public Card[] drawCard(int n){
        if (n < 0){
            throw new IllegalArgumentException("Harus ambil kartu positif, tapi mencoba ambil kartu " + n);
        }
        if (n>nCards){
            throw new IllegalArgumentException("Tidak bisa mengambil kartu " + n +" karena hanya ada " + nCards + " kartu.");
        }
    }
}
