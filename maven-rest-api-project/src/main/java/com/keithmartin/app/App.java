package com.keithmartin.app;

import java.io.IOException;
import java.util.ArrayList;

import com.keithmartin.model.Player;
import com.keithmartin.restservice.RestCalls;

public class App {
	public static void main( String[] args ){
		ArrayList<Player> manchesterUnited = null;
		try {
			manchesterUnited= new RestCalls().getLatestSquad();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(manchesterUnited);
	}
}
