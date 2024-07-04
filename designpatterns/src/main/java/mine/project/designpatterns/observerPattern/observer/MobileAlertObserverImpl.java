package mine.project.designpatterns.observerPattern.observer;

import mine.project.designpatterns.observerPattern.observable.InventoryStockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{
    String username;
    InventoryStockObservable stockObservable;

    public MobileAlertObserverImpl(String username, InventoryStockObservable observable) {
        this.username = username;
        this.stockObservable = observable;
    }

    @Override
    public void update() {
        sendMessage("product is in stock, hurry up !!");
    }

    private void sendMessage(String message) {
        System.out.println(message);
        System.out.println("Message sent to "+this.username);
        System.out.println();
    }
}
