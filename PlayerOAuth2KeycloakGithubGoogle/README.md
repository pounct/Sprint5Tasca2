```
PS C:\tools\kc\keycloak-23.0.1\bin> .\kc.bat start-dev

2023-12-09 22:17:39,847 INFO  [org.keycloak.quarkus.runtime.hostname.DefaultHostnameProvider] (main) Hostname settings: Base URL: <unset>, Hostname: <request>, Strict HTTPS: false, Path: <request>, Strict BackChannel: false, Admin URL: <unset>, Admin: <request>, Port: -1, Proxied: false
2023-12-09 22:17:42,914 WARN  [io.quarkus.agroal.runtime.DataSources] (main) Datasource <default> enables XA but transaction recovery is not enabled. Please enable transaction recovery by setting quarkus.transaction-manager.enable-recovery=true, otherwise data may be lost if the application is terminated abruptly
2023-12-09 22:17:44,159 WARN  [org.infinispan.PERSISTENCE] (keycloak-cache-init) ISPN000554: jboss-marshalling is deprecated and planned for removal
2023-12-09 22:17:44,312 WARN  [org.infinispan.CONFIG] (keycloak-cache-init) ISPN000569: Unable to persist Infinispan internal caches as no global state enabled
2023-12-09 22:17:44,446 INFO  [org.infinispan.CONTAINER] (keycloak-cache-init) ISPN000556: Starting user marshaller 'org.infinispan.jboss.marshalling.core.JBossUserMarshaller'
2023-12-09 22:17:44,632 INFO  [org.keycloak.broker.provider.AbstractIdentityProviderMapper] (main) Registering class org.keycloak.broker.provider.mappersync.ConfigSyncEventListener
2023-12-09 22:17:48,395 INFO  [org.keycloak.quarkus.runtime.storage.legacy.liquibase.QuarkusJpaUpdaterProvider] (main) Initializing database schema. Using changelog META-INF/jpa-changelog-master.xml

UPDATE SUMMARY
Run:                        117
Previously run:               0
Filtered out:                 0
-------------------------------
Total change sets:          117

2023-12-09 22:17:53,058 INFO  [org.keycloak.connections.infinispan.DefaultInfinispanConnectionProviderFactory] (main) Node name: node_484175, Site name: null
2023-12-09 22:17:53,289 INFO  [org.keycloak.services] (main) KC-SERVICES0050: Initializing master realm
2023-12-09 22:17:56,235 INFO  [io.quarkus] (main) Keycloak 23.0.1 on JVM (powered by Quarkus 3.2.9.Final) started in 18.580s. Listening on: http://0.0.0.0:8080
2023-12-09 22:17:56,236 INFO  [io.quarkus] (main) Profile dev activated. 
2023-12-09 22:17:56,236 INFO  [io.quarkus] (main) Installed features: [agroal, cdi, hibernate-orm, jdbc-h2, jdbc-mariadb, jdbc-mssql, jdbc-mysql, jdbc-oracle, jdbc-postgresql, keycloak, logging-gelf, micrometer, narayana-jta, reactive-routes, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, smallrye-health, vertx]
2023-12-09 22:17:56,241 WARN  [org.keycloak.quarkus.runtime.KeycloakMain] (main) Running the server in development mode. DO NOT use this configuration in production.
```
# With MariaDB SQL
```
Updating the configuration and installing your custom providers, if any. Please wait.
2023-12-10 00:03:03,255 INFO  [io.quarkus.deployment.QuarkusAugmentor] (main) Quarkus augmentation completed in 8771ms
2023-12-10 00:03:05,866 INFO  [org.keycloak.quarkus.runtime.hostname.DefaultHostnameProvider] (main) Hostname settings: Base URL: <unset>, Hostname: <request>, Strict HTTPS: false, Path: <request>, Strict BackChannel: false, Admin URL: <unset>, Admin: <request>, Port: -1, Proxied: false
2023-12-10 00:03:08,435 WARN  [io.quarkus.agroal.runtime.DataSources] (main) Datasource <default> enables XA but transaction recovery is not enabled. Please enable transaction recovery by setting quarkus.transaction-manager.enable-recovery=true, otherwise data may be lost if the application is terminated abruptly
2023-12-10 00:03:09,746 WARN  [org.infinispan.PERSISTENCE] (keycloak-cache-init) ISPN000554: jboss-marshalling is deprecated and planned for removal
2023-12-10 00:03:09,874 WARN  [org.infinispan.CONFIG] (keycloak-cache-init) ISPN000569: Unable to persist Infinispan internal caches as no global state enabled
2023-12-10 00:03:10,006 INFO  [org.infinispan.CONTAINER] (keycloak-cache-init) ISPN000556: Starting user marshaller 'org.infinispan.jboss.marshalling.core.JBossUserMarshaller'
2023-12-10 00:03:10,109 WARN  [org.mariadb.jdbc.message.server.ErrorPacket] (main) Error: 1146-42S02: Table 'keycloak.migration_model' doesn't exist
2023-12-10 00:03:13,417 WARN  [org.mariadb.jdbc.message.server.ErrorPacket] (main) Error: 1146-42S02: Table 'keycloak.databasechangelog' doesn't exist
2023-12-10 00:03:13,717 WARN  [liquibase.changelog.DatabaseChangeLog] (main) Due to mariadb SQL limitations, modifyDataType will lose primary key/autoincrement/not null/comment settings explicitly redefined in the change. Use <sql> or <modifySql> to re-specify all configuration if this is the case
2023-12-10 00:03:13,718 WARN  [liquibase.changelog.DatabaseChangeLog] (main) Due to mariadb SQL limitations, setNullable will lose primary key/autoincrement/not null/comment settings explicitly redefined in the change. Use <sql> or <modifySql> to re-specify all configuration if this is the case
2023-12-10 00:03:13,854 WARN  [org.mariadb.jdbc.message.server.ErrorPacket] (main) Error: 1146-42S02: Table 'keycloak.databasechangelog' doesn't exist
2023-12-10 00:03:13,855 INFO  [org.keycloak.quarkus.runtime.storage.legacy.liquibase.QuarkusJpaUpdaterProvider] (main) Initializing database schema. Using changelog META-INF/jpa-changelog-master.xml
2023-12-10 00:03:15,799 WARN  [liquibase.changelog.DatabaseChangeLog] (main) Due to mariadb SQL limitations, modifyDataType will lose primary key/autoincrement/not null/comment settings explicitly redefined in the change. Use <sql> or <modifySql> to re-specify all configuration if this is the case
2023-12-10 00:03:15,799 WARN  [liquibase.changelog.DatabaseChangeLog] (main) Due to mariadb SQL limitations, setNullable will lose primary key/autoincrement/not null/comment settings explicitly redefined in the change. Use <sql> or <modifySql> to re-specify all configuration if this is the case
2023-12-10 00:03:15,948 WARN  [liquibase.changelog.DatabaseChangeLog] (main) Due to mariadb SQL limitations, modifyDataType will lose primary key/autoincrement/not null/comment settings explicitly redefined in the change. Use <sql> or <modifySql> to re-specify all configuration if this is the case
2023-12-10 00:03:15,949 WARN  [liquibase.changelog.DatabaseChangeLog] (main) Due to mariadb SQL limitations, setNullable will lose primary key/autoincrement/not null/comment settings explicitly redefined in the change. Use <sql> or <modifySql> to re-specify all configuration if this is the case

UPDATE SUMMARY
Run:                        117
Previously run:               0
Filtered out:                 0
-------------------------------
Total change sets:          117

2023-12-10 00:03:37,145 INFO  [org.keycloak.connections.infinispan.DefaultInfinispanConnectionProviderFactory] (main) Node name: node_212326, Site name: null
2023-12-10 00:03:37,336 INFO  [org.keycloak.broker.provider.AbstractIdentityProviderMapper] (main) Registering class org.keycloak.broker.provider.mappersync.ConfigSyncEventListener
2023-12-10 00:03:37,355 INFO  [org.keycloak.services] (main) KC-SERVICES0050: Initializing master realm
2023-12-10 00:03:39,795 INFO  [io.quarkus] (main) Keycloak 23.0.1 on JVM (powered by Quarkus 3.2.9.Final) started in 36.123s. Listening on: http://0.0.0.0:8080
2023-12-10 00:03:39,796 INFO  [io.quarkus] (main) Profile dev activated.
2023-12-10 00:03:39,796 INFO  [io.quarkus] (main) Installed features: [agroal, cdi, hibernate-orm, jdbc-h2, jdbc-mariadb, jdbc-mssql, jdbc-mysql, jdbc-oracle, jdbc-postgresql, keycloak, logging-gelf, micrometer, narayana-jta, reactive-routes, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, smallrye-health, vertx]
2023-12-10 00:03:39,804 WARN  [org.keycloak.quarkus.runtime.KeycloakMain] (main) Running the server in development mode. DO NOT use this configuration in production.
2023-12-10 00:04:36,914 INFO  [org.keycloak.services] (executor-thread-6) KC-SERVICES0009: Added user 'fethi' to realm 'master'
2023-12-10 00:04:36,915 INFO  [org.keycloak.services] (executor-thread-6) KC-SERVICES0077: Created initial admin user with username fethi
```
# The database vendor with xampp
- create a dadtbase : keycloak
```
db=mariadb
```
# The full database JDBC URL. If not provided, a default URL is set based on the selected database vendor.
```
db-url=jdbc:mariadb://localhost:3306/keycloak?characterEncoding=UTF-8&serverTimezone=UTC
```
# The username of the database user.
```
db-username=admin
```
# The password of the database user.
```
db-password=
```


