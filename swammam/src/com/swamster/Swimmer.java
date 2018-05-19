package com.swamster;


import java.util.*;

/**
 * 
 * @author Shreya, Aria
 * Edited to be compatible with web app
 */
public class Swimmer {
    private String lastName;
    private String firstName;
    private String team;
    private int age;
    private ArrayList<Race> races;
    private long id;
    private String event;

    
    /**
     * Creates a Swimmer object. The swimmer object holds the event name (which serves as an identifier for Event ID class),
     * the first and last name of the swimmer, the age of the swimmer, the swimmer's team name, and an arraylist of the 
     * race information associated with the swimmer.
     * @param eventname --> name of event
     * @param last --> swimmer's last name
     * @param first --> swimmer's first name
     * @param numYrs --> swimmer's age
     * @param teamName--> swimmer's team name
     * @param race --> swimmer's Race information
     */
    public Swimmer(String eventname, String last, String first, int numYrs, String teamName, ArrayList<Race> race)
    {
        lastName = last;
        firstName = first;
        age = numYrs;
        team = teamName;
        races = race;
        id = 0;
        event = eventname;
    }

    /**
     * Gets the last name of the swimmer.
     * @return last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Gets the first name of the swimmer.
     * @return first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Gets the age of the swimmer.
     * @return age in years
     */
    public int getAge()
    {
        return age;
    }
    
    
    /**
     * Gets the event of the race.
     * @return event name
     */
    public String getEvent()
    {
        return event;
    }


    /**
     * Gets the team of the swimmer.
     * @return team name
     */
    public String getTeam()
    {
        return team;
    }
    /**
     * Gets the list of races the swimmer is swimming in this particular meet.
     * @return races
     */
	public ArrayList<Race> getRaceList()
	{
		return races;
	}

    /**
     * Adds a race to the list of races for a swimmer.
     * @param race
     */
	public void addRace(Race race)
    {
	    races.add(race);
    }

    /**
     * Gives each swimmer a unique ID
     * @return swimmer's ID
     */
    public Long getUniqueID()
    {
        char[] ident = new char[20];
        
        ident[0]='1';
        ident[1]='0';
        if(age<=10)
        {
            ident[2]='1';
            ident[3]='0';
        }
        else if(age==11 || age==12)
        {
            ident[2]='1';
            ident[3]='1';
        }
        else if(age==13 || age==14)
        {
            ident[2]='1';
            ident[3]='3';
        }
        else if(age>=15)
        {
            ident[2]='1';
            ident[3]='5';
        }

        char[] last = lastName.toLowerCase().toCharArray();
        char[] first = firstName.toLowerCase().toCharArray();
        String tempL = "";
        String tempF = "";
        int position = 4;

	
        for(int n=0; n<4; n++)
        {
            tempL = String.valueOf(last[n]-'a'+1);
            if(tempL.length()%2 == 0)
            {
                for(int x=0; x<2; x++)
                {
                    ident[position]=tempL.charAt(x);
                    position++;
                }
            }
            else
            {
                ident[position]='0';
                ident[position++] = tempL.charAt(0);
            }
        }
        for(int n=0; n<4; n++)
        {
            tempF = String.valueOf(first[n]-'a'+1);
            if(tempF.length()%2 == 0)
            {
                for(int x=0; x<2; x++)
                {
                    ident[position]=tempF.charAt(x);
                    position++;
                }
            }
            else
            {
                ident[position]='0';
                ident[position++] = tempF.charAt(0);
            }
        }

        String finalID = new String (ident);
        

        id = Long.parseLong(finalID.trim());

        return id;
    }

    /**
     * Gets Race arraylist from Swimmer object and returns a String version 
     * @return String of Race arraylist
     */
    public String getRaces()
    {
        String list = Arrays.toString(races.toArray()).replace(",", "").replace("[", "").replace("]", "");
        return list.substring(0,list.length());
    }
   
    /**
     * Writes Swimmer object to String
     * @return Swimmer object as String
     */
    @Override
    public String toString() {
        return ( lastName + ", " + firstName + ", Age: " + age + ", Team:"+ team + getRaces());
    }
}