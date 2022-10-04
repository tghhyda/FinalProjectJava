package com.trangiahuytdtu.finalproject.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TypeOfReader")
public class TypeOfReader {
    @Id
    @Column(name="idType", length = 20)
    private String idType;

    @Column(name="nameType", length = 100, unique = true)
    private String name;

    @Column(name="note", length = 250)
    private String note;

    public TypeOfReader() {
    }

    public TypeOfReader(String idType, String nameType, String note) {
        this.idType = idType;
        this.name = nameType;
        this.note = note;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameType) {
        this.name = nameType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "TypeOfReader{" +
                "idType='" + idType + '\'' +
                ", nameType='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
