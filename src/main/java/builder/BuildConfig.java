package builder;

import java.util.List;

public class BuildConfig {
    private List<String> beforeBuild;
    private List<String> build;
    private List<String> afterBuild;

    public List<String> getBeforeBuild() {
        return beforeBuild;
    }

    public List<String> getBuild() {
        return build;
    }

    public List<String> getAfterBuild() {
        return afterBuild;
    }

    public void setBeforeBuild(List<String> beforeBuild) {
        this.beforeBuild = beforeBuild;
    }

    public void setBuild(List<String> build) {
        this.build = build;
    }

    public void setAfterBuild(List<String> afterBuild) {
        this.afterBuild = afterBuild;
    }

    @Override
    public String toString() {
        return "beforeBuild: " + beforeBuild + " builder " + build + " afterBuild" + afterBuild;
    }
}