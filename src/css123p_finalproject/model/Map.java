package css123p_finalproject.model;

import java.awt.image.BufferedImage;

interface LevelFloor {
    void EnemyList(int count);

    void ChestList(int count);
}

class LevelOne implements LevelFloor {
    
    int EnemyCount;
    private final Enemy[] Enemies;
    private final Chest[] Chests;
    
    public void EnemyList(int count) {
        this.Enemy = new Enemy[count];
        this.EnemyCount = this.Enemies.length;
    }

    public void ChestList(int count) {
        this.Chests = new Chest[count];
    }

    public BufferedImage GetMap() {
        return BufferedImage // SOON
    }

}

class LevelTwo implements LevelFloor {

    int EnemyCount;
    private final Enemy[] Enemies;
    private final Chest[] Chests;
    
    public void EnemyList(int count) {
        this.Enemy = new Enemy[count];
        this.EnemyCount = this.Enemies.length;
    }

    public void ChestList(int count) {
        this.Chests = new Chest[count];
    }

    public BufferedImage GetMap() {
        return BufferedImage // SOON
    }


}

class LevelThree implements LevelThree {

    int EnemyCount;
    private final Enemy[] Enemies;
    private final Chest[] Chests;
    
    public void EnemyList(int count) {
        this.Enemy = new Enemy[count];
        this.EnemyCount = this.Enemies.length;
    }

    public void ChestList(int count) {
        this.Chests = new Chest[count];
    }

    public BufferedImage GetMap() {
        return BufferedImage // SOON
    }

}


public class Map {
    
    Map() {}

}