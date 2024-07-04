package mine.project.designpatterns.observerPattern.observer;

import mine.project.designpatterns.observerPattern.observable.InventoryStockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
    String email;
    InventoryStockObservable stockObservable;

    public EmailAlertObserverImpl(String email, InventoryStockObservable observable) {
        this.email = email;
        this.stockObservable = observable;
    }
    @Override
    public void update() {
        sendMail("product is in stock, hurry up !!");
    }

    private void sendMail(String message) {
        System.out.println(message);
        System.out.println("Mail sent to "+this.email);
        System.out.println();
    }
}
