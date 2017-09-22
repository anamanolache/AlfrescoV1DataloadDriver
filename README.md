### Alfresco Benchmark V1 Rest API Driver

This project is an Alfresco Benchmark Driver that tests the V1 Rest API endpoints 

### Get the code

Git:

    git clone https://github.com/anamanolache/AlfrescoV1DataloadDriver.git

### Setup

1. Setup a local mongo server
	
	Install the mongo server
		mongo version: 3.2. It will not work with newer versions! (For mac users can be found here to download)
		https://docs.mongodb.com/manual/installation/
	
	Start mongo:
		windows:   <MongoDBInstalationPath>/Server/3.2/bin/mongod.exe --dbpath <mongodb-storage-path> --storageEngine=mmapv1
		mac os:      <MongoDBInstalationPath>/bin/mongod
		
	Install a client for mongoDB : ex https://robomongo.org/
	
	Check availability of MongoDB server

		mongo \<mongo-host\>    
		exit

2. Build and start the benchmark server

	checkout https://github.com/AlfrescoBenchmark/alfresco-benchmark and build it with "mvn clean install"
	start it with "mvn tomcat7:run -Dmongo.config.host=localhost"

3. Build driver

    mvn clean install
	
4. Start driver
	
	mvn tomcat7:run -Dmongo.config.host=localhost

5.Access server UI

    Browse to http://localhost:9080/alfresco-benchmark-server

6.Create a Test

    Click [+] if not presented with "Create Test" options.  
    Fill in test details:   
        - Test Name: MyFirstTest01  
        - Test Description: Getting started 
        - Test Definition: alfresco-benchmark-v1-dataload-xxx
    Click "Ok".
 
7.Edit test properties

    It is a requirement that all test runs get told where to store the generated results.   
    Change property "mongo.test.host" to your \<mongo-host\>  
    Click: "MyFirstTest01" on top left

8.Create a Test Run

    Click [+] if not presented with "Create Test Run" options.  
    Fill in test run details:   
        - Test run name: 01     
    Click "Ok".

9.Start the Test Run

    Click "Play" button next to Test Run "01".  
    The progress bar will auto-refresh as the test run completion estimate changes.

10.Download results

    At any time - usually when the test run completes - click through on the test run.  
    Click the download button and open the CSV file in a spreadsheet.
