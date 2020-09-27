## CoderZone

## Technology Stack
 Spring Boot  
 BootStrap     
## Reference
[Spring](https://spring.io/guides)    
[Spring Web](https://spring.io/guides/gs/serving-web-content/)   
[es](https://elasticsearch.cn/explore)    
[Github deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)    
[Bootstrap](https://v3.bootcss.com/getting-started/)    
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)    
[Spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)    
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)    
[Spring Dev Tool](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#using-boot-devtools)  
[Spring MVC](https://docs.spring.io/spring/docs/5.0.3.RELEASE/spring-framework-reference/web.html#mvc-handlermapping-interceptor)  

## Tool
[Git](https://git-scm.com/download)   
[Visual Paradigm](https://www.visual-paradigm.com)    
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)  
[Lombok](https://www.projectlombok.org)    
[ctotree](https://www.octotree.io/)   
[Table of content sidebar](https://chrome.google.com/webstore/detail/table-of-contents-sidebar/ohohkfheangmbedkgechjkmbepeikkej)    
[One Tab](https://chrome.google.com/webstore/detail/chphlpgkkbolifaimnlloiipkdnihall)    
[Live Reload](https://chrome.google.com/webstore/detail/livereload/jnihajbhpnppcggbcgedagnkighmdlei/related)    

 
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

'''bash/zsh  
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
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
Integrated Mybatis generator to handle mapper and models

## Work Flow
### 1. GitHub User LogIN




