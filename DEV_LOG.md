TASKFLOW DEVELOPER LOG:
Day 1:Project setup(springboot project) & database connection(MySQL)
•Concept Learned: How Spring Boot uses HikariCP connection pooling and application.properties to connect to a MySQL database via JDBC.
•Troubleshooting / What Happened: Successfully started Spring Boot 3 on Java 21, connected to taskflow_db on port 3306, and verified Tomcat on port 8080.
•Interview Takeaway: What is ddl-auto=update? It instructs Hibernate to automatically compare Java @Entity models with database tables and create or alter tables without deleting existing data.

Day 2: Task Entity & JPA Mapping
•Concept Learned: How JPA (@Entity, @Table, @Id, @Column) maps Java classes directly to relational SQL tables via Hibernate ORM without writing manual CREATE TABLE queries.
•Troubleshooting / What Happened: Verified automatic schema creation in MySQL (USE taskflow_db; DESCRIBE tasks;) and confirmed that column data types, constraints, and nullability match our Java fields.
•Interview Takeaway (Soundbite): Why use @Enumerated(EnumType.STRING)? By default, JPA stores enums as ordinal integers (0, 1, 2). If enum values are later reordered or added, existing database records get silently corrupted. EnumType.STRING persists the exact string name (e.g. "TODO"), ensuring human-readable data and long-term schema safety.