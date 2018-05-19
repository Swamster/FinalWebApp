package com.swamster;


import java.sql.Time;

/**
 * 
 * @author Shreya, Aria
 * Edited to be compatible with web app
 */
public class Race
{
   
    private int heat;
    private int lane;
    private double time;
//    private Time startTime;
    private String swimmer;

    /**
     * Creates a Race object. The Race object holds a swimmer's heat number, lane number, swimming time, and the swimmer's name.
     * @param heatNum --> heat number
     * @param laneNum --> lane number
     * @param timeSwam --> swimming time
     * @param timeStart --> (currently a place holder for the live event times to be implemented in the future)
     * @param swim --> swimmer's name
     */
    public Race( int heatNum, int laneNum, double timeSwam, Time timeStart, String swim)
    {
        heat = heatNum;
        lane = laneNum;
        time = timeSwam;
//        startTime = timeStart;
        swimmer = swim;
    }


    /**
     * Gets the heat number of the race.
     * @return heat number
     */
    public int getHeat()
    {
        return heat;
    }

    /**
     * Gets the lane number of the race.
     * @return lane number
     */
    public int getLane()
    {
        return lane;
    }

    /**
     * Gets swimmer of race.
     * @return swimmer
     */
    public String getSwimmer() { return swimmer;}

    /**
     * Gets the time it took to swim the race.
     * @return time
     */
    public double getSwimTime()
    {
        return time;
    }
    
    
    /**
     * Sets the starting time of the race (to be implemented later)
     * @param hours
     * @param minutes
     * @return the starting time of the race
     */
//    public Time setStartTime(int hours, int minutes)
//    {
//        startTime.setHours(hours);
//        startTime.setMinutes(minutes);
//        return startTime;
//    }


    /**
     * Gets the starting time of the race (to be implemented later)
     * @return
     */
//    public Time getStartTime()
//    {
//        return startTime;
//    }

    /**
     * Changes the final swim time.
     * @param timeSwam the time it took to swim the race
     * @return time
     */
    public double changeSwimTime(double timeSwam)
    {
        time = timeSwam;
        return time;
    }

   /**
    * Writes the Race object as a string
    * @return A string of the object
    */
    @Override
    public String toString() {
    	return ("heat: " + heat + ", lane: " + lane + ", time: " + time);
    }
}
