import builder.BuildExecutor;
import builder.CommandFailException;

/**
 * Created by dmaccora on 11/03/17.
 */
public class Driver {

    public static void main(String[] args) {
        System.out.println("Hello World");
        // Time to load the YAML
        BuildExecutor builder = new BuildExecutor("src/test/resources/test_config.yml");
        try {
            builder.executeBeforeBuild();
            builder.executeBuild();
            builder.executeAfterBuild();
        } catch (CommandFailException e) {
            System.err.println("Command failed with exit code " + e.getExitCodeFail() + " for " + e.getFailTask());
        }

    }

}
