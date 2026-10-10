package css123p_finalproject.model;

import java.util.ArrayList;

public class Goblin extends Mob {
    public Goblin(int startX, int startY, double speed, int HP, int ATK, int DEF, int STAMINA) {
        super(startX, startY, speed, HP, ATK, DEF, STAMINA);
    }

    @Override
    public void updateAI(Player player, ArrayList<Mob> allMobs, ArrayList<Projectile> enemyProjectiles) {
        if (!isAlive()) return;

        double oldX = this.x;
        double oldY = this.y;

        // 1. Chase Player
        if (this.x > player.getX() + 5) moveLeft();
        else if (this.x < player.getX() - 5) moveRight();

        if (this.y > player.getY() + 5) moveUp();
        else if (this.y < player.getY() - 5) moveDown();

        // 2. Separation Physics
        for (Mob other : allMobs) {
            if (other == this || !other.isAlive()) continue;

            double dx = this.x - other.x;
            double dy = this.y - other.y;
            double distance = Math.hypot(dx, dy);

            if (distance < this.width && distance > 0) {
                double overlap = this.width - distance;
                double pushX = (dx / distance) * (overlap / 2.0);
                double pushY = (dy / distance) * (overlap / 2.0);

                this.adjustPosition(pushX, pushY);
                other.adjustPosition(-pushX, -pushY);
            }
        }

        // 3. Update Animation States based on actual movement delta
        this.isMoving = (this.x != oldX || this.y != oldY);

        if (this.isMoving) {
            // Determine primary axis of movement to prevent diagonal flickering
            if (Math.abs(this.x - oldX) > Math.abs(this.y - oldY)) {
                this.facingX = (this.x > oldX) ? 1 : -1;
                this.facingY = 0;
            } else {
                this.facingX = 0;
                this.facingY = (this.y > oldY) ? 1 : -1;
            }
        }
    }
}