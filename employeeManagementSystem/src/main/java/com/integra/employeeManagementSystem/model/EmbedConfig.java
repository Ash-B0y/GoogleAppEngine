// ----------------------------------------------------------------------------
// Copyright (c) Microsoft Corporation.
// Licensed under the MIT license.
// ----------------------------------------------------------------------------

package com.integra.employeeManagementSystem.model;

import java.util.List;

/**
 * Properties for embedding the report 
 */
public class EmbedConfig {
	public List<ReportConfig> embedReports;

	public EmbedToken embedToken;

	public String errorMessage;
}
