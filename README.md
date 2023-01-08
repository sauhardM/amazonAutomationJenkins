#Amazon Automation Testing Assignment

<hr>

##Requirements :-

- JDK needs to be installed in your local machine and path needs to be set in your local machine.

- Refer to this link on how to set path for the JDK : https://www.javatpoint.com/how-to-set-path-in-java

- Install and IDE, I recommend using Eclipse.

- Also make sure to install maven for java as it will be an essential part of the project.

<hr>

##TestNG installion in eclipse :-

- Refer to the file "TestNG installion in Eclipse.docx" availabe in folder [AmazonAutomationAssignment//Resources].

<hr>

##Steps to intall the project :-

- Unzip or extract the .zip File.

- Copy and paste whole project file with name "AmazonAutomationAssignment" in your eclipse-workspace folder or any any folder you want to.

- Make sure to install the webdrivers of the same version for chrome, firefox and edge you are currently working with.

- Make sure to download to the webdrivers inside the [AmazonAutomationAssignment//Resources] folder as it will be a part of the project.

- Now go to the config.properties file inside the project [AmazonAutomationAssignment//Resources//config.propeties]

- Now change the path of the "driverpath", "ffdriverpath" and "edgedriverpath" with the actual path of the drivers you have downloaded inside the file [AmazonAutomationAssignment//Resources].


<hr>

##Running the test cases :-

- Test cases will run in two modes GUI and Headless.

- For the ruuning the test cases in GUI mode make sure to comment out the headless mode code i.e; from line [68-82] inside the folder [AmazonAutomationAssignment//src//test//java//AmazonPages//BasePage.java]

- For the ruuning the test cases in Headless mode make sure to comment out the GUI mode code i.e; from line [87-96] inside the folder [AmazonAutomationAssignment//src//test//java//AmazonPages//BasePage.java]

- Now go to testNG.xml file and open it, i have provided the path for the each test cases in comments.

- To run a test case copythe name path of the test case inside "name" attribute of the "class" tag.

- For exmaple <class name="LogoutTestCases.LogOutTest"/>.

- Enter the path of the test case you wish run that i have already provided inside the commensts.

- Now right click inside the testNG.xml file and go to "Run As" option and select TestNg Suite.

- P.S :- Also change the path of the driverpath inside the "value" attribute of the "parameter" tag  with the chrome driver path you have installed, if you wish to call the path with parameter.


<hr>

##ScreenShots :-

- ScreenShots of the failed test cases will be available inside the folder [AmazonAutomationAssignment//ScreenShots]

<hr>

##Reports :-

- Reports of the test cases will be updated after every execution of that particular testcase.

- Reports of the test cases will be availabe inside the folder [AmazonAutomationAssignment//Reports//Extent_demo.html]

- Double click the Extent_demo.html file to open the report in your default browser.