package com.akash.googledrive;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
 
import com.google.api.services.sqladmin.SQLAdminScopes;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import   java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
public class ReadGoogleWorkSheet {
	public static class SheetsExample {
		  public static void main(String args[]) throws IOException, GeneralSecurityException {
			Date date = new Date();
		    System.out.println(new Timestamp(date.getTime()));
		    // The ID of the spreadsheet to retrieve data from.
		    String spreadsheetId = "11sra5UPTT9r_rLsK1H5ltWW9I567-HxxqcZ7lq9S-_Q"; // TODO: Update placeholder value.

		    // The A1 notation of the values to retrieve.
		    List<String> ranges = Arrays.asList("Sheet1"); // TODO: Update placeholder value.
 		    Sheets sheetsService = createSheetsService();
		    Sheets.Spreadsheets.Values.BatchGet request =
		        sheetsService.spreadsheets().values().batchGet(spreadsheetId);
		    request.setRanges(ranges);
		    
		    BatchGetValuesResponse response = request.execute();

		    // TODO: Change code below to process the `response` object:
		    System.out.println(response);
		    Date date2 = new Date();
		    System.out.println(new Timestamp(date2.getTime()));
		  }

		  public static Sheets createSheetsService() throws IOException, GeneralSecurityException {
		    HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		    JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

		    // TODO: Change placeholder below to generate authentication credentials. See
		    // https://developers.google.com/sheets/quickstart/java#step_3_set_up_the_sample
		    //
		    // Authorize using one of the following scopes:
		    //   "https://www.googleapis.com/auth/drive"
		    //   "https://www.googleapis.com/auth/drive.file"
		    //   "https://www.googleapis.com/auth/drive.readonly"
		    //   "https://www.googleapis.com/auth/spreadsheets"
		    //   "https://www.googleapis.com/auth/spreadsheets.readonly"
		    List<String> SCOPES_ARRAY = 
	                  Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY);
		    GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream("D:\\code\\workspace-sts-3.9.5.RELEASE\\ReadGoogleSheet\\lib\\akash-214908-f28ebd74389f.json"))
	        	    .createScoped(SCOPES_ARRAY);
		   
		    return new Sheets.Builder(httpTransport, jsonFactory, credential)
		        .setApplicationName("Google-SheetsSample/0.1")
		        .build();
		  }
		}
	
	
	
	 
}
