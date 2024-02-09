# Marcosoft Example API

### This project contains different ways to achieve the same result.

These versions are divided in branches as follows:

1. The *native-database* branch implements the CRUD of the Customer table using the **native MySQL driver**.

2. The *jpa-database* branch does the same, but using **Spring Jpa**.

3. The *native-rest-client* branch implements the CRUD of the same table using the **native java.net.http Package**.

4. Finally, the *feing-rest-client* branch implements the same CRUD using **Feing Client**.

The CustomerTable.sql file contains the table definition used in this project. The database name should be "customerDatabase", as defined in the *application.properties file*.

The rest clients connect to an auxiliary api located in this link [here](https://github.com/mdstrapa/marcosoft-customer-aux-api). For this project to fully work you have to run it in the 8081 port (already configured in its application.properties file).

### Technologies used in this project:

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/-Spring-6DB33F?style=flat-square&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/-MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)