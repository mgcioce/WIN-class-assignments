package org.carolinafintechhub.bookshelfapi.model;

public class Book {

//    id: Long
//    name: String
//    pageCount: Int
//    author: Author
    private Long id;
    private String name;
    private Integer pageCount;
    private Author author;

    public Book() {};

    public Book(Long id, String name, Integer pagecount, Author author) {
        this.id = id;
        this.name = name;
        this.pageCount = pagecount;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
