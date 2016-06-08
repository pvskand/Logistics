package com.ropar.skand.logistics;

class Utility{

	public static String getBookingDetails( String usedID ){
		// MAKE HTTP request here. and set it to response 

		String response; 

		// As of now  put the hardcoded JSON as response
		response = "";

		return response;

	}

	public static boolean checkLoginCredentials(String username, String password){
		// MAKE HTTP POST REQUEST TO THE URL AND ASSIGN IT TO RESPONSE

		String response;

		// As of now 
		response = "{ \"response\" : \"true\" }";

		// Parse it to get the Boolean

		Boolean bool = parseLoginResponse(response);
		return bool;
	}

	
	public static boolean parseLoginResponse(String response){
		// Parse JSON here

		return true;
	}

	public static void parseJsonAndPopulateListView(String response){

		// As the Name suggests. Though this function should be in Booking class i guess. Move it there. Call the getBookingDetails function from there and then call this there

	}	
}