package com.keithmartin.app;

import java.io.IOException;
import java.util.ArrayList;

import com.keithmartin.model.Player;
import com.keithmartin.restservice.RestCalls;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws IOException 
     */
    public void testCallContainsPlayers() throws IOException
    {   	
    	ArrayList<Player> manchesterUnited = new RestCalls().getLatestSquad();	
		ArrayList<String> a = new ArrayList<String>();	
		for(Player p :manchesterUnited) {
			a.add(p.getName());
			
		}
       assertTrue( a.contains("David de Gea") );
    }
}
