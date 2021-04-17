import entities.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import service.CarManagerService;

import static org.mockito.ArgumentMatchers.anyLong;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CarControllerTest {

    @MockBean
    CarManagerService carManagerService;

    @Autowired
    MockMvc servlet;

    @Test
    public void getCarByIdTest() throws Exception {
        given(carManagerService.getCarDetails(anyLong())).willReturn(new Car("Tesla", "Model S"));

        servlet.perform(MockMvcRequestBuilders.get("/cars/models"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Model S"));
    }

    @Test
    public void getAllCarsTest() throws Exception {
        //por fazer
    }

    @Test
    public void createCatTest() throws Exception {
        //por fazer
    }

}
