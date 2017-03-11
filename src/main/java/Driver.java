/**
 * Created by dmaccora on 11/03/17.
 */
public class Driver {

    public static void main(String[] args) {
        System.out.println("Hello World");
        // Time to load the YAML
        CiBuild builder = new CiBuild("src/test/resources/test_config.yml");

    }

}
