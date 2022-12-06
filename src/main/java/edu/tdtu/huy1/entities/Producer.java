package edu.tdtu.huy1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producer")
public class Producer {
    @Id
    @Column(name="idProducer")
    private String idProducer;

    @Column(name="nameProducer", length = 100)
    private String nameProducer;

    @Column(name="phoneProducer", length = 10)
    private String phoneProducer;

    @Column(name="addressProducer", length = 150)
    private String addressProducer;

    public Producer() {
    }

    public Producer(String idProducer, String nameProducer, String phoneProducer, String addressProducer) {
        this.idProducer = idProducer;
        this.nameProducer = nameProducer;
        this.phoneProducer = phoneProducer;
        this.addressProducer = addressProducer;
    }

    public String getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(String idProducer) {
        this.idProducer = idProducer;
    }

    public String getNameProducer() {
        return nameProducer;
    }

    public void setNameProducer(String nameProducer) {
        this.nameProducer = nameProducer;
    }

    public String getPhoneProducer() {
        return phoneProducer;
    }

    public void setPhoneProducer(String phoneProducer) {
        this.phoneProducer = phoneProducer;
    }

    public String getAddressProducer() {
        return addressProducer;
    }

    public void setAddressProducer(String addressProducer) {
        this.addressProducer = addressProducer;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "idProducer='" + idProducer + '\'' +
                ", nameProducer='" + nameProducer + '\'' +
                ", phoneProducer='" + phoneProducer + '\'' +
                ", addressProducer='" + addressProducer + '\'' +
                '}';
    }
}
