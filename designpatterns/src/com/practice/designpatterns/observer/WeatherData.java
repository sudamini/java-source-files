package com.practice.designpatterns.observer;
import java.util.ArrayList;

public class WeatherData implements Subject {

	protected double temperature;
	protected double humidity;
	protected double pressure;
	
	protected ArrayList<Observer> observers;
	
	protected WeatherData ( ArrayList<Observer> obs ) {
		this.observers = obs;
	}
	
	@Override
	public void registerObserver( Observer o ) {
		if ( o!= null ) {
			observers.add( o );
		}
	}

	@Override
	public void removeObserver( Observer o ) {
		if ( o == null ) {
			return;
		}
		if ( observers.contains(o) ) {
			observers.remove(o);
		}

	}

	@Override
	public void notifyObservers() {
		for ( Observer obsvr : observers) {
			obsvr.update ( getTemperature(), getHumidity(), getPressure() );
		}
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	
	public void measurementsChanged () {
		notifyObservers();
	}
	
	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}
	

}
