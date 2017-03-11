package builder.git;

/**
 * Created by dmaccora on 11/03/17.
 */
public class GitProject {

    private String url;
    private String branch;

    public GitProject(String url, String branch) {
        this.url = url;
        this.branch = branch;
    }

    public String getUrl() {
        return url;
    }

    public String getBranch() {
        return branch;
    }

    /**
     * Constructs project name from the project URL.
     *
     * @return - Project name
     */
    public String getProjectName() {
        String[] sections = url.split("/");
        String name = sections[sections.length - 1];
        return name.substring(0, name.length() - ".git".length());
    }
}
