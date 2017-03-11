package builder;

import builder.BuildExecutor;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by dmaccora on 11/03/17.
 */
public class TestBuildExecutor {

    @Test
    public void testConstructor() {
        BuildExecutor builder = new BuildExecutor(System.getProperty("user.dir") + "/src/test/resources/test_config.yml");
        assertEquals(builder.getBeforeBuildSteps(), Arrays.asList("ls"));
        assertEquals(builder.getBuildSteps(), Arrays.asList("touch test.txt", "cat test.txt"));
        assertEquals(builder.getAfterBuildSteps(), Arrays.asList("cat test.txt", "rm test.txt"));
    }
}
