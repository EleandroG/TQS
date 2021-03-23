package stock;

import java.util.ArrayList;
import java.util.List;

public class StockPortfolio {

    private String name;
    private List<Stock> stocks = new ArrayList<Stock>();
    private ITStockMarket itStockMarket;

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
        for (Stock item: stocks){
            total = total + (itStockMarket.getPrice(item.getName())*item.getQuantity());
        };
        return total;
    }

    public void addStock(Stock newStock) {
        this.stocks.add(newStock);
    }
}
