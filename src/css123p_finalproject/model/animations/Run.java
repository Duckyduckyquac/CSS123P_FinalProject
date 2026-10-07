package css123p_finalproject.model.animations;

public class Run {
    private double speed = 10.0;
    private double maxSwingAngle = 1.2;
    private double bobHeight = 4.0;
    private boolean running = false;
    
    private double previous_step = 0.0;
    private double new_step = 0.0;

    public Run() {
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public double run_movement(double deltaTime) {
        if (running) {
            previous_step = new_step;
            new_step += deltaTime * speed;
            return new_step - previous_step;
        }
        return 0.0;
    }

    public double getLeftLegAngle() {
        return Math.sin(new_step) * maxSwingAngle;
    }

    public double getRightLegAngle() {
        return Math.sin(new_step + Math.PI) * maxSwingAngle; 
    }

    public double getLeftArmAngle() {
        return Math.sin(new_step + Math.PI) * maxSwingAngle;
    }

    public double getRightArmAngle() {
        return Math.sin(new_step) * maxSwingAngle;
    }

    public double getBodyYOffset() {
        return Math.abs(Math.sin(new_step)) * bobHeight;
    }
}