package builder.git;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dmaccora on 11/03/17.
 */
public class TestGitProject {

    @Test
    public void testProjectName() {
        GitProject proj = new GitProject("git@github.com:maccoda/qdCI.git", "master");

        assertEquals(proj.getProjectName(), "qdCI");

        proj = new GitProject("https://github.com/maccoda/qdCI.git", "master");

        assertEquals(proj.getProjectName(), "qdCI");
    }
}
