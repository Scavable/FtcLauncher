package Install.ftc;

public class DownloadFIle {
    String type;
    String hash;
    String location;
    String to;
    int size;
    boolean userFile;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isUserFile() {
        return userFile;
    }

    public void setUserFile(boolean userFile) {
        this.userFile = userFile;
    }
}
