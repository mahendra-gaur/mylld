package mine.project.designpatterns.observerPattern.observable;

import java.util.List;
import mine.project.designpatterns.observerPattern.MyData;
import mine.project.designpatterns.observerPattern.observer.NotificationAlertObserver;

public interface InventoryStockObservable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifyToObservers();

    public void setData(List<MyData> dataList);
    public List<MyData> getData();
}
