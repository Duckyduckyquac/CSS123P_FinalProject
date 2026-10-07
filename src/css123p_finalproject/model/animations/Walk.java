package css123p_finalproject.model.animations;

public class Walk {
    private double time = 0.0;
    
    private double speed = 5.0;
    private double maxSwingAngle = 0.5;
    private double bobHeight = 2.0;

    public Walk() {
    }

    public void update(double deltaTime) {
        time += deltaTime * speed;
    }

    public double getLeftLegAngle() {
        return Math.sin(time) * maxSwingAngle;
    }

    public double getRightLegAngle() {
        return Math.sin(time + Math.PI) * maxSwingAngle; 
    }

    public double getLeftArmAngle() {
        return Math.sin(time + Math.PI) * maxSwingAngle;
    }

    public double getRightArmAngle() {
        return Math.sin(time) * maxSwingAngle;
    }

    public double getBodyYOffset() {
        return Math.abs(Math.sin(time)) * bobHeight;
    }
}