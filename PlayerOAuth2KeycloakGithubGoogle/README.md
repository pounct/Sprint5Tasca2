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



