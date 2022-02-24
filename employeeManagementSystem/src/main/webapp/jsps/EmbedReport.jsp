<!-- Copyright (c) Microsoft Corporation.
Licensed under the MIT license. -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(req.requestURI))}${req.contextPath}/" />
 
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Embedded Power BI report</title>
	<base href="${base}"/>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<link href="/css/bistyle.css" rel="stylesheet"/>
</head>
<body>
	<header class="embed-container col-lg-12 col-md-12 col-sm-12 shadow">
		<div>
			Power BI Embedded Sample
		</div>
	</header>
	<main class="row">
		<section id="text-container" class="embed-container col-lg-4 col-md-4 col-sm-4 mb-5 ml-5 mt-5">
			<div>
				<div>
				    Click on any of the following Hyperlinks to view Power BI Reports:
				</div>
				<div>
					<ol>
						<li><a href="javascript: void(0);" onclick="loadReport('Work Effectiveness')">Work Effectiveness</a></li>
						<li><a href="javascript: void(0);" onclick="loadReport('Utilization')">Utilization</a></li>
						<li><a href="javascript: void(0);" onclick="loadReport('Workload')">Workload</a></li>
						<li><a href="javascript: void(0);" onclick="loadReport('Work Effectiveness_concatenated')">Work Effectiveness_concatenated</a></li>
					    <li><a href="javascript: void(0);" onclick="loadReport('Top performer')">Top performer</a></li>
					</ol>
				Click on the Below Button to refresh the page in order to view a new report as the embedding area cannot reload a new Power BI report on the fly when a report is already embedded.	
				</div>
				<br>
				<button type="button" onclick="window.location.reload();">Refresh</button>	
			</div>
		</section>
		<section id="report-container" class="embed-container col-lg-offset-4 col-lg-7 col-md-offset-5 col-md-7 col-sm-offset-5 col-sm-7 mt-5"></section>
		
		<!-- Used to display report embed error message -->
		<section class="error-container m-5"></section>
	</main>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	
	<!-- powerbi-client v2.10.3 -->
	<script src="/js/powerbi.min.js"></script>
	
	<script>
	function loadReport(reportName)
	{
		
		models = window['powerbi-client'].models;		
		reportContainer = $("#report-container").get(0);
		// Initialize iframe for embedding report
		powerbi.bootstrap(reportContainer, { type: "report" });
		// Request to get embed details
		$.ajax({
			type: "GET",
			url: "test",
			data:{reportName:reportName,powerBiEmbedToken:null,powerBiEmbedUrl:null},
			dataType: "json",
			success: function (embedData) {
				reportLoadConfig = {
					type: "report",
					tokenType: models.TokenType.Embed,
					accessToken: embedData.powerBiEmbedToken,
					
					// Use other embed report config based on the requirement. We have used the first one for demo purpose
					embedUrl: embedData.powerBiEmbedUrl,
					
					// Enable this setting to remove gray shoulders from embedded report
					settings: {
						background: models.BackgroundType.Transparent
					}
					
				};
				
				// Use the token expiry to regenerate Embed token for seamless end user experience
				// Refer https://aka.ms/RefreshEmbedToken
				tokenExpiry = embedData["tokenExpiry"]
				
				// Embed Power BI report when Access token and Embed URL are available
				report = powerbi.embed(reportContainer, reportLoadConfig);
			
				// Triggers when a report schema is successfully loaded
				report.on("loaded", function () {
					console.log("Report load successful");
				});
			 	
				// Triggers when a report is successfully embedded in UI
				report.on("rendered", function () {
					console.log("Report render successful");
				});
			
				// Clear any other error handler event
				report.off("error");

				// Below patch of code is for handling errors that occur during embedding
				report.on("error", function (event) {
					errorMsg = event.detail;
					
					// Use errorMsg variable to log error in any destination of choice
					console.error(errorMsg);
					return;
				});
			},
			error: function (err) {
				// Show error container
				$(".embed-container").hide();
				var errorContainer = $(".error-container");
				errorContainer.show();
				
				// Format error message
				var errMessageHtml = "<strong> Error Details: </strong> <br/>"
				errMessageHtml += err.responseText.split("\n").join("<br/>")
				// Show error message on UI
				errorContainer.html(errMessageHtml);
			}
		});
	
 
	 
	}
	</script>
</body>
</html>