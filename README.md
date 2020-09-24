## CoderZone

## Technology Stack
 Spring Boot  
 BootStrap     
## Reference
 [Spring](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/index.html)          
 [Spring Web](https://spring.io/guides/gs/serving-web-content/)  
 [Elastic community](https://elasticsearch.cn/explore)  
 [Bootstrap](https://docs.github.com/en/developers/overview/managing-deploy-keys#deploy-keys)  
 [Github OAuth](https://docs.github.com/en/developers/apps/building-oauth-apps)  
 [Spring Framework](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/index.html)  
 [MyBatis](https://mybatis.org/spring/getting-started.html)  
 [Flyway](https://flywaydb.org/getstarted/firststeps/maven)

## Tool
 [Git](https://git-scm.com/downloads)  
 [Visual Paradigm](https://www.visual-paradigm.com/)
 [Flyway](https://flywaydb.org/getstarted/firststeps/maven)
 [Lombok](https://projectlombok.org/setup/maven)

 
## Script  
'''sql
create table USER
(
	ID INT auto_increment,
	ACCOUNT_ID VARCHAR(100),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
	NAME VARCHAR(50),
	TOKEN CHAR(36),
	constraint USER_PK
		primary key (ID)
);


'''
 
## Function Implemented
### 1. Log in via GitHub
##### 1.1 Visit GitHub authorize API with app info
##### 1.2 Re-direct back to url with code
##### 1.3 Visit GitHub access_token API via code and return access_token
##### 1.4 Visit GitHub user API via access_token to get user info
##### 1.5 Store user info to cookie to maintain loged-in status

### 2. Database connection and management
##### 2.1 Initialize and connect to H2 database
##### 2.2 Incorporate MyBatis for inserting data
##### 2.3 Use Flayway for database migration and update
##### 2.4 Store question info published by user

### 3. Publish question
##### 3.1 Submit to publish question, store question in question database
##### 3.2 Display questions in home page and implement pagination
##### 3.3 Display questions published by a user in their profile page

### 4. 



