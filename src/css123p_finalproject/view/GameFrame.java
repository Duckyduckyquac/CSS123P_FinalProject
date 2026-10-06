package css123p_finalproject.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import css123p_finalproject.model.character.Mob;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("CSS123P Final Project - MVP");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); 
        add(new GamePanel());
    }
}

class GamePanel extends JPanel implements ActionListener {
    // Player is now strictly using your actual Player/Stats class
    private css123p_finalproject.model.Player player;
    private java.util.ArrayList<Mob> goblins;
    private java.util.ArrayList<css123p_finalproject.model.Projectile> projectiles;
    private Timer gameLoop;

    private int currentFloor = 1;
    private boolean gameWon = false;

    private boolean upPressed, downPressed, leftPressed, rightPressed;

    public GamePanel() {
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
        requestFocusInWindow(); 
        
        goblins = new java.util.ArrayList<>();
        projectiles = new java.util.ArrayList<>();
        
        // Initialize Player with actual RPG stats: 100 HP, 25 ATK, 10 DEF, 100 STAM, 10 Speed
        player = new css123p_finalproject.model.Player("players/playerOneIdle.jpg", 150, 250, 100, 25, 10, 100, 10);
        
        loadFloor(currentFloor);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_1) player.currentWeapon = 1; 
                if (e.getKeyCode() == KeyEvent.VK_2) player.currentWeapon = 2; 
                if (e.getKeyCode() == KeyEvent.VK_3) player.currentWeapon = 3; 

                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) upPressed = true;
                if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) downPressed = true;
                if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) leftPressed = true;
                if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) rightPressed = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) upPressed = false;
                if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) downPressed = false;
                if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) leftPressed = false;
                if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) rightPressed = false;
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!gameWon) {
                    // All attack vector math is now safely encapsulated inside Player.java
                    player.executeAttack(e.getX(), e.getY(), goblins, projectiles);
                }
            }
        });

        gameLoop = new Timer(16, this);
        gameLoop.start();
    }

    private void loadFloor(int floor) {
        goblins.clear();
        projectiles.clear();
        
        // Maintain HP between floors, reset position
        player = new css123p_finalproject.model.Player(
            "players/playerOneIdle.jpg", 150, 250, player.getHP(), player.getATK(), player.getDEF(), player.getSTAM(), player.SPEED);

        switch (floor) {
            case 1:
                for (int i = 0; i < 5; i++) goblins.add(new Mob("mobs/goblinIdle.jpg", 500 + (i * 40), 100 + (i * 80), 2, 200));
                break;
            case 2:
                for (int i = 0; i < 8; i++) goblins.add(new Mob("mobs/goblinIdle.jpg", 550 + (i * 30), 50 + (i * 60), 3, 200));
                break;
            case 3:
                for (int i = 0; i < 12; i++) goblins.add(new Mob("mobs/goblinIdle.jpg", 400 + (i * 45), 30 + (i * 40), 2, 200));
                break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.WHITE);
        if (gameWon) {
            g2d.drawString("YOU CLEARED ALL FLOORS! YOU WIN!", 300, 300);
            return;
        }

        String weaponName = player.currentWeapon == 1 ? "SWORD" : (player.currentWeapon == 2 ? "GUN" : "STAFF");
        g2d.drawString("FLOOR " + currentFloor + " | Active Weapon: " + weaponName, 20, 20);

        if (player != null) player.draw(g2d);
        for (Mob goblin : goblins) if (goblin.getHealth() > 0) goblin.draw(g2d);
        for (css123p_finalproject.model.Projectile p : projectiles) p.draw(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameWon) return; 

        long currentTime = System.currentTimeMillis();
        boolean floorCleared = true;

        if (upPressed) player.moveUp();
        if (downPressed) player.moveDown();
        if (leftPressed) player.moveLeft();
        if (rightPressed) player.moveRight();

        for (int i = 0; i < goblins.size(); i++) {
            Mob g1 = goblins.get(i);
            if (g1.getHealth() <= 0) continue;
            
            floorCleared = false; 

            if (g1.getX() > player.getX() + 5) g1.moveLeft();
            else if (g1.getX() < player.getX() - 5) g1.moveRight();
            if (g1.getY() > player.getY() + 5) g1.moveUp();
            else if (g1.getY() < player.getY() - 5) g1.moveDown();

            double distanceToPlayer = Math.hypot(g1.getX() - player.getX(), g1.getY() - player.getY());
            if (distanceToPlayer <= player.getWidth()) {
                if (currentTime - g1.lastAttackTime >= 1000) {
                    player.takeDamage(1);
                    g1.lastAttackTime = currentTime;
                }
            }

            for (int j = i + 1; j < goblins.size(); j++) {
                Mob g2 = goblins.get(j);
                if (g2.getHealth() <= 0) continue;

                double dx = g1.getX() - g2.getX();
                double dy = g1.getY() - g2.getY();
                double distance = Math.hypot(dx, dy);

                if (distance < g1.getWidth() && distance > 0) {
                    double overlap = g1.getWidth() - distance;
                    int pushX = (int) ((dx / distance) * (overlap / 2.0));
                    int pushY = (int) ((dy / distance) * (overlap / 2.0));
                    g1.adjustPosition(pushX, pushY);
                    g2.adjustPosition(-pushX, -pushY);
                }
            }
        }

        if (floorCleared) {
            currentFloor++;
            if (currentFloor > 3) gameWon = true; 
            else loadFloor(currentFloor); 
        }

        java.util.Iterator<css123p_finalproject.model.Projectile> it = projectiles.iterator();
        while (it.hasNext()) {
            css123p_finalproject.model.Projectile p = it.next();
            p.update();
            
            if (p.getX() < -200 || p.getX() > 1200 || p.getY() < -200 || p.getY() > 1000) {
                it.remove();
                continue;
            }

            boolean hit = false;
            for (Mob g : goblins) {
                if (g.getHealth() > 0 && p.getX() >= g.getX() && p.getX() <= g.getX() + g.getWidth() && p.getY() >= g.getY() && p.getY() <= g.getY() + g.getHeight()) {
                    g.takeDamage(p.getDamage());
                    hit = true;
                    break;
                }
            }
            if (hit) it.remove();
        }
        repaint();
    }
}