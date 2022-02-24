package com.integra.employeeManagementSystem.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.HttpClientErrorException;

import com.integra.employeeManagementSystem.config.Config;
import com.integra.employeeManagementSystem.model.EmbedConfig;
import com.integra.employeeManagementSystem.services.AzureADService;
import com.integra.employeeManagementSystem.services.PowerBIService;
import com.opensymphony.xwork2.ActionSupport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@ParentPackage("json-default")
@Action(value="test",results = {@Result(name="success",type = "json")})
public class TestAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String reportName;
	private String powerBiEmbedToken;
	private String powerBiEmbedUrl;


	static final Logger logger = LoggerFactory.getLogger(TestAction.class);
	
	public String execute() throws JsonMappingException, JsonProcessingException,IOException, InterruptedException{
		
		// Get access token
		
				String accessToken="";
				try {
					accessToken = AzureADService.getAccessToken();
				} catch (ExecutionException | MalformedURLException | RuntimeException ex) {
					// Log error message
					logger.error(ex.getMessage());
                    return ex.getMessage();
					//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());

				} catch (InterruptedException interruptedEx) {
					// Log error message
					logger.error(interruptedEx.getMessage());
					
					Thread.currentThread().interrupt();
					return interruptedEx.getMessage();
					//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(interruptedEx.getMessage());
				}

				// Get required values for embedding the report
				try {

					// Get report details
					Config.reportId = getReportId(accessToken,reportName);
					System.out.println("Report ID: "+Config.reportId);
					EmbedConfig reportEmbedConfig = PowerBIService.getEmbedConfig(accessToken, Config.workspaceId, Config.reportId);

					// Convert ArrayList of EmbedReport objects to JSON Array
					JSONArray jsonArray = new JSONArray();
					for (int i = 0; i < reportEmbedConfig.embedReports.size(); i++) {
						jsonArray.put(reportEmbedConfig.embedReports.get(i).getJSONObject());
					}

					// Return JSON response in string
					JSONObject responseObj = new JSONObject();
					responseObj.put("embedToken", reportEmbedConfig.embedToken.token);
					responseObj.put("embedReports", jsonArray);
					responseObj.put("tokenExpiry", reportEmbedConfig.embedToken.expiration);
					powerBiEmbedToken=reportEmbedConfig.embedToken.token;
                    powerBiEmbedUrl=jsonArray.getJSONObject(0).get("embedUrl").toString();
                    System.out.println("Embed Token "+powerBiEmbedToken);
                    System.out.println("Embed URL "+powerBiEmbedUrl);
					String response = responseObj.toString();
					System.out.println("Response :"+response);
					//return ResponseEntity.ok(response);

				} catch (HttpClientErrorException hcex) {
					// Build the error message
					StringBuilder errMsgStringBuilder = new StringBuilder("Error: "); 
					errMsgStringBuilder.append(hcex.getMessage());

					// Get Request Id
					HttpHeaders header = hcex.getResponseHeaders();
					List<String> requestIds = header.get("requestId");
					if (requestIds != null) {
						for (String requestId: requestIds) {
							errMsgStringBuilder.append("\nRequest Id: ");
							errMsgStringBuilder.append(requestId);
						}
					}
					
					// Error message string to be returned
					String errMsg = errMsgStringBuilder.toString();
					
					// Log error message
					logger.error(errMsg);
					return errMsg;
					//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errMsg);

				} catch (RuntimeException rex) {
					// Log error message
					logger.error(rex.getMessage());
                    return rex.getMessage();
					//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
		
		 
		 }
		return "success";		
						
	}
	
	public String getReportId(String accessToken, String reportName) throws IOException
	{
		String reportId="";
		try
		{
		String authorizationHeader = "Bearer "+accessToken;                              
        URL url = new URL("https://api.powerbi.com/v1.0/myorg/groups/"+Config.workspaceId+"/reports");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", authorizationHeader);
		con.setRequestProperty("Content-Type", "application/json");
		
		BufferedReader in = new BufferedReader(
				  new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);   
				}
				in.close();
                con.disconnect();
                JSONObject jsonObject = new JSONObject(content.toString());
                JSONArray response = (JSONArray) jsonObject.get("value");
                for(int i=0; i<response.length(); i++){
                    if(response.getJSONObject(i).getString("name").equals(reportName))
                    {
                    	reportId=response.getJSONObject(i).getString("id");
                    	System.out.println("Embed URL:"+response.getJSONObject(i).get("embedUrl"));
                    	break;
                    }
                	
                }

		}
		catch(IOException io)
		{
			logger.error(io.getMessage());	
		}
               
        return reportId;
	
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getPowerBiEmbedToken() {
		return powerBiEmbedToken;
	}

	public void setPowerBiEmbedToken(String powerBiEmbedToken) {
		this.powerBiEmbedToken = powerBiEmbedToken;
	}
	
	public String getPowerBiEmbedUrl() {
		return powerBiEmbedUrl;
	}

	public void setPowerBiEmbedUrl(String powerBiEmbedUrl) {
		this.powerBiEmbedUrl = powerBiEmbedUrl;
	}
	

	
}


