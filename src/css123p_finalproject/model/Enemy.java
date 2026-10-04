package css123p_finalproject.model;

import css123p_finalproject.abstractions.Stats;

interface EnemyAttack {
    int execute(Player player);
}

interface EnemyDefense {
    int execute(Player player, Enemy enemy);
}

class GoblinSmash implements EnemyAttack {
    public int execute(Damage dmg) {
        return dmg.CalcDmg;
    }
}

class GoblinDodge implements EnemyDefense {
    public void execute(Player, player, Enemy enemy) {
        Player.MORALE -= 5;
        Enemy.MORALE += 5;
    }

    public int ShowMoraleCount() {
        return Enemy.MORALE;
    }

    public int ShowPlayerMoraleCount() {
        return Player.MORALE;
    }
    
}

public class Enemy extends Stats {

    public Enemy(String Type, int HP, int ATK, int DEF, int EXP) {
        super(HP, ATK, DEF, EXP);
        this.type = Type;
    }


    public static void main(String[] args) {
        Enemy goblin = new Enemy("Goblin", 200, 15, 35, 300);
        Enemy skeleton = new Enemy("Skeleton", 100, 35, 15, 150);
        Enemy slime = new Enemy("Slime", 50, 10, 5, 100);
    }

}