package chapter3.starbuzzWithSizes;

public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        if (getSize() == Size.TALL) {
            cost += .10;
        } else if (getSize() == Size.GRANDE) {
            cost += .15;
        } else if (getSize() == Size.VENTI) {
            cost += .20;
        }
        return cost;
    }
}
