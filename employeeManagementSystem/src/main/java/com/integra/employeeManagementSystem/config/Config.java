// ----------------------------------------------------------------------------
// Copyright (c) Microsoft Corporation.
// Licensed under the MIT license.
// ----------------------------------------------------------------------------

package com.integra.employeeManagementSystem.config;

/**
 * Configuration class
 */
public abstract class Config {
	
	// Set this to true, to show debug statements in console
	public static final boolean DEBUG = false;
	
	//	Two possible Authentication methods: 
	//	- For authentication with master user credential choose MasterUser as AuthenticationType.
	//	- For authentication with app secret choose ServicePrincipal as AuthenticationType.
	//	More details here: https://aka.ms/EmbedServicePrincipal
	public static final String authenticationType = "MasterUser";
	
	//	Common configuration properties for both authentication types
	// Enter workspaceId / groupId
	public static final String workspaceId = "93ceca68-0d2f-4056-b35e-351ed5579372";

	// The id of the report to embed.
	public static String reportId = "";

	// Enter Application Id / Client Id
	public static final String clientId = "cb7ffba8-e9cf-4cac-93e8-3927a15edd90";

	// Enter MasterUser credentials
	public static final String pbiUsername = "developer@handdypowerbi.onmicrosoft.com";
	public static final String pbiPassword = "Welcome@123";

	// Enter ServicePrincipal credentials
	public static final String tenantId = "";
	public static final String appSecret = "";
		
	//	DO NOT CHANGE
	public static final String authorityUrl = "https://login.microsoftonline.com/";
	public static final String scopeUrl = "https://analysis.windows.net/powerbi/api/.default";
	
	
	private Config(){
		//Private Constructor will prevent the instantiation of this class directly
		throw new IllegalStateException("Config class");
	}
	
}