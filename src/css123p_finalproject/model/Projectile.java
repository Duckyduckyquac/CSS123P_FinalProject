package css123p_finalproject.model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Projectile {
    private double x, y;
    private double vx, vy; // Velocity vectors
    private int damage;
    private Color color;
    private int size = 10;

    public Projectile(int startX, int startY, int targetX, int targetY, int speed, int damage, Color color) {
        // Spawn at the center of the player
        this.x = startX + 32; 
        this.y = startY + 32;
        this.damage = damage;
        this.color = color;

        // Vector Math: Calculate distance and direction to the clicked enemy
        double dx = targetX - this.x;
        double dy = targetY - this.y;
        double distance = Math.hypot(dx, dy);

        // Normalize the vector and multiply by speed
        if (distance > 0) {
            this.vx = (dx / distance) * speed;
            this.vy = (dy / distance) * speed;
        } else {
            this.vx = speed;
            this.vy = 0;
        }
    }

    public void update() {
        this.x += this.vx;
        this.y += this.vy;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(this.color);
        g2d.fillOval((int)this.x, (int)this.y, this.size, this.size);
    }

    public int getX() { return (int)this.x; }
    public int getY() { return (int)this.y; }
    public int getDamage() { return this.damage; }
}