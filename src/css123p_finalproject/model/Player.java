/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package css123p_finalproject.model;

import css123p_finalproject.model.abstractions.Stats;

/**
 *
 * @author Group 3
 */

interface PlayerAttack {
    void execute(Player player);
}


public class Player extends Stats {

    private int hp = 0;
    private int atk = 0;
    private int defense = 0;
    private int stamina = 0;
    
    @Override
    public void Stats(int HP, int ATK, int DEF, int STAMINA) {
        this.setHP(HP);
        this.setATK(ATK);
        this.setDEF(DEF);
        this.setSTAM(STAMINA);
    }

    @Override
    public int getHP(){
        return this.hp;
    }
    
    @Override
    public void setHP(int hp){
        this.hp = hp;
    }
    
    @Override
    public int getDEF(){
        return this.defense;
    }

    @Override
    public void setDEF(int defense){
        this.defense = defense;
    }

    @Override
    public int getATK(){
        return this.atk;
    }

    @Override
    public void setATK(int atk){
        this.atk = atk;
    }
    
    @Override
    public int getStAM(){
        return this.stamina;
    }

    @Override
    public void setSTAM(int stamina){
        this.stamina = stamina;
    }
    
}
