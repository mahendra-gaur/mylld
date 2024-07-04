package mine.project.designpatterns.observerPattern;

import java.util.List;
import mine.project.designpatterns.observerPattern.observable.InventoryStockObservable;
import mine.project.designpatterns.observerPattern.observable.IphoneStockObservableImpl;
import mine.project.designpatterns.observerPattern.observer.EmailAlertObserverImpl;
import mine.project.designpatterns.observerPattern.observer.MobileAlertObserverImpl;
import mine.project.designpatterns.observerPattern.observer.NotificationAlertObserver;

public class Main {

    public static void main(String[] args) {
        InventoryStockObservable iphoneStockObservable = new IphoneStockObservableImpl();

        NotificationAlertObserver emailAlertObserver_1 = new EmailAlertObserverImpl("abc@abc.com", iphoneStockObservable);
        NotificationAlertObserver emailAlertObserver_2 = new EmailAlertObserverImpl("xyz@xyz.com", iphoneStockObservable);
        NotificationAlertObserver mobileAlertObserver_1 = new MobileAlertObserverImpl("user_1", iphoneStockObservable);
        NotificationAlertObserver mobileAlertObserver_2 = new MobileAlertObserverImpl("user_2", iphoneStockObservable);

        iphoneStockObservable.add(emailAlertObserver_1);
        iphoneStockObservable.add(emailAlertObserver_2);
        iphoneStockObservable.add(mobileAlertObserver_1);
        iphoneStockObservable.add(mobileAlertObserver_2);

        iphoneStockObservable.setData(List.of(new MyData(), new MyData()));
    }

}
