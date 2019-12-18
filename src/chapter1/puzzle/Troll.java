package chapter1.puzzle;

public class Troll extends Character {
    public Troll() {
        weaponBehavior = new AxeBehavior();
    }

    @Override
    void fight() {
        weaponBehavior.useWeapon();
    }
}
