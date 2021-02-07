package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis;

import android.arch.persistence.room.Entity;

import java.io.Serializable;

@Entity(tableName = "company_table")
public class Company implements Serializable {
    private String name;
    private String catchPhrase;
    private String bs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
