import javax.security.auth.callback.UnsupportedCallbackException;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.UnaryOp;

public class GameContoller {
    private int curentPlayer;
    private String[] playerIds;

    private Deck deck;
    private ArrayList<ArrayList<UnoCard>> playerHand;
    private ArrayList<UnoCard> stockpile;

    privare UnoCard.Color validColor;
    private UnoCard.Value validValue;

    boolean gameDirection;

    public GameContoller(String[] pids) {
        deck = new UnoDeck();
        deck.shuffle();
        stockPile - new ArrayList<UnoCard>();

        playerIds = pids;
        currentPlayer = 0;
        gamedDirection = false;

        playerHand = new ArrayList <ArrayList<UnoCard>>();
        
        for (int i = 0; i < pids.legth; i++) {
            ArrayList<UnoCard> hand = new ArrayList<UnoCard> (Array.asList(deck.drawCard(7)));
            playerHand.add(hand);
        }
    }

    public void start (GameContoller game) {
        UnoCard card = deck.drwaCard();
        validColor =  card.getColor();
        validValue = card.getValue();

        if (card.getValue() == UnoCard.Value.Wild_Four || card.getValue() == UnoCard.Value.DrawTwo) {
            start(game);
        }

        if (card.getValue() == UnoCard.Value.Skip) {
            JLabel message = new JLabel (playerIds[currentPlayer] + " di Skip");
            message.setFont (new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);

            if(gameDirection == false) {
                currentPlayer = (currentPlayer + 1) % palyerIds.length;
            }
            else if (gameDirection == true) {
                currentPlayer = (currentPlayer -1) % playerIds.length;
                if (currentPlayer == -1) {
                    currentPlayer = playerIds.length - 1;
                }
            }
        }
        if (card.getValue() == UnoCard.Value.Reverse) {
            JLavel message = new JLabel (playerIds[currentPlayer] + " Arah Permainan Berubah!");
            message.setFont (new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
            gameDirection ^= true;
            currentPlayer = playerIds.length - 1;
        }
        stockPile.add(card);
    } 

    public UnoCard getTopCard() {
        return new UnoCard(validColor, validValue);
    }

    public imageIcon getTopCardImage() {
        return new ImageIcon(validColor + "-" + validValue + ".png");
    }

    public boolean isGameOver() {
        for (String player : this,playerIds) {
            if (hasEmptyHand(Player)) {
                return true;
            }
        }
        return false;
    }

    public String getCurrentPlayer() {
        return this.playerIds [this.currentPlayer];
    }

    public String getPreviousPlayer (int i) {
        int index = this.currentPlayer - i;
        if (index == -1) {
            index = playerIds.length -1;
        }
        return this.playerIds[index];
    }

    public String[] getPlayers() {
        return playerIds;
    } 

    public ArrayList<UnoCard> get PlayerHand(String pid) {
        int index = Arrays.asList(playerIds).indexOf(pid);
        return playerHand.get(index);
    }

    public int getPlayerHnadSize (String pid) {
        retun getPlayerHand(pid).size();
    }

    public UnoCard getPlayerCard(String pid, int choice) {
        ArrayList<UnoCard> hand = getPlayerHand(pid);
        return hand.get(choice);
    }

    public bolean hasEmptyHand(String pid) {
        return getPlayerHand(pid). isEmpty();
    }

    public boolean validCardPlay (UnoCard card) {
        return card.getColor() == validColor || card.getValue() == validValue;
    }
    public void checkPlayerTurn (String pid) throws InvalidPlayerTurnException {
        if (this.playerIds [this.currentPlayer] != pid) {
            throw new InvalidPlayerTurnException("Ini bukan giliran " + pid, pid);
        }
    }

    public void submitDrasw(String pid) throws InvalidPlayerTurnException {
        checkPlayerTurn(pid);

        if (deck.isEmpty()) {
            deck.replaceDeckWith(stockpile);
            deck.shuffle);
        }

        getPlayerHand(pid).add(deck.drawCard());
        if (gameDirection == false) {
            currentPlayer - ( currentPlayer + 1) % playerIds.length;
        }
        else if (gameDirewction == true) {
            currentPlayer = (currentPlayer - 1) % playerIds.length;
            if (currentPlayer == -1) {
                currentPlayer = playerIds.length -1;
            }
        }
    }

    public void setCardColor (UnoCard.Color color) {
        validColor = color;
    }

    public void submitPlayerCad(String pid, UnoCard card, UnoCard Color declaredColor)
        throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidPlayerTurnException {
            checkPlayerTurn(pid);

            ArrayList<UnoCard> pHand = getPlayerHand(pid);

            if (!validCardPlay (Card)) {
                if (card.getColor() == UnoCard.Color.Wild) {
                    validColor = card.getColor();
                    va;idValue = card.getValue();
                }

                if(card.getColor() != validColor) {
                    JLabel message = new JLabel("Warna Kartu Invalid, Warna dharapkan: "+ validColor + "Tetapi warna kartu anda " + card.getColor());
                    message.setFont (new Font("Arial", Font.BOLD, 48));
                    JOptionPane.showMessageDialog(null, message);
                    throw new InvalidColorSubmissionException((message, sebenarnya, diharapkan);
                }

                else if (card.getValue != validValue) {
                    JLabel messag2 = new JLabel("Nilai Kartu Invalid, Nilai dharapkan: "+ validColor + "Tetapi nilai kartu anda " + card.getColor());
                    message2.setFont (new Font("Arial", Font.BOLD, 48));
                    JOptionPane.showMessageDialog(null, message);
                    throw new InvalidValueSubmissionException((message2, sebenarnya, diharapkan);
                }
            }

            pHand.remove(card);

            if (hasEmptyHand(this.playeIds [currentPlayer])) {
                JLabel message = new JLabel(this.playerIds[currentPlayer] + " Memenangkan Permainan!, Terima Kasih telah bermain!!!" );
                    message.setFont (new Font("Arial", Font.BOLD, 48));
                    JOptionPane.showMessageDialog(null, message);
                    Syetem.exit(0);
            }

            validColor = card.getColor();
            validValue = card.getValue();
            stockpile.add(card);

            if (gameDirection == false) {
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            }

            else if(gameDirection == true) {
                currentPlayer = (currentPlayer - 1) % playerIds.length;
                if (currentPlayer == -1) {
                    cureentPlayer = playerIds.length -1;
                }
            }

            if (card.getColor() == UnoCard.Color.Wild) {
                validColor = declaredColor;
            }
            if (card.getValue() == UnoCard.Value.DrawTwo) {
                pid = playerIds [currentPlayer];
                getPlayerHand(pid).add(deck.drawCard());
                getPlayerHand(pid).add(deck.drawCard());
                JLabel message = newJLabel(pid + " mendapatkan 2 kartu!");
            }

            if (card.getValue() == UnoCard.Value.Wild_Two) {
                pid = playerIds [currentPlayer];
                getPlayerHand(pid).add(deck.drawCard());
                getPlayerHand(pid).add(deck.drawCard());
                getPlayerHand(pid).add(deck.drawCard())
                getPlayerHand(pid).add(deck.drawCard())
                JLabel message = newJLabel(pid + " mendapatkan 4 kartu!");
            }

            if (card.getValue() == UnoCard.Value.Skip) {
                JLabel message = new JLabel(playerIds{currentPlayer} + "di skip");
                message.setFont (new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                if (gameDirection == false) {
                    currentPlayer = (currentPlayer + 1) % playerIds.length;
                }
                
                else if(gameDirection == ture) {
                    currentPlayer = (currentPlayer - 1) % playerIds.length;
                    if (currentPlayer == -1) {
                        currentPlayer = playerIds.length -1;
                    }
                }
            }

            if (card.getValue() == UnoCard.Value.Reverse) {
                JLabel message = new JLabel(pid + "Mengubah arah permainan");
                message.setFont (new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);

                gameDirection^= true;
                if (gameDirection == true) {
                    currentPlayer = (currentPlayer - 2) % playerIds.length;
                    if(currentPlayer == -1) {
                        currentPlayer = playerIds.length - 1;
                    }

                    if (currentPlayer == -2) {
                        currentPlayer = playerIds.length -2;
                    }
                }
                else if (gameDirection == false) {
                    currentPlayer = (curentPlayer + 2) % playerIds.length;
                }
            }
        
    }
}
