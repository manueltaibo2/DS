package e2;

import java.util.HashSet;
import java.util.Set;

public class CustomClient implements Observer {
    private Set<String> interestedAttributes; // Atributos que interesan al cliente

    public CustomClient(Set<String> interestedAttributes) {
        this.interestedAttributes = new HashSet<>(interestedAttributes);
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof ShareData) {
            ShareData share = (ShareData) subject;
            System.out.println("CustomClient Notification:");

            // Mostrar los atributos que interesan
            if (interestedAttributes.contains("symbol")) {
                System.out.println("Symbol: " + share.getSymbol());
            }
            if (interestedAttributes.contains("close")) {
                System.out.println("Close: " + share.getClose());
            }
            if (interestedAttributes.contains("high")) {
                System.out.println("High: " + share.getHigh());
            }
            if (interestedAttributes.contains("low")) {
                System.out.println("Low: " + share.getLow());
            }
            if (interestedAttributes.contains("volume")) {
                System.out.println("Volume: " + share.getVolume());
            }
        }
    }
}
