package org.darkimpulsepoint.circles.observer;

public interface Observable {
    void addObserver(CircleObserver observer);
    void removeObserver(CircleObserver observer);
    void notifyObservers();
}
