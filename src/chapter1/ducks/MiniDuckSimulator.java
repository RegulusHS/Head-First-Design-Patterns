package chapter1.ducks;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered()); //在运行时想改变鸭子的行为，只需调用鸭子的setter方法就可以。
        model.performFly();
    }
}
