/**
 * Player
 */
public class P {
    private String namePlayer;
    private int idPlayer;

    
    public P(String namePlayer) {
        this.namePlayer = namePlayer;
        this.idPlayer = generateIdPlayer();
    }

    private int generateIdPlayer() {
        return (int) (Math.random() * 1000);
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

   


    
}