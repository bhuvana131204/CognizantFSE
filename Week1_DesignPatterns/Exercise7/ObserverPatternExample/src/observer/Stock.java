package observer;

public interface Stock {
	void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers();
}
