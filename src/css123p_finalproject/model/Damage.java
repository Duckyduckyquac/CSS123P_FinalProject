package css123p_finalproject.model;

import css123p_finalproject.model.weapons;

public class Damage {
    
    boolean DmgMultiplied = false;
    boolean DmgReduced = false;
    
    Damage(boolean Dmg, boolean DmgMultiplier, boolean DmgReduced) {

        if (DmgMultiplier == true) {
            this.DmgMultiplied = Dmg
        }

    };

    public float CalcDmg()
};