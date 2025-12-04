package e4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public record EuroCoin(int value, EuroCountry country, int year, String design, CoinMaterial material) {

    public EuroCoin{
        if (value <=0){
            throw new IllegalArgumentException("Must be a real value");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EuroCoin)) return false;
        EuroCoin other = (EuroCoin) obj;
        return value == other.value &&
                material == other.material &&
                country == other.country &&
                design.equals(other.design);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, country, design);
    }

    @Override
    public String toString() {
        return value + "CENT - " + design + " (" + country.getName() + ", " + material + ")";
    }
}
