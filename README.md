## A Clinic Management Backend API

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
git clone https://github.com/Humphrey-nyaga/shikusi_dispensary.git
```
Step 2: Clone the repository
```
cd $dirName
```

Step 3: Create a MySQL Database in your local instance
Make sure you have MySQL installed.
You can also download MySQL from here [https://dev.mysql.com/downloads/installer/]
```
mysql> CREATE DATABASE shikusi_dispensary;
```

Step 4: cd into the project directory
```
mvn clean install
```
Step 4: Run the project.
The api can be accessed from
```
http://localhost:8080/
```
## Usage Example
Endpoints

| Method   | URL                           | Description                                                |
| -------- |-------------------------------|------------------------------------------------------------|
| `GET`    | `/api/v1/patient/`            | Retrieve all patients.                                     |
| `POST`   | `/api/v1/patient/`            | Create new patient.                                        |
| `GET`    | `/api/v1/patient/{id}`        | Retrieve given patient with given id.                      |
| `DELETE`  | `/api/v1/patient/delete/{id}` | Delete records of patient with id.                         |
| `GET`    | `/api/v1/visit/patient/{id}`  | Retrieve all visit records of a given patient of given id. |
| `GET`    | `/api/v1/visit/{id}`          | Retrieve visit details.                                    |
| `POST`   | `/api/v1/visit/patient/{id}`  | Add a new patient visit of patient with given Id           |
| `DELETE` | `/api/v1/visit/delete/{id}`   | Delete visit.                                              |


## Project Configuration 

   | Components        | Technology        | 
   |-------------------|-------------------|
   | Backend           | Spring Boot 6.0+, Java 11+/ Java 17 | 
   | Database          | MySQL             |  
   | API Documentation | Swagger API + (Hub) |
   | Server Build      | Maven             |
   | API testing       | POSTMAN           |
   | Tool              | Intellj Idea      |
   
