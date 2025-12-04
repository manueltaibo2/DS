package e4;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class EuroCoinCollection {
    private final Set<EuroCoin> collection;

    public EuroCoinCollection() {
        collection = new LinkedHashSet<>();
    }

    public boolean add(EuroCoin coin) {
        return collection.add(coin);
    }

    public boolean remove(EuroCoin coin) {
        return collection.remove(coin);
    }

    public int count() {
        return collection.size();
    }

    public int totalValue(){
        return collection.stream().mapToInt(EuroCoin::value).sum();
    }

    public boolean hasCoin (EuroCoin coin) {
        return collection.contains(coin);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Collection of: ").append(count()).append(" coins:\n");
        for (EuroCoin coin : collection) {
            sb.append(coin.toString()).append("\n");
        }
        return sb.toString().trim(); // Eliminar el último salto de línea si es necesario
    }
}
