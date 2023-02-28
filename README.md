## A Clinic Management Application
#### Built using Java Spring Boot

## Functionality

### Patient 
#### Add Patient
 1. List Patients
 2. Update Patient Bio data
 3. Delete Patient Bio data

### Visit
 1. Add Patient Visits
 2. List Patient Visits
 3. Remove Patient Visits
 
 ## Getting Started
 Step 1: Clone the repository
```
$  git clone https://github.com/Humphrey-nyaga/shikusi_dispensary.git
```
Step 2: Clone the repository
```
$ cd $dirName
```

Step 3: Create a MySQL Database in your local instance
Make sure you have MySQL installed.
You can also download MySQL from here [https://dev.mysql.com/downloads/installer/]
```
$  mysql> CREATE DATABASE shikusi_dispensary;
```

Step 4: cd into the project directory
```
$  mvn clean install
```
Step 4: Run the project.
The api can be accessed from
```
$ http://localhost:8080/api/v1/
```
 
## Configuration table
  
   | Components  | Technology  | 
   | :---        |    :----:   |   
   | Backend   | Spring Boot 6.0+, Java 11+ |
   | Security |  Spring Security, https|
   | Database | MySQL|
   | API Documentation	| Swagger API + (Hub)|
   | Server Build| Maven|
   | API testing| POSTMAN|
   | Tool | Intellj Idea|
