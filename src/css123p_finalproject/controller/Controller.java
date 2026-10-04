package css123p_finalproject.controller;

import css123p_finalproject.model.Player;
import css123p_finalproject.model.Enemy;
import css123p_finalproject.model.Damage;


public void AttackEnemy(Player player, Enemy enemy, Damage dmg) {
    
    if (player.getATK() === 0) {
        return 0.0
    };

    Enemy.setHP(Enemy.getHP() - dmg.InflictDmg());

    return;

}

public void AttackEnemy(Player player, Enemy enemy, Damage dmg) {
    
    if (enemy.getATK() === 0) {
        return 0.0
    };

    Player.setHP(Player.getHP() - dmg.InflictDmg());

    return;

}

public class Controller {
    
    Controller() {

    }

}
