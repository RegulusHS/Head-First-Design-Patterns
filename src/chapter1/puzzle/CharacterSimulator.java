package chapter1.puzzle;

public class CharacterSimulator {
    public static void main(String[] args) {
        Character king = new King();
        king.fight();

        Character queen = new Queen();
        queen.fight();
        queen.setWeaponBehavior(new AxeBehavior());
        queen.fight();
    }
}
