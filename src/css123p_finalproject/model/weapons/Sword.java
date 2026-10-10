package css123p_finalproject.model.weapons;

import css123p_finalproject.model.Weapons;
import css123p_finalproject.model.Player;
import css123p_finalproject.model.Mob;
import css123p_finalproject.model.Projectile;
import java.util.ArrayList;

public class Sword extends Weapons {
    public Sword() {
        super("SWORD (Melee)", 50, 500); 
    }

    @Override
    public void use(Player player, int targetX, int targetY, ArrayList<Mob> enemies, ArrayList<Projectile> projectiles) {
        long now = System.currentTimeMillis();
        if (!canAttack(now)) return;

        double pCenterX = player.getX() + player.getWidth() / 2.0;
        double pCenterY = player.getY() + player.getHeight() / 2.0;
        double maxRange = player.getWidth() * 3.0; // Keeps your extended 3x range

        for (Mob enemy : enemies) {
            if (enemy.isAlive()) {
                double eCenterX = enemy.getX() + enemy.getWidth() / 2.0;
                double eCenterY = enemy.getY() + enemy.getHeight() / 2.0;
                double dist = Math.hypot(eCenterX - pCenterX, eCenterY - pCenterY);

                if (dist <= maxRange) {
                    enemy.takeDamage(this.damage);
                    recordAttack(now);
                }
            }
        }
    }
}