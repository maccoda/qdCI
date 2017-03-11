package builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dmaccora on 11/03/17.
 */
public class CommandExecutor {

    private ProcessBuilder pb;
    private String sysout;
    private String task;

    public CommandExecutor(String command, List<String> arguments) {
        List<String> cmd = Arrays.asList(command);
        cmd.addAll(arguments);
        String[] cmds = cmd.toArray(new String[arguments.size() + 1]);

        task = String.join(" ", cmds);

        pb = new ProcessBuilder(cmds);
    }

    public CommandExecutor(List<String> commands) {
        task = String.join(" ", commands);
        pb = new ProcessBuilder(commands.toArray(new String[commands.size()]));
    }

    public int execute() throws IOException, InterruptedException {
        Process process = pb.start();
        BufferedReader sysoutBuff = new BufferedReader(new InputStreamReader(process.getInputStream()));

        int exitCode = process.waitFor();
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = sysoutBuff.readLine()) != null) {
            builder.append(line + "\n");
        }
        sysout = builder.toString();

        return exitCode;

    }

    public String getSysOut() {
        return sysout;
    }

    public String getTask() {
        return task;
    }
}
