//.
package com.keyin.SDATFinalSprint;

import com.keyin.stock.Stock;
import com.keyin.stock.StockService;
import com.keyin.stockmarket.StockMarket;
import com.keyin.stock.StockController;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SdatFinalSprintApplicationTests {

    @Autowired
    private StockController stockController;
    private Stock stock;
    private StockService stockService;

    @MockBean
    private StockService mockStockService;

    @Test
    void contextLoads() {
        // This tests if the application context loads successfully.
    }

    @Test
    void stockControllerLoads() {
        // This tests if the stock controller loads successfully.
        assertThat(stockController).isNotNull();
    }

    @Test
    void testCreateStock() {
        StockMarket stockMarket = new StockMarket();
        stockMarket.setName("NASDAQ");

        Stock stock = new Stock();
        stock.setId(1L);
        stock.setSymbol("AAPL");
        stock.setStockMarket(stockMarket);
        stock.setPrice(150.0);

        assertThat(stock).isNotNull();
        assertThat(stock.getSymbol()).isEqualTo("AAPL");
        assertThat(stock.getPrice()).isEqualTo(150.0);
        assertThat(stock.getStockMarket()).isEqualTo(stockMarket);
    }

    @Test
    void testCreateStockWithMock() {
        StockMarket stockMarket = new StockMarket();
        stockMarket.setName("NASDAQ");

        Stock stock = new Stock();
        stock.setId(1L);
        stock.setSymbol("AAPL");
        stock.setStockMarket(stockMarket);
        stock.setPrice(150.0);

        Mockito.when(mockStockService.saveStock(stock)).thenReturn(stock);

        Stock createdStock = mockStockService.saveStock(stock);

        assertThat(createdStock).isNotNull();
        assertThat(createdStock.getSymbol()).isEqualTo("AAPL");
        assertThat(createdStock.getPrice()).isEqualTo(150.0);
        assertThat(createdStock.getStockMarket()).isEqualTo(stockMarket);
    }
}

