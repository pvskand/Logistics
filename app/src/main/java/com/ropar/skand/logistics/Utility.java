package com.ropar.skand.logistics;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class Utility{

	public static String getBookingDetails( String usedID ){
		// MAKE HTTP request here. and set it to response

		//HttpURLConnection connection = null;
		//BufferedReader reader = null;

		 /* URL url = new URL("url goes here");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                String str=buffer.tostring();// json returned here

                */

		String response; 

		// As of now  put the hardcoded JSON as response

		response = "{\"BookingHistory\" : [{\"BookingID\":\"3128\",\"TrcukID\":\"87346\",\"DateofBooking\":\"15-6-19\",\"CompanyId\":\"42686832\",\"Source\":\"delhi\",\"Destination\":\"noida\",\"Truck-Type\":\"bdhadh\",\"Dateofcompletion\":\"67-85-95\"} ]}";

		return response;

	}

	public static boolean checkLoginCredentials(String username, String password) throws JSONException {
		// MAKE HTTP POST REQUEST TO THE URL AND ASSIGN IT TO RESPONSE

		//HttpURLConnection connection = null;
		//BufferedReader reader = null;

		 /* URL url = new URL("url goes here");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                String str=buffer.tostring();// json returned here

                */



		String response;

		// As of now
		response = "{\"Credentials\" : [{\"username\":\"pvskand@gmail.com\",\"password\":\"iitropar\"}]}";

		// Parse it to get the Boolean

		/*JSONArray bool = parseLoginResponseVerification(response);

		/*  the record for authentication of username  and password */
			/*	for(int i=0;i<bool.length();i++)

		{
			JSONObject cre=bool.getJSONObject(i);
			if(username.equals(cre.getString("username")) && password.equals(cre.getString("password"))
			{
				return true;
			}
		}


		return false;*/
        /*as of for now*/
		return true;
	}

   /* parser for credentials*/
	public static JSONArray parseLoginResponseVerification(String response) throws JSONException {
		// Parse JSON here

		JSONObject parent=new JSONObject(response);
		JSONArray parentarray=new JSONArray("Credentials");


		return parentarray;


	}
	/* separate parser for Booking Details*/
	public static JSONArray parseLoginResponse(String response) throws JSONException {
		// Parse JSON here

		JSONObject parent=new JSONObject(response);
		JSONArray parentarray=new JSONArray("BookingHistory");


		return parentarray;
	}

	public static void parseJsonAndPopulateListView(String response){

		// As the Name suggests. Though this function should be in Booking class i guess. Move it there. Call the getBookingDetails function from there and then call this there

	}	
}
