package css123p_finalproject.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import css123p_finalproject.model.character.Mob;

public class Player extends Stats {

    // 1. Physical & Visual State
    private int x, y;
    private int width = 64;
    private int height = 64;
    private BufferedImage sprite;
    
    // 2. Combat State
    public int currentWeapon = 1; // 1 = Sword, 2 = Gun, 3 = Staff
    public double SPEED;
    public double MAXHP;

    public Player(String shortPath, int startX, int startY, int HP, int ATK, int DEF, int STAMINA, double speed) {
        super(HP, ATK, DEF, STAMINA); // Initialize the abstract Stats
        this.MAXHP = HP;
        this.x = startX;
        this.y = startY;
        this.SPEED = speed;

        try {
            java.io.File file = new java.io.File("src/css123p_finalproject/model/character/sprites/" + shortPath);
            if (file.exists()) {
                this.sprite = ImageIO.read(file);
            } else {
                java.net.URL url = getClass().getResource("/css123p_finalproject/model/character/sprites/" + shortPath);
                if (url != null) this.sprite = ImageIO.read(url);
            }
        } catch (Exception e) {
            System.err.println("Failed to load player image.");
        }
    }

    // --- MOVEMENT & GEOMETRY ---
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getWidth() { return this.width; }
    public int getHeight() { return this.height; }

    public void moveUp() { this.y -= this.SPEED; }
    public void moveDown() { this.y += this.SPEED; }
    public void moveLeft() { this.x -= this.SPEED; }
    public void moveRight() { this.x += this.SPEED; }

    // --- COMBAT LOGIC ---
    public void takeDamage(int amount) {
        setHP(Math.max(0, getHP() - amount));
    }

    public void executeAttack(int mx, int my, java.util.ArrayList<Mob> goblins, java.util.ArrayList<Projectile> projectiles) {
        for (Mob g : goblins) {
            // Check if the click landed inside the goblin's hitbox
            if (g.getHealth() > 0 && mx >= g.getX() && mx <= g.getX() + g.getWidth() && my >= g.getY() && my <= g.getY() + g.getHeight()) {
                
                if (this.currentWeapon == 1) { 
                    // SWORD: Check physical distance, use ATK stat for damage
                    double dist = Math.hypot(g.getX() - this.x, g.getY() - this.y);
                    if (dist <= this.width * 1.5) g.takeDamage(getATK()); 
                } 
                else if (this.currentWeapon == 2) { 
                    // GUN: Spawns yellow projectile
                    projectiles.add(new Projectile(this.x, this.y, g.getX() + (g.getWidth()/2), g.getY() + (g.getHeight()/2), 15, 10, Color.YELLOW));
                } 
                else if (this.currentWeapon == 3) { 
                    // STAFF: Spawns cyan projectile
                    projectiles.add(new Projectile(this.x, this.y, g.getX() + (g.getWidth()/2), g.getY() + (g.getHeight()/2), 8, 30, Color.CYAN));
                }
                break; // Stop checking after triggering an attack on one target
            }
        }
    }

    // --- RENDER LOGIC ---
    public void draw(Graphics2D g2d) {
        if (this.sprite != null) {
            g2d.drawImage(this.sprite, this.x, this.y, this.width, this.height, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.fillRect(this.x, this.y, this.width, this.height);
        }
        
        g2d.setColor(Color.GREEN);
        g2d.drawRect(this.x, this.y, this.width, this.height);
        
        g2d.setColor(Color.WHITE);
        g2d.drawString("HP: " + getHP() + "/" + (int)MAXHP, this.x, this.y - 10);
    }

    // --- STATS OVERRIDES ---
    @Override public int getHP(){ return this.HP; }
    @Override public void setHP(int hp){ this.HP = hp; }
    @Override public int getDEF(){ return this.DEF; }
    @Override public void setDEF(int defense){ this.DEF = defense; }
    @Override public int getATK(){ return this.ATK; }
    @Override public void setATK(int atk){ this.ATK = atk; }
    @Override public int getSTAM(){ return this.STAMINA; }
    @Override public void setSTAM(int stamina){ this.STAMINA = stamina; }
}