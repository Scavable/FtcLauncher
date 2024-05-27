package instance;

import javafx.scene.control.Labeled;

public class Instance {

    private String name;
    private String title;
    private String version;
    private String packVersion;
    private String instanceLocation;
    private String description;
    private String downloadLocation;
    private boolean installed;

    public String getPackVersion() {
        return packVersion;
    }

    public void setPackVersion(String packVersion) {
        this.packVersion = packVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInstanceLocation() {
        return instanceLocation;
    }

    public void setInstanceLocation(String instanceLocation) {
        this.instanceLocation = instanceLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDownloadLocation(String downloadLocation) {
        this.downloadLocation = downloadLocation;
    }

    public boolean isInstalled() {
        return installed;
    }

    public void setInstalled(boolean installed) {
        this.installed = installed;
    }

    public Instance(String name, String title, String version, String description, String downloadLocation) {
        this.name = name;
        this.title = title;
        this.version = version;
        this.description = description;
        this.downloadLocation = downloadLocation;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getDownloadLocation() {
        return downloadLocation;
    }
}
