/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package css123p_finalproject.model;

import css123p_finalproject.model.Stats;

/**
 *
 * @author Group 3
 */

interface PlayerAttack {
    void execute(Player player);
}

public class Player extends Stats {

    public double BASEDMG;
    public double DMGBOOST;
    public double SPEED;
    public double MAXHP;
    
    // Fixed: Must call super() to initialize the parent Stats class
    public Player(int HP, int ATK, int DEF, int STAMINA) {
        super(HP, ATK, DEF, STAMINA);
        this.MAXHP = HP;
    }

    @Override
    public int getHP(){
        return this.HP;
    }
    
    @Override
    public void setHP(int hp){
        this.HP = hp;
    }
    
    @Override
    public int getDEF(){
        return this.DEF;
    }

    @Override
    public void setDEF(int defense){
        this.DEF = defense;
    }

    @Override
    public int getATK(){
        return this.ATK;
    }

    @Override
    public void setATK(int atk){
        this.ATK = atk;
    }
    
    @Override
    public int getSTAM(){
        return this.STAMINA;
    }

    @Override
    public void setSTAM(int stamina){
        this.STAMINA = stamina;
    }
}