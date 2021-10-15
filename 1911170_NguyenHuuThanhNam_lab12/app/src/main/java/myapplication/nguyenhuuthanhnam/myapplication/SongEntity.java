package myapplication.nguyenhuuthanhnam.myapplication;

public class SongEntity {
    private String name, path, album;
    public SongEntity(String name, String path, String album) {
        this.name = name;
        this.path = path;
        this.album = album;
    }
    public String getName() {
        return name;
    }
    public String getPath() {
        return path;
    }
    public String getAlbum() {
        return album;
    }
}
