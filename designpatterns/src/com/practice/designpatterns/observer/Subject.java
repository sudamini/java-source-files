package com.practice.designpatterns.observer;

public interface Subject {
	
	void removeObserver( Observer o );
	void notifyObservers();
	void registerObserver( Observer o );
}
