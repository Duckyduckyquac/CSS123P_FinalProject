package css123p_finalproject.model;

public class GameEnvironment {
    
    Player PlayerOne;
    Player PlayerTwo;
    Map GameMap;
    
    GameEnvironment(Player pOne, Player pTwo) {
        this.PlayerOne = pOne;
        this.PlayerTwo = pTwo;
        this.GameMap = new Map(); 
    }

    public float pOnePosition(float coordMoved) {
        return coordMoved; 
    }

    public float pTwoPosition(float coordMoved) {
        return coordMoved; 
    }
}