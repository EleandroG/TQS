import entities.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.CarRepository;
import service.CarManagerService;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    CarManagerService carManagerService;

    @Test
    public void getCarDetailsTest() {
        given(carRepository.findByCarId(1L)).willReturn(new Car("Tesla", "Model S"));

        Car car = carManagerService.getCarDetails(1L);

        Assertions.assertThat(car.getModel()).isEqualTo("Model S");
        Assertions.assertThat(car.getMaker()).isEqualTo("Tesla");
    }

    @Test
    public void getAllCarsTest() throws Exception {
        //por fazer
    }
}
