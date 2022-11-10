package edu.tdtu.huy1.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TypeOfBook")
public class TypeOfBook {
    @Id
    @Column(name="idType", length = 20)
    private String idType;

    @Column(name="nameType", length = 100)
    private String nameType;

    @Column(name="note", length = 250)
    private String note;

    public TypeOfBook() {
    }

    public TypeOfBook(String idType, String nameType, String note) {
        this.idType = idType;
        this.nameType = nameType;
        this.note = note;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "TypeOfBook{" +
                "idType='" + idType + '\'' +
                ", nameType='" + nameType + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
