import entities.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import repository.CarRepository;

@DataJpaTest
public class CarRepositoryTest {

    //@Autowired
    private CarRepository carRepository;

    //avoid the springboot optimizations and to save data to database
    @Autowired
    TestEntityManager testEntityManager;

    //Test Failed
    @Test
    public void getAllCarsTest() {
        Car savedCar = testEntityManager.persistAndFlush(new Car("Tesla", "Model S"));

        Car car = carRepository.findByCarId(1L);

        Assertions.assertThat(car.getMaker()).isEqualTo(savedCar.getMaker());
    }
}
