package chapter1.puzzle;

public class Knight extends Character {
    public Knight() {
        weaponBehavior = new SwordBehavior();
    }

    @Override
    void fight() {
        weaponBehavior.useWeapon();
    }
}
