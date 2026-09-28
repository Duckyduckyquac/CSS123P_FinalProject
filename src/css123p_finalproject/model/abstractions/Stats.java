package css123p_finalproject.model.abstractions;

abstract class Stats {
    int HP;
    int ATK;
    int DEF;
    int STAMINA;

    abstract int getHP();

    abstract getATK();

    abstract getDEF();

    abstract getSTAMINA();

    abstract setHP();

    abstract setATK();

    abstract setDEF();

    abstract setSTAMINA();
}