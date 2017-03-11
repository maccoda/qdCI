package builder;

import builder.command.CommandExecutor;
import builder.git.GitProject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by dmaccora on 11/03/17.
 * <p>
 * Handler of the workspace. This is the entry point for each build, need one per build. Will be in charge of the steps
 * for the following:
 * <ul>
 * <li>Clone in the repository</li>
 * <li>Perform the build</li>
 * <li>Return the success or failure of build</li>
 * </ul>
 */
public class CiWorkspace {
    private GitProject project;

    public CiWorkspace(GitProject project) {
        this.project = project;
    }

    /**
     * Performs all of the mentioned tasks above
     */
    public void startBuild() {
        // TODO Major problem is we need something that creates the workspace and something that runs the tests in
        // the workspace as two separate beings. Only want one creator but multiple runner.
        try {
            String dirName = workspaceName(project);
            Files.createDirectories(Paths.get(dirName));
            // git clone <url> <workspace-name>
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String workspaceName(GitProject project) {
        return "workspace_" + project.getProjectName() + "/" + project.getBranch();
    }
}
