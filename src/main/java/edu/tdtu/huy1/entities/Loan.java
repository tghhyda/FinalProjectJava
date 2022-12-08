package edu.tdtu.huy1.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLoan;

    @ManyToOne
    @JoinColumn(name="idReader", referencedColumnName = "idReader")
    private Reader reader;


    @Column(name="dateBorrow")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateBorrow;

    @Column(name="dateReturn")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateReturn;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "loan_book",
            joinColumns = {
                    @JoinColumn(name = "idLoan", referencedColumnName = "idLoan",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "idBook", referencedColumnName = "idBook",
                            nullable = false, updatable = false)})
    private Set<Book> books = new HashSet<>();

    public Loan() {
    }

    public Loan(Reader reader, Date dateBorrow, Date dateReturn) {
        this.reader = reader;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
    }

    public int getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(int idLoan) {
        this.idLoan = idLoan;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(Date dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "idLoan=" + idLoan +
                ", reader=" + reader +
                ", dateBorrow=" + dateBorrow +
                ", dateReturn=" + dateReturn +
                '}';
    }
}

