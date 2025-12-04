package e2;

public class ShareData extends Subject {
    private String symbol;
    private double close;
    private double high;
    private double low;
    private int volume;

    public ShareData(String symbol, double close, double high, double low, int volume) {
        this.symbol = symbol;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        notifyObservers();
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        if (close < 0) {
            throw new IllegalArgumentException("El precio de cierre no puede ser negativo");
        }
        this.close = close;
        notifyObservers();
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        if (high < 0) {
            throw new IllegalArgumentException("El precio máximo no puede ser negativo");
        }
        this.high = high;
        notifyObservers();
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        if (low < 0) {
            throw new IllegalArgumentException("El precio mínimo no puede ser negativo");
        }
        this.low = low;
        notifyObservers();
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("El volumen no puede ser negativo");
        }
        this.volume = volume;
        notifyObservers();
    }
}
