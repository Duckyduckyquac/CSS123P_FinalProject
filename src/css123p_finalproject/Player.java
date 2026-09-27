/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package css123p_finalproject;

/**
 *
 * @author Jacob
 */
public class Player {
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
    public int getHp(){
        return this.hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public int getDefense(){
        return this.defense;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }
    public int getAtk(){
        return this.atk;
    }
    public void setAtk(int atk){
        this.atk = atk;
    }
    public int getStamina(){
        return this.stamina;
    }
    public void setStamina(int stamina){
        this.stamina = stamina;
    }
    
}
