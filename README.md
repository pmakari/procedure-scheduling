# Procedure scheduling Web App
Study scheduling application in which procedures for treatment of patients performed by doctors are planned.
## Installation
Clone the project and run this command

`mvn spring-boot:run`

For packaging and testing the project run the following command

`mvn clean package` 

For running the project after packaging use the following command

` java -jar target/procedure-scheduling.jar 
` 
## Technology stack
**Java 8**

**Maven**

**SpringBoot 1.4.7**

**Flyway**

**Project Lombok**

## Prerequisites
**Maven**

**JDK 8**


## Description
 Flyway added for database migration and versioning.
 
 Used HSQL as embedded database.
 
 There are three profiles for application (**prod**,**dev**,**test**), the default 
 profile is **dev**. To change the profile use the command line arguments :
 
` java -jar target/procedure-scheduling.jar -Dspring.profiles.active=prod
`

