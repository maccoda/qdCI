package builder;

/**
 * Created by dmaccora on 11/03/17.
 */
public class CommandFailException extends Exception {

    private int exitCode;
    private String command;

    public CommandFailException(String aCommand) {
        command = aCommand;
        exitCode = -100;
    }

    public CommandFailException(String aCommand, int aExitCode) {
        command = aCommand;
        exitCode = aExitCode;
    }

    public String getExitCodeFail() {
        if (exitCode == -100) {
            return "Failed due to other exception";
        } else {
            return "Failed with exit code " + exitCode;
        }
    }

    public String getFailTask() {
        return command;
    }
}
