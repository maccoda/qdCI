import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by dmaccora on 11/03/17.
 */
public class CiBuild {

    private BuildConfig buildConfig;

    /**
     * Loads up the {@link BuildConfig} at the specified path.
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

    public List<String> getBeforeBuildSteps() {
        return buildConfig.getBeforeBuild();
    }

    public List<String> getBuildSteps() {
        return buildConfig.getBuild();
    }

    public List<String> getAfterBuildSteps() {
        return buildConfig.getAfterBuild();
    }
}
