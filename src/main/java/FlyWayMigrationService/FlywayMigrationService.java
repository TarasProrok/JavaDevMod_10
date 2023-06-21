package FlyWayMigrationService;

import org.flywaydb.core.Flyway;

public class FlywayMigrationService {
    public void FlywayMigration() {
        Flyway flyway = Flyway
                .configure()
                .baselineOnMigrate(true)
                .dataSource("jdbc:h2:C:./HibernateDemo/mydb/","","")
                .load();
        flyway.migrate();
    }
}
