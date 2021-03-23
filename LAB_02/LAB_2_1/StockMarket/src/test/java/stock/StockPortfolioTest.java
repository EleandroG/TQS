package stock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//Sempre que se usa Mockito
@ExtendWith(MockitoExtension.class)
class StockPortfolioTest {

    //SuT --> System Under Test
    @InjectMocks
    private StockPortfolio portfolio;

    @Mock
    private ITStockMarket itStockMarket;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getTotalValue() {

        Stock A = new Stock("NIO", 5);
        Stock B = new Stock("HCMC", 10);

        portfolio.addStock(A);
        portfolio.addStock(B);

        //Load the mock with the proper expectations (when...thenReturn)
        when(itStockMarket.getPrice("NIO")).thenReturn(100.0);
        when(itStockMarket.getPrice("HCMC")).thenReturn(200.0);

        double total = portfolio.getTotalValue();
        assertThat(total, equalTo(2500.0));

        //Verify the result (assert) and the use of the mock (verify)
        //verifica que a função foi chamada 2 vezes
        verify(itStockMarket, Mockito.times(2)).getPrice(anyString());
    }
}