# Spring Orm
- Spring ORM is a module used to integrate data access code with spring (Object Relational Mapping)
- Allows us to combine hibernate and Spring along with all the JPA benefits
- Easier to test because of loose coupling
- No longer need a `hibernate.cf.xml` file because all configuration details are in `applicationContext.xml`

## We Must Define 3 Spring Beans
1. `DataSource`
  - Where we configure db credentials along with driver class name
2. `SessionFactory`
  - Where we configure hibernate specific properties such as `hibernate.hbm2ddl.auto`
 3. `TransactionManager`
 
 - Our `DataSource` is injected into our `SessionFactory`
 - Our `SessionFactory` is injected into our `TransactionManager`
 - Our `SessionFactory` is also injected into our `DAO`s (more specifically, we used a repository specific to `Hero` data)
 
 ### Transaction Propagation 
 The Transaction Propagation mechanism allows you to control transaciton behavior thorughout the app.
 
 REQUIRED (default) 
 - The same tx will be used if one already exists
 - If not, a new tx will be opened
 `REQUIRES_NEW`
 - 
 `NESTED`
 -
 `MANDATORY`
 -
 `NEVER`
 -
 `SUPPORTS`
 -
 `NOT-SUPPORTED`
 -
 
 
 
