package chapter1.puzzle;

public class King extends Character {
    public King() {
        weaponBehavior = new BowAndArrowBehavior();
    }

    @Override
    void fight() {
        weaponBehavior.useWeapon();
    }
}
