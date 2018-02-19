package co.id.memorize.model;

/**
 * Created by eminartiys on 17/02/18.
 */

public class Film {

    private String id;
    private String title;
    private String director;
    private String producer;
    private String release_date;
    private String rt_score;

    public Film(String id, String title, String director, String producer,
                String release_date, String rt_score) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.producer = producer;
        this.release_date = release_date;
        this.rt_score = rt_score;
    }

    public String getId() {
        if (id != null) {
            return id;
        }
        return "";
    }

    public String getTitle() {
        if (title != null) {
            return title;
        }
        return "";
    }

    public String getDirector() {
        if (director != null) {
            return director;
        }
        return "";
    }

    public String getProducer() {
        if (producer != null) {
            return producer;
        }
        return "";
    }

    public String getReleaseDate() {
        if (release_date != null) {
            return release_date;
        }
        return "";
    }

    public String getRtScore() {
        if (rt_score != null) {
            return rt_score;
        }
        return "";
    }
}
