package com.trangiahuytdtu.finalproject.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Reader")
public class Reader {
    @Id
    @Column(name="idReader", length = 100)
    private String idReader;

    @ManyToOne
    @JoinColumn(name="idType", referencedColumnName = "idType")
    private TypeOfReader typeOfReader;

    @Column(name="nameReader", length = 50)
    private String nameReader;

    @Column(name="email", length = 50, unique = true)
    private String email;

    @Column(name="password", length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name="phone", length = 10)
    private String phone;

    @Column(name="address", length = 100)
    private String address;

    @Column(name="img")
    private String img;

    @Column(name="gender")
    private String gender;

    @Column(name="birthday")
    private String birthday;

    public Reader() {
    }

    public Reader(String idReader, TypeOfReader typeOfReader, String nameReader, String email, String password, Role role, String phone, String address, String img, String gender, String birthday) {
        this.idReader = idReader;
        this.typeOfReader = typeOfReader;
        this.nameReader = nameReader;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.address = address;
        this.img = img;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIdReader() {
        return idReader;
    }

    public void setIdReader(String idReader) {
        this.idReader = idReader;
    }

    public TypeOfReader getTypeOfReader() {
        return typeOfReader;
    }

    public void setTypeOfReader(TypeOfReader typeOfReader) {
        this.typeOfReader = typeOfReader;
    }

    public String getNameReader() {
        return nameReader;
    }

    public void setNameReader(String nameReader) {
        this.nameReader = nameReader;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "idReader='" + idReader + '\'' +
                ", typeOfReader=" + typeOfReader +
                ", nameReader='" + nameReader + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
