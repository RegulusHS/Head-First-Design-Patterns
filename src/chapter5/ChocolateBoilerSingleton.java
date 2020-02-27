package chapter5;

public class ChocolateBoilerSingleton {
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoilerSingleton uniqueInstance;

    private ChocolateBoilerSingleton() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoilerSingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ChocolateBoilerSingleton();
        }
        return uniqueInstance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            // 在锅炉内填充巧克力和牛奶的混合物
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            //排出煮沸的巧克力和牛奶
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            //将炉内物煮沸
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
