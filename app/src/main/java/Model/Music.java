package Model;

public class Music {
    private int image,id;
    private String title;
    private String artist;
    private int file;

    public Music() {

    }

    public Music(int id, int image, String title, String artist, int file) {
        this.image = image;
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.file = file;
    }

    public Music(int img, String title, String artist) {

        this.title = title;
        this.artist = artist;
        this.image = img;
    }

    public Music(int image, String title, String artist, int file) {
        this.image = image;
        this.title = title;
        this.artist = artist;
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}