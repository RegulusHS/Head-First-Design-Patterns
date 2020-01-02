package chapter3.starbuzzWithSizes;

public abstract class Beverage {
    public enum Size { TALL, GRANDE, VENTI };
    String description = "Unknown Beverage";
    Size size = Size.TALL;

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
