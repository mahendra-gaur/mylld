package mine.project.designpatterns.observerPattern.observable;

import java.util.ArrayList;
import java.util.List;
import mine.project.designpatterns.observerPattern.MyData;
import mine.project.designpatterns.observerPattern.observer.NotificationAlertObserver;

public class IphoneStockObservableImpl implements InventoryStockObservable{

    private List<NotificationAlertObserver> observerList;
    private List<MyData> dataList;

    public IphoneStockObservableImpl() {
        this.observerList = new ArrayList<>();
        this.dataList = new ArrayList<>();
    }

    @Override
    public void add(NotificationAlertObserver observer) {
        this.observerList.add(observer);
    }
    @Override
    public void remove(NotificationAlertObserver observer) {
        this.observerList.remove(observer);
    }
    @Override
    public void notifyToObservers() {
        this.observerList.forEach( observer -> { observer.update(); });
    }

    @Override
    public void setData(List<MyData> dataList) {
        this.dataList.addAll(dataList);
        if(this.dataList.size()>0) {
            notifyToObservers();
        }
    }

    @Override
    public List<MyData> getData() {
        return this.dataList.size()==0?null:this.dataList;
    }
}
