package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;


@Component
public class CarServiceImpl implements CarService {
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car("model1", 325, "black"));
        cars.add(new Car("model2", 330, "red"));
        cars.add(new Car("model3", 530, "blue"));
        cars.add(new Car("model4", 535, "orange"));
        cars.add(new Car("model5", 540, "green"));


    }

    @Override
    public List<Car> carList() {
        return cars;
    }

    @Override
    public List<Car> showCar(int count) {
        if(count >=5) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
}
