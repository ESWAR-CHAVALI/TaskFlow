TASKFLOW DEVELOPER LOG:
Day 1:Project setup(springboot project) & database connection(MySQL)
•Concept Learned: How Spring Boot uses HikariCP connection pooling and application.properties to connect to a MySQL database via JDBC.
•Troubleshooting / What Happened: Successfully started Spring Boot 3 on Java 21, connected to taskflow_db on port 3306, and verified Tomcat on port 8080.
•Interview Takeaway: What is ddl-auto=update? It instructs Hibernate to automatically compare Java @Entity models with database tables and create or alter tables without deleting existing data.