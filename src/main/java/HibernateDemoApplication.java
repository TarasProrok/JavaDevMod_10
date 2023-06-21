import services.ClientCrudService;
import services.FlywayMigrationService;
import services.PlanetCrudService;

public class HibernateDemoApplication {
    public static void main(String[] args) {
        new FlywayMigrationService().flywayMigration();

        System.out.println("Clients name for id 5 is - " + new ClientCrudService().getById(5));
        new ClientCrudService().updateById(5, "Viktor");
        System.out.println("Clients name for id 5 is - " + new ClientCrudService().getById(5));

        System.out.println("Planet with EH03 is - " + new PlanetCrudService().getPlanetById("EH03"));
        new PlanetCrudService().updatePlanetById("EH03", "Neptune");
        System.out.println("Planet with EH03 is - " + new PlanetCrudService().getPlanetById("EH03"));
    }
}