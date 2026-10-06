package css123p_finalproject.controller;

import css123p_finalproject.model.Player;
import css123p_finalproject.model.Enemy;
import css123p_finalproject.model.Damage;

public class Controller {
    
    public Controller() {
    }
    
    public void attackEnemy(Player player, Enemy enemy, Damage dmg) {
        if (player.getATK() == 0) {
            return;
        }
        enemy.setHP(enemy.getHP() - (int)dmg.InflictDmg());
    }
    
    public void attackPlayer(Player player, Enemy enemy, Damage dmg) {
        if (enemy.getATK() == 0) {
            return;
        }
        player.setHP(player.getHP() - (int)dmg.InflictDmg());
    }
}