package css123p_finalproject.model.character;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import css123p_finalproject.model.animations.*;

public class PlayerOne {

    private int x, y;
    private int speed;
    private int health;
    
    // Time tracker for our math formulas
    private long initTime = System.currentTimeMillis();
    
    // The Visual Sprite
    private BufferedImage sprite;

    public PlayerOne(String spritePath, int startX, int startY, int speed, int health) {
        this.x = startX;
        this.y = startY;
        this.speed = speed;
        this.health = health;
        
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

    public void updateMovement(String execAnimation) {
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

    // Drawing logic using Java Swing/AWT, filled with Math Formulas
    private void draw(Graphics2D g2d) {
        if (sprite != null) {
            // Math Formula 1: Calculate elapsed time as a continuous double (T = Δt / 1000)
            double time = (System.currentTimeMillis() - initTime) / 1000.0;

            // Math Formula 2 & 3: Trigonometry for offset limits (Amplitude * sin(Frequency * T))
            // Creates a smooth "breathing" or "floating" bobbing effect
            int mathOffsetX = (int) (Math.cos(time * 2.0) * 4.0); 
            int mathOffsetY = (int) (Math.sin(time * 4.0) * 8.0); 

            // Math Formula 4 & 5: Algebraic center calculation (Center = Position + Offset + (Dimension / 2))
            double centerX = x + mathOffsetX + (sprite.getWidth() / 2.0);
            double centerY = y + mathOffsetY + (sprite.getHeight() / 2.0);

            // Math Formula 6: Oscillating rotation angle formula (Angle = maxRadians * sin(T))
            double rotationAngle = (Math.PI / 32) * Math.sin(time * 3.0);

            // Apply mathematical rotation to the graphics context
            g2d.rotate(rotationAngle, centerX, centerY);
            
            // Draw the sprite applying our mathematical X and Y offsets
            g2d.drawImage(sprite, x + mathOffsetX, y + mathOffsetY, null);
            
            // Reverse the mathematical rotation using its inverse so it doesn't break the rest of your game canvas
            g2d.rotate(-rotationAngle, centerX, centerY);
        }
    }
}