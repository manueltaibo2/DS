package e2;

public class DetailedClient implements Observer {
    @Override
    public void update(Subject subject) {
        if (subject instanceof ShareData) {
            ShareData share = (ShareData) subject;
            System.out.println("DetailedClient Notification:");
            System.out.println("Symbol: " + share.getSymbol() +
                    ", Close: " + share.getClose() +
                    ", High: " + share.getHigh() +
                    ", Low: " + share.getLow() +
                    ", Volume: " + share.getVolume());
        }
    }
}
