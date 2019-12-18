package chapter1.ducks;

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay(); //一开始，我们的模型鸭是不会飞的。
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
