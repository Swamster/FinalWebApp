package com.swamster;


import java.sql.Time;
import java.util.ArrayList;
/**
 * 
 * @author Shreya, Aria
 * Edited to be compatible with web app
 */


public class Event {

    private String eventName;
    private Time eventTime;
    private ArrayList<Swimmer> swimmers;
    

    /**
     * Creates an Event object. The Event object holds an arraylist of Swimmer objects that correspond to that event and it holds
     * the event name so the appropriate Swimmer object are associated with it.
     * @param event --> event name
     * @param swim --> Swimmer ArrayList
     */
    public Event(String event, ArrayList<Swimmer> swim){
        eventName = event;
        swimmers=swim;
             
    }
    
    /**
     * Creates an Event object with just an event name
     * @param event --> event name
     */

    public Event(String event)
    {
        eventName = event;
        swimmers = new ArrayList<Swimmer>();
    }

    /**
     * Set the event name.
     * @param event
     */
    public void setEventName(String event) {
        eventName = event;
    }
    
    /**
     * Adds Swimmer object to Swimmer ArrayList
     * @param swim swim object to be added
     */
    public void setSwimmer(Swimmer swim) {
        swimmers.add(swim);
    }


    /**
     * Gets name of the event.
     * @return event name.
     */
    public String getEventName(){
        return eventName;
    }
    
    /**
     * Returns swimmer ArrayList
     * @return swimmer ArrayList
     */
    public ArrayList<Swimmer> getSwimmer(){
        return swimmers;
    }

   /**
    * Writes the object to a String
    * @return A string version of the object
    */
    @Override
    public String toString() {
        return ("Name: " + eventName + getSwimmer());
    }
}

