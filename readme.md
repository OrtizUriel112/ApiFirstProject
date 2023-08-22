Java Spring boot with Maven
# Requirements
- Java 11
- Spring boot 2.7.13
- MySQL 8.0.3
# Dependencies
- Spring Data JPA
- Spring Web 
- Spring Boot DevTools
- Mysql connector 
- Lombok 
# REST Methods
> /api/v2
## GET
> ~/users
```  
Get all users
``` 
> ~/users/id
```  
Get specific user
``` 
## POST
> ~/users
- email<span style="color:red">*</span>
- password<span style="color:red">*</span>
```  
Save user
``` 
## PUT
> ~/users/id
```  
Modified specific user
``` 
### PUT (Status set FALsE)
> ~/users-erase/id
```  
Change FALSE status from specific user
``` 
### PUT (Status set TRUE)
> ~/users-revive/id
```  
Change TRUE status from specific user
``` 
## DELETE
> ~/users/id
```  
Erase specific user
``` 