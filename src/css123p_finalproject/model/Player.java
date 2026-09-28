/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package css123p_finalproject.model;

import .abstractions.Stats;

/**
 *
 * @author Jacob
 */


public class Player extends Stats {

    private int hp = 0;
    private int atk = 0;
    private int defense = 0;
    private int stamina = 0;
    
    public Player(int hp, int defense, int atk, int stamina){

        this.hp = hp;
        this.defense = defense;
        this.atk = atk;
        this.stamina = stamina;
    }

    @override
    public int getHP(){
        return this.hp;
    }

    @override
    public void setHP(int hp){
        this.hp = hp;
    }

    @override
    public int getDEF(){
        return this.defense;
    }

    @override
    public void setDEF(int defense){
        this.defense = defense;
    }

    @override
    public int getAtk(){
        return this.atk;
    }

    @override
    public void setATK(int atk){
        this.atk = atk;
    }

    @override
    public int getStAMINA(){
        return this.stamina;
    }

    public void setSTAMINA(int stamina){
        this.stamina = stamina;
    }
    
}
