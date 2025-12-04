package e2;

public class SimpleClient implements Observer {
    @Override
    public void update(Subject subject) {
        if (subject instanceof ShareData share) {
            System.out.println("SimpleClient Notification:\nSymbol: " + share.getSymbol() + ", Close: " + share.getClose());
        }
    }
}
