/**
 * Created by dmaccora on 11/03/17.
 */
public class CommandFailException extends Exception {

    private int exitCode;

    public CommandFailException() {
        exitCode = -100;
    }

    public CommandFailException(int aExitCode) {
        exitCode = aExitCode;
    }

    public String getExitCodeFail() {
        if (exitCode == -100) {
            return "Failed due to other exception";
        } else {
            return "Failed with exit code " + exitCode;
        }
    }
}
