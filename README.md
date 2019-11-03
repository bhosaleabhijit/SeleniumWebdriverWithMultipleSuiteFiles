# SeleniumWebdriverWithMultipleSuiteFiles

This is test project to see how static webdriver works for multiple suite files added in the POM.xml file. This works pretty well. And we can see the driver gets created before starting first suite(@BeforeTest) file and gets closed after first suite(@AfterTest) gets finished. Another driver gets created and destroyed in the same way for second suite file.
