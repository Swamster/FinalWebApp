package com.swamster;
import java.util.ArrayList;

/**
 * 
 * @author Aria
 *
 */

public class Meet {

	private ArrayList<Event> event;
	
	/**
	 * Creates a Meet object. The Meet object holds the meet's events and holds them all in one object.
	 * @param events --> ArrayList of meet events
	 */
	public Meet (ArrayList<Event> events) {
		event= events;
	}
	
	/**
	 * Adds event to event ArrayList
	 * @param eventadd event to be added to event arraylist
	 */
	public void addEvent(Event eventadd) {
		event.add(eventadd);
	}
	
	/**
	 * Gets event arraylist
	 * @return event arraylist
	 */
	public ArrayList<Event> getEvents() {
		return event;
	}
	
	
}
