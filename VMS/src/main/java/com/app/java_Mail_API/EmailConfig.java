/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package com.app.java_Mail_API;

import com.app.constant.FrameworkConstants;

/**
 * Data for Sending EMail after execution
 */
public class EmailConfig {

	public static final String SERVER = "smtp.gmail.com";
	public static final String PORT = "587";

	public static final String FROM = "vehicleservicestation72@gmail.com";
	public static final String PASSWORD = "jjjqjfmonccnlmut";

	/* "**********@gmail.com", */
	public static final String[] TO = {"vehicleservicestation72@gmail.com"};
	public static final String SUBJECT = FrameworkConstants.getProjectName();
}