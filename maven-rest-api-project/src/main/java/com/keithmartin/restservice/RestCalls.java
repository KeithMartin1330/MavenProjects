package com.keithmartin.restservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.keithmartin.model.Player;

public class RestCalls {

	//	Method returns an arraylist of players from free http://api.football-data.org Restful api
	//		this team will be manchester united
	public ArrayList < Player > getLatestSquad() throws IOException {

		String url = "http://api.football-data.org/v1/teams/66/players";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// Default is get can set to post,put ect..
		con.setRequestMethod("GET");

		// request header
		con.setRequestProperty("User-Agent", "en-US,en;q=0.5");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		//Reading the response
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in .readLine()) != null) {
			response.append(inputLine);
		} in .close();
		//Formatting response
		JSONObject jsonObject = new JSONObject(response.toString());
		JSONArray playersArray = (JSONArray) jsonObject.get("players");

		//Creating arraylist of players
		ArrayList < Player > listOfPlayers = new ArrayList < Player > ();
		Player playerTemplate = null;

		for (int i = 0; i < playersArray.length(); i++) {
			String name = playersArray.getJSONObject(i).getString("name");
			String dob = playersArray.getJSONObject(i).getString("dateOfBirth");
			String position = playersArray.getJSONObject(i).getString("position");
			playerTemplate = new Player(name, dob, position);
			listOfPlayers.add(playerTemplate);
		}

		return listOfPlayers;
	}

}