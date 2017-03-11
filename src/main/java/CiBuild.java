import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dmaccora on 11/03/17.
 */
public class CiBuild {

    private BuildConfig buildConfig;

    /**
     * Loads up the {@link BuildConfig} at the specified path.
     *
     * @param path - path of config
     */
    public CiBuild(String path) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            String yamlContent = new String(encoded, Charset.defaultCharset());
            Yaml yaml = new Yaml(new Constructor(BuildConfig.class));
            buildConfig = (BuildConfig) yaml.load(yamlContent);

        } catch (IOException e) {
            System.err.println("Unable to find file " + path);
            e.printStackTrace();
        }
    }

    public void executeBeforeBuild() throws CommandFailException {
        executeTasks(buildConfig.getBeforeBuild());
    }

    public void executeBuild() throws CommandFailException {
        executeTasks(buildConfig.getBuild());
    }

    public void executeAfterBuild() throws CommandFailException {
        executeTasks(buildConfig.getAfterBuild());
    }

    private void executeTasks(List<String> tasks) throws CommandFailException {
        List<CommandExecutor> cmds = buildCommands(tasks);
        for (CommandExecutor cmd:cmds) {
            try {
                int exitCode = cmd.execute();
                if (exitCode != 0) {
                    throw new CommandFailException(exitCode);
                }
            } catch (IOException|InterruptedException e) {
                throw new CommandFailException();
            }
        }
    }

    private List<CommandExecutor> buildCommands(List<String> commands) {
        return commands.stream().map(x -> new CommandExecutor(Arrays.asList(x.split(" ")))).collect(Collectors.toList());
    }

    List<String> getBeforeBuildSteps() {
        return buildConfig.getBeforeBuild();
    }

    List<String> getBuildSteps() {
        return buildConfig.getBuild();
    }

    List<String> getAfterBuildSteps() {
        return buildConfig.getAfterBuild();
    }
}
