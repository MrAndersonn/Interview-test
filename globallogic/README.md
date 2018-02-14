# GlobalLogic Test

The project is compiled into ".jar", located in the **target** folder.
Storing binaries in "git" is a bad practice, it was done for convenience

### Running tutorial
For running my app you can use simple command:
```
-java -jar target/test-1.0-SNAPSHOT.jar
```
Data for app simulate in **main** method. My app use only Java SE lib.
But if you have some trouble you also can use:
```
mvn clean install
-java -jar target/test-1.0-SNAPSHOT.jar  
```
### Commands for app
```
--help // list of command
--calc tc // calculete total capacity for all AirCompany in the Airline
--calc cc // calculete carrying capacity for all AirCompany in the Airline
--lsfr  // list AirCraft of company sorted by flight range(need select company)
--sfc // search AirCraft by fuel consumption
```

###### Description Command
App contain 2 embedded command:
```
--lsfr // in this command need select a companny 
--sfc // need specify fuel range in format 'min-max'(example 10-150)
```

### Design app
I use DAO template for work with storage. I choose simple "in_memory_storage".
But app is simple to modify, need implement new storageDAOImpl.

Package:
* DAO contain:
    * DAOInterface package for store dao abstract
    * DAOImpl for custom implementation of DAO
    * DAOInit.java its for access to current app DAO

In **Main.class** I simulate a random data for my app, and store it.
For work with cmd i use Command pattern. Command stored in **cmd.command** folder.
I use **CommandListener.java** for control input command from cmd and output result.
Also i have design service hierarchy for work with different Transport type and different Company type

Package:
* service contain:
    * action package for stored abstract actions 
    * actionImpl package for stored custom implementation of action
    * serviceInit.java for static access to all services in the app
    

