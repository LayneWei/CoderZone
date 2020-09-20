## CoderZone

## Technology Stack
 Spring Boot  
 BootStrap     
## Reference
 [Spring](https://spring.io/guides)          
 [Spring Web](https://spring.io/guides/gs/serving-web-content/)  
 [Elastic community](https://elasticsearch.cn/explore)  
 [Bootstrap](https://docs.github.com/en/developers/overview/managing-deploy-keys#deploy-keys)  
 [Github OAuth](https://docs.github.com/en/developers/apps/building-oauth-apps)  
 [Spring Framework](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/index.html)  
 [MyBatis](https://mybatis.org/spring/getting-started.html)

## Tool
 [Git](https://git-scm.com/downloads)  
 [Visual Paradigm](https://www.visual-paradigm.com/)
 
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

### 2. Database connection
##### 2.1 Initialize and connect to H2 database
##### 2.2 Incorporate MyBatis for inserting data


