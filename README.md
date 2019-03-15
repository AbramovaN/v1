# Software requirements
 * MySQL Server 8.0 - https://dev.mysql.com/downloads/workbench/
 * Maven - https://maven.apache.org/download.cgi
# Installation
  * Clone or download the source code from this Github page:
  * $ git clone https://github.com/AbramovaN/v1
 * Open MySQL Command Line client: enter your password, then :
###### CREATE DATABASE blog;
   Use command: 
###### SHOW DATABASES;
   to make sure that new db with name blog was created.
   ##### You can also create new schema using MySQL Workbench.
   Please, make sure that db properties as username and password same that at 
  v1\src\main\resources\application.properties
  Please, change spring.jpa.hibernate.ddl-auto=create to spring.jpa.hibernate.ddl-auto=update after first successful run.
  * $ cd v1
  * $ mvn spring-boot:run
##### You can also open downloaded project with your IDE. 
Open: http://localhost:8080/v1