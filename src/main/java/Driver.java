import builder.BuildExecutor;
import builder.CiWorkspace;
import builder.command.CommandFailException;
import builder.git.GitProject;

/**
 * Created by dmaccora on 11/03/17.
 */
public class Driver {

    public static void main(String[] args) {
        System.out.println("Hello World");
        GitProject proj = new GitProject("git@github.com:maccoda/qdCI.git", "master");
        CiWorkspace workspace = new CiWorkspace(proj);
        workspace.startBuild();
        // Time to load the YAML

        BuildExecutor builder = new BuildExecutor(System.getProperty("user.dir") + "/src/test/resources/test_config.yml");
        try {
            builder.executeBeforeBuild();
            builder.executeBuild();
            builder.executeAfterBuild();
        } catch (CommandFailException e) {
            System.err.println("Command failed with exit code " + e.getExitCodeFail() + " for " + e.getFailTask());
        }

    }

}
