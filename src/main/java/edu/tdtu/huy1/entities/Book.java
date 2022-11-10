package edu.tdtu.huy1.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Book")
public class Book {
    @Id
    @Column(name="idBook", length = 30)
    private String idBook;

    @Column(name="nameBook", length = 100)
    private String nameBook;

    @Column(name="author", length = 100)
    private String author;

    @ManyToOne
    @JoinColumn(name="idProducer", referencedColumnName = "idProducer")
    private Producer producer;

    @ManyToOne
    @JoinColumn(name="idType", referencedColumnName = "idType")
    private TypeOfBook typeOfBook;

    @Column(name="initialPrice")
    private int initialPrice;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private Set<Loan> loans = new HashSet<>();

    @Column(name="img")
    private String img;

    @Column(name="remain")
    private int remain;

    @Column(name="description")
    private String description;

    public Book() {
    }

    public Book(String idBook, String nameBook, String author, Producer producer, TypeOfBook typeOfBook, int initialPrice, String img, int remain, String description) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.author = author;
        this.producer = producer;
        this.typeOfBook = typeOfBook;
        this.initialPrice = initialPrice;
        this.img = img;
        this.remain = remain;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public int getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(int initialPrice) {
        this.initialPrice = initialPrice;
    }

    public TypeOfBook getTypeOfBook() {
        return typeOfBook;
    }

    public void setTypeOfBook(TypeOfBook typeOfBook) {
        this.typeOfBook = typeOfBook;
    }

    @Transient
    public String getImagePath(){
        if(img == null || idBook == null) return null;
        return "/book-images/"+idBook+"/"+img;
    }
    @Override
    public String toString() {
        return "Book{" +
                "idBook='" + idBook + '\'' +
                ", nameBook='" + nameBook + '\'' +
                ", author='" + author + '\'' +
                ", producer=" + producer +
                ", initialPrice=" + initialPrice +
                '}';
    }
}
