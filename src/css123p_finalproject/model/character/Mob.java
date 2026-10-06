package css123p_finalproject.model.character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Mob {
    private int x, y;
    private int speed;
    private int health;
    public long lastAttackTime = 0;
    private BufferedImage sprite;
    
    private int width = 64;
    private int height = 64;

    public Mob(String shortPath, int startX, int startY, int speed, int health) {
        this.x = startX;
        this.y = startY;
        this.speed = speed;
        this.health = health;

        try {
            // Attempt 1: Read raw file from the src folder (Bypasses the NetBeans compiler)
            java.io.File file = new java.io.File("src/css123p_finalproject/model/character/sprites/" + shortPath);
            if (file.exists()) {
                this.sprite = ImageIO.read(file);
            } else {
                // Attempt 2: Read from the compiled build folder (If IDE shifted the working directory)
                java.net.URL url = getClass().getResource("/css123p_finalproject/model/character/sprites/" + shortPath);
                if (url != null) {
                    this.sprite = ImageIO.read(url);
                } else {
                    System.err.println("Could not find image at either location for: " + shortPath);
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to load image: " + shortPath);
        }
    }
    
    // Movement Logic
    public int getX() { return this.x; }
    public int getHealth() { return this.health; }
    public int getWidth() { return this.width; } 

    public void moveLeft() { this.x -= this.speed; }
    public void moveRight() { this.x += this.speed; }
    
    public int getY() { return this.y; }
    public int getHeight() { return this.height; }

    public void moveUp() { this.y -= this.speed; }
    public void moveDown() { this.y += this.speed; }
    
    // Used for collision physics to push the mob without overriding speed
    public void adjustPosition(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health < 0) this.health = 0;
    }

    public void draw(Graphics2D g2d) {
        if (this.sprite != null) {
            // Draws the image explicitly scaled to 64x64
            g2d.drawImage(this.sprite, this.x, this.y, this.width, this.height, null);
        } else {
            g2d.setColor(this.speed > 0 ? Color.BLUE : Color.RED);
            g2d.fillRect(this.x, this.y, this.width, this.height);
        }
        
        // The green hitbox overlay
        g2d.setColor(Color.GREEN);
        g2d.drawRect(this.x, this.y, this.width, this.height);
        
        g2d.setColor(Color.WHITE);
        g2d.drawString("HP: " + this.health, this.x, this.y - 10);
    }
}