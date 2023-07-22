# Assets Management

### Requirements
* Java version 17
* Gradle version 7.6.1
* MySql version 8


### Steps to run the application

Ensure the **MySql** server is running
```sh
sudo service mysql status
```

Create the **assets_management** database in your **MySql** locally
```sh
CREATE DATABASE assets_management;
```

Build the **Assets Management** application using **gradle**
```sh
gradle clean build
```

Now run the **Jar** file using **Java**
```sh
java -jar build/libs/assetsmanagement-0.0.1-SNAPSHOT.jar
```


### Assets APIs

Fetch Asset record by ID
```sh
curl -XGET 'http://localhost:8080/assets/{asset-id}'
```

Create a new Asset record
```sh
curl --location 'localhost:8080/assets' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    "serialNumber" : "RMX3392",
    "type" : "Android phone",
    "name" : "Realme 9 Pro+",
    "company" : "Oppo",
    "price" : 22000.0,
    "manufactureDate" : "2022-01-01",
    "warranty" : 1,
    "lifetime" : "5 years"
}'
```

Update an Asset fields by ID
```sh
curl --location --request PATCH 'localhost:8080/assets/{asset-id}' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    "company" : "Realme"
}'
```

Delete an Asset record by ID
```sh
curl -XDELETE 'http://localhost:8080/assets/{asset-id}'
```


### Asset Status APIs

Fetch an AssetStatus record by ID
```sh
curl -XGET 'http://localhost:8080/assetstatus/{asset-status-id}'
```

Create a new AssetStatus record
```sh
curl --location 'localhost:8080/assetstatus' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    "employeeId" : 1,
    "assetId" : 1,
    "issuedBy" : 2,
    "status" : "in use"
}'
```

Update an AssetStatus fields by ID
```sh
curl --location --request PATCH 'localhost:8080/assetstatus/{asset-status-id}' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    "status" : "damaged"
}'
```

Delete an AssetStatus record by ID
```sh
curl -XDELETE 'http://localhost:8080/assetstatus/{asset-status-id}'
```


### Employees APIs

Fetch an Employee record by ID
```sh
curl -XGET 'http://localhost:8080/employees/{employee-id}'
```

Create a new Employee record
```sh
curl --location 'localhost:8080/employees' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    "firstName" : "Ezio",
    "lastName" : "Auditore",
    "email" : "ezio.auditore@ac2br.com",
    "phoneNumber" : "9876543210"
    "designation" : "Software Engineer",
    "managerId" : 1,
    "team" : "Brotherhood",
    "department" : "Engineering",
    "hrId" : 2,
    "isActive" : true
}'
```

Update an Employee fields by ID
```sh
curl --location --request PATCH 'localhost:8080/employees/{employee-id}' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    "designation" : "Senior Software Engineer"
}'
```

Delete an Employee record by ID
```sh
curl -XDELETE 'http://localhost:8080/employees/{employee-id}'
```


### Users APIs

Fetch all Users records
```sh
curl -XGET 'http://localhost:8080/users'
```

Fetch a User record by ID
```sh
curl -XGET 'http://localhost:8080/users/{user-id}'
```

Create a new User record
```sh
curl --location 'localhost:8080/users' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    "name" : "Ezio",
    "email" : "ezio@ac.com",
    "password" : "ac2"
}'
```

Update a User fields by ID
```sh
curl --location --request PATCH 'localhost:8080/users/{user-id}' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    "name" : "Ezio Auditore"
}'
```

Delete a User record by ID
```sh
curl -XDELETE 'http://localhost:8080/users/{user-id}'
```
