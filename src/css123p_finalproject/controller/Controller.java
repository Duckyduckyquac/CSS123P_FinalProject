package css123p_finalproject.controller;

import css123p_finalproject.model.GameEnvironment;
import css123p_finalproject.model.Player;
import css123p_finalproject.controller.events.EventHandling;

public class Controller {
    private GameEnvironment environment;

    public Controller(GameEnvironment environment) {
        this.environment = environment;
    }

    public void processInput(EventHandling input) {
        Player p = environment.getPlayer();

        if (p.getHP() > 0) {
            if (input.requestedSlot != -1) {
                p.selectSlot(input.requestedSlot);
                input.requestedSlot = -1;
            }

            if (input.dashRequested) {
                if (p.getSTAM() < 12) {
                    input.dashRequested = false;
                }
                p.dash(input.lastDirX, input.lastDirY);
                input.dashRequested = false;
            }

            if (input.up) p.setY(p.getY() - p.SPEED);
            if (input.down) p.setY(p.getY() + p.SPEED);
            if (input.left) p.setX(p.getX() - p.SPEED);
            if (input.right) p.setX(p.getX() + p.SPEED);
        }
    }

    public void handleAttack(int targetX, int targetY) {
        if (!environment.isTitleScreen() && !environment.isGameWon() && !environment.isPaused()) {
            if (environment.getPlayer().getHP() > 0) {
                // SlashEffects argument is completely removed here
                environment.getPlayer().attack(targetX, targetY, environment.getEnemies(), environment.getProjectiles());
            }
        }
    }

    public void update() {
        environment.updateWorld();
    }
}