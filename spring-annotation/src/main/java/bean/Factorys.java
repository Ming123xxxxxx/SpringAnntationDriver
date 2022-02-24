package bean;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/16 11:21
 */
public class Factorys {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Factorys{" +
                "car=" + car +
                '}';
    }
}
