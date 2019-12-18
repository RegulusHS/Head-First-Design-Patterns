package chapter1.puzzle;

public class Queen extends Character {
    public Queen() {
        weaponBehavior = new KnifeBehavior();
    }

    @Override
    void fight() {
        weaponBehavior.useWeapon();
    }
}
