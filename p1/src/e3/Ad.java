package e3;

import java.util.Objects;

public class Ad {
    private final String agency;
    private final Property property;
    private final AdType adType;
    private int price;


    //constructor pricipal, para inicializar un objeto ad
    public Ad(String agency, Property property, AdType adType, int priceInEuros) {
        this.agency = agency;
        this.property = property;
        this.adType = adType;
        this.price = priceInEuros;
    }

    //constructor de copia
    public Ad(Ad other) {
        this.agency = other.agency;
        this.property = other.property;
        this.adType = other.adType;
        this.price = other.price;
    }

    //comprobar si tienen la misma propiedad
    public boolean isPropertyEqual(Ad ad) {
        return this.property.equals(ad.property);
    }

    //comprobamos si el precio es normal
    public boolean isPriceNormal() {
        if (adType == AdType.PURCHASE) {
            return price >= 100000 && price <= 500000;
        } else if (adType == AdType.RENTAL) {
            return price >= 500 && price <= 5000;
        }
        return false;
    }

    //comprobamos el precio por metro cuadrado
    public double priceMetersEuros() {
        if (property.squareMeters() == 0) {
            throw new ArithmeticException("Cannot divide by zero: property has zero square meters.");
        }
        return (double) price / property.squareMeters();
    }

    //reduccion de precio
    public void dropPrice(int percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100.");
        }
        this.price -= this.price * percentage / 100;
    }

    //obtener el precio
    public int getPriceInEuros() {
        return price;
    }

    @Override
    //sobreescribimos el equals para que dos objetos sean iguales si tienen el mismo precio, propiedad, agencia y tipo de anuncio
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return price == ad.price && agency.equals(ad.agency) &&
                property.equals(ad.property) && adType == ad.adType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(agency, property, adType, price);
    }
}



