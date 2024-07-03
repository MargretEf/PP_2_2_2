package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.List;
@Component
public class CarServiseImpl implements CarService{


@Override
    public List<Car> returnCar(List<Car> cars, int amount) {
        return cars.stream().limit(amount).toList();
    }
}
