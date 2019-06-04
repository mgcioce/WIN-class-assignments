package library.items;

import library.persons.Publisher;

import java.time.Year;

public class Item implements Loanable, Reservable{

    private Long itemId;
    private String media;
    private String title;
    private Publisher publisherId;
    private Year yearOfRelease;
    private String genre;

    public Item(Long itemId, String media, String title, Publisher publisherId, Year yearOfRelease,
                String genre) {
        this.itemId = itemId;
        this.media = media;
        this.title = title;
        this.publisherId = publisherId;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

    public Year getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Year yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
