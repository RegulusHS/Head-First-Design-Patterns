package chapter2.weatherStation;

public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
