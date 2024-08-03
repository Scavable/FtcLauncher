package Install.ftc;

public class DownloadFile {
    String type;
    String hash;
    String location;
    String to;
    int size;
    boolean userFile;
    String loaderName;
    Object processor;

    public Object getProcessor() {
        return processor;
    }

    public void setProcessor(Object processor) {
        this.processor = processor;
    }



    public String getLoaderName() {
        return loaderName;
    }

    public void setLoaderName(String loaderName) {
        this.loaderName = loaderName;
    }



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

    @Override
    public String toString() {
        return "DownloadFile [type=" + type + ", hash=" + hash + ", location=" + location + ", to=" + to +
                ", size=" + size + ", userFile=" + userFile + ", loaderName=" + loaderName + ", processor=" + processor + "]";
    }
}
