package com.swamster;
import java.util.ArrayList;

/**
 * 
 * @author Aria
 *
 */

public class EventID {

	private ArrayList<String> eventNames = new ArrayList<String>();
	
	/**
	 * Creates an EventID object. This object holds the names of the events of the meet. It is used to organize the Swimmer
	 * objects into the correct Event objects.
	 * @param eventNames--> ArrayList of event names
	 */
	public EventID (ArrayList<String> eventNames) {
		this.eventNames=eventNames;
	}
	
	/**
	 * Writes the object to a String
	 * @return object as a String
	 */
	@Override
	public String toString() {
		String output="";
		for(int x=0; x< eventNames.size(); x++) {
			output+= eventNames.get(x);
		}
		return output;
	}

   /**
    * Adds names to the eventNames ArrayList
    * @param eventName name to add to the list
    */
    public void addNames(String eventName) {
        eventNames.add(eventName);
    }
    
    /**
     * Gets the arraylist of event names
     * @return event name ArrayList
     */
    public ArrayList<String> getNames() {
        return eventNames;
    }
	
}

