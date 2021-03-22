package stock;

import java.util.ArrayList;
import java.util.List;

public class StockPortfolio {

    private String name;
    private List<Stock> stocks;
    private ITStockMarket itStockMarket;

    public StockPortfolio(String name, List<Stock> stocks) {
        this.name = name;
        this.stocks = new ArrayList<Stock>();
    }

    public ITStockMarket getMarketService() {
        return itStockMarket;
    }

    public void setMarketService(ITStockMarket marketService) {
        this.itStockMarket = marketService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalValue() {
        double total = 0;
        for(int i = 0; i < this.stocks.size(); i++) {
            total += this.itStockMarket.getPrice(this.stocks.get(i).getName());
        }
        return total;
    }

    public void addStock(Stock newStock) {
        this.stocks.add(newStock);
    }
}
