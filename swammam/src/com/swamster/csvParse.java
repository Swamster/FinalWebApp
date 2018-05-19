package com.swamster;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;


import javax.swing.JFileChooser;

import org.json.JSONArray;

/**
 * 
 * @author Shreya, Aria
 * Edited to be compatible with web app
 */


public class csvParse {
    public ArrayList<Event> events;
    public ArrayList<Swimmer> swimmers;
    private String source;
    private ArrayList<String> eventId;
    private Meet meet;
    private String jsonstr;

    /**
     * Creates an empty csvParse object. csvParse parses the uploaded csv file and creates a string of json code
     */
    public csvParse() {
    }
    
    /**
     * Calls all necessary functions to parse a csv file and create a json string
     * @param is InputStream (csv)
     */
    public void csvParser(InputStream is) {
        
        swimmers = new ArrayList<Swimmer>();
        eventId = new ArrayList<String>();
        readData(is);
        events = new ArrayList<Event>();
        createEvents();
        JSONArray json = new JSONArray(Arrays.asList(events));
        jsonstr = json.toString();

    }

    /**
     * Reads the data from the csv file
     * @param is InputStream (csv)
     */
    public void readData(InputStream is) {
        //Read the data from the file
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                
                String[] fields = line.split(",");
               
                ArrayList<Race> races = new ArrayList<>();
                if (fields[9].equals(""))
                    break;
                else {
                    Swimmer s = new Swimmer(fields[0],fields[10], fields[9], Integer.parseInt(fields[8]), fields[7], races);
                    swimmers.add(s);
                    s.addRace(new Race(Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), 0, null, (fields[4] + " " + fields[5])));
                    
                    EventID e = new EventID(eventId);
                    String b = fields[12];
                    
                    
                    if (!b.equals(" ")) 
                    	e.addNames(b);
                }
            }
        } catch (IOException ex) {
            
        }
    }


    /**
     * Uses the EventID class to match swimmer ArrayList to its corresponding event
     */
    public void createEvents () {
    	
    	for(int x=0; x<eventId.size(); x++) {
    		events.add(new Event(eventId.get(x)));
    	}
    	
    	for(int x=0; x<swimmers.size(); x++) {
    		for (int y=0; y<events.size(); y++) {
    			if(swimmers.get(x).getEvent().equals(events.get(y).getEventName())) {
    				events.get(y).setSwimmer(swimmers.get(x));
    			}
    		}
    	}
    	
    }
    

    
    /**
     * Converts string format created when pulling from csv to a more readable string format
     * @param s
     * @return Reformatted string
     */
    public String stuffToString(String s) {
        String string = s.replace("[", " ");
        string = string.replace("]", "");
        return string;
    }

    /**
     * Get event ArrayList
     * @return Event ArrayList
     */
    public ArrayList<Event> getEvents() {
        return events;
    }

    /**
     * Get Swimmer ArrayList
     * @return Swimmer ArrayList
     */
    public ArrayList<Swimmer> getSwimmers() {
        return swimmers;
    }
    
    /**
     * Directly load csv file and sends it to csvParser to be parsed (Used mostly in development) 
     * @param source filepath of csv file
     */
    public void load(String source)
    {
       try 
       {
          this.source = source;        

          File selected = new File(source);
          InputStream read = new FileInputStream(selected);
          csvParser(read);
               
       }
       catch (Exception ex)
       {
          this.source = null;
          ex.printStackTrace();
       }
    }      

    
    /**
     * (Used mostly in development) Opens file browser to choose csv file
     */
    public void pick()
    {
       JFileChooser chooser = new JFileChooser(".");
       if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
       {
    	  String filepath = (chooser.getSelectedFile().getAbsolutePath());
    	  filepath = filepath.replace("\\", "\\\\");
    	  
          load(chooser.getSelectedFile().getAbsolutePath());
    	   
       }
    }   
    
    /**
     * Returns Meet object
     * @return Meet object
     */
    public Meet getMeet() {
    	return meet;
    }
    
    /**
     * Gets Json String
     * @return Json String
     */
    public String getJson() {
    	return jsonstr;
    }
    
    
}
