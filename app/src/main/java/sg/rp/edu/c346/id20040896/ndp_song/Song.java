package sg.rp.edu.c346.id20040896.ndp_song;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Song implements Serializable {
    private int _id;
    private String title;
    private String singer;
    private int year;
    private int star;

    public Song(int _id, String title, String singer, int year, int star) {
        this._id = _id;
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.star = star;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public int getYear() {
        return year;
    }

    public int getStar() {
        return star;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStar(int star) {
        this.star = star;
    }

    @NonNull
    @Override
    public String toString() {

        return "Title:  "+ title + " Singer: " + singer + " Year: " + year + " Rating" + star;
    }
}
