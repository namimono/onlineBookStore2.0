package com.hx5847.onlinebookstore.business.common.model;


public class Book extends Usersmessage {

  private Integer bookId;
  private String author;
  private Integer year;
  private String title;
  private String languageCode;
  private double averageRating;
  private Integer click;
  private Integer collection;
  private String imageUrl;

  public Book() {
  }

  public Book(Integer bookId, String author, Integer year, String title, String languageCode, double averageRating, Integer click, Integer collection, String imageUrl) {
    this.bookId = bookId;
    this.author = author;
    this.year = year;
    this.title = title;
    this.languageCode = languageCode;
    this.averageRating = averageRating;
    this.click = click;
    this.collection = collection;
    this.imageUrl = imageUrl;
  }

  public Integer getBookId() {
    return bookId;
  }

  public void setBookId(Integer bookId) {
    this.bookId = bookId;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLanguageCode() {
    return languageCode;
  }

  public void setLanguageCode(String languageCode) {
    this.languageCode = languageCode;
  }

  public double getAverageRating() {
    return averageRating;
  }

  public void setAverageRating(double averageRating) {
    this.averageRating = averageRating;
  }

  public Integer getClick() {
    return click;
  }

  public void setClick(Integer click) {
    this.click = click;
  }

  public Integer getCollection() {
    return collection;
  }

  public void setCollection(Integer collection) {
    this.collection = collection;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @Override
  public String toString() {
    return "Book{" +
            "bookId=" + bookId +
            ", author='" + author + '\'' +
            ", year=" + year +
            ", title='" + title + '\'' +
            ", languageCode='" + languageCode + '\'' +
            ", averageRating=" + averageRating +
            ", click=" + click +
            ", collection=" + collection +
            ", imageUrl='" + imageUrl + '\'' +
            '}';
  }
}
