package css123p_finalproject.model.animations;

public class IdleMode {

    private boolean idling;

    public IdleMode() {
        this.idling = true;
    }

    public void setIdle(boolean idling) {
        this.idling = idling;
    }

    public double[] idleMovement(double deltaTime) {
        if (this.idling) {
            double headY = Math.sin(deltaTime * 3.0) * 1.5;
            double torsoY = Math.sin(deltaTime * 2.0) * 1.0;
            double leftArmRot = Math.cos(deltaTime * 2.0) * 1.2;
            double rightArmRot = Math.cos(deltaTime * 2.0 + Math.PI) * 1.2;
            
            return new double[] { headY, torsoY, leftArmRot, rightArmRot };
        }
        return new double[] { 0.0, 0.0, 0.0, 0.0 };
    }
}