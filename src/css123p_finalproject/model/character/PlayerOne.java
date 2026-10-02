package css123p_finalproject.model.character;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class PlayerOne {

    private int x, y;
    private int speed;
    private int health;
    
    // The Visual Sprite
    private BufferedImage sprite;

    // Constructor: You pass the specific image path when spawning the mob
    public PlayerOne(String spritePath, int startX, int startY, int speed, int health) {
        this.x = startX;
        this.y = startY;
        this.speed = speed;
        this.health = health;
        
        // Load the image safely from your folder structure
        try {
            URL imgUrl = getClass().getResource(spritePath);
            if (imgUrl != null) {
                this.sprite = ImageIO.read(imgUrl);
            } else {
                System.err.println("Could not find sprite at: " + spritePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     private void execAtkMode() {
        AttackMode attack = new AttackMode();
    }

    private void execIdleMode() {
        IdleMode idle = new IdleMode();
    }

    private void execWalk() {
        Walk walk = new Walk();
    }

    private void execRun() {
        Run run = new Run();
    }

    private void execSwing() {
        SwordSwing swing = new SwordSwing();
    }

    private void execFire() {
        FireGun fire = new FireGun();
    }

    public void updateMovement(string execAnimation) {
        switch (execAnimation) {
            case "Idle":
                this.execIdleMode();
                break;
            case "Attack":
                this.execAtkMode();
                break;
            case "Walk":
                this.execWalk();
                break;
            case "Run":
                this.execRun();
                break;
            case "Swing":
                this.execSwing();
                break;
            case "Fire":
                this.execFire();
                break;
        }
    }

    // Drawing logic using Java Swing/AWT
    public void draw(Graphics2D g2d) {
        if (sprite != null) {
            g2d.drawImage(sprite, x, y, null);
        }
    }
}
