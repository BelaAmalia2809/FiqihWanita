package id.sch.smktelkom_mlg.project2.xirpl204051233.fiqihwanita.model;

import java.io.Serializable;

/**
 * Created by user on 21/3/2017.
 */

public class Data implements Serializable {
    public String title;
    public String descripsion;
    public int picture;

    public Data(String title, String descripsion, int picture) {
        this.title = title;
        this.descripsion = descripsion;
        this.picture = picture;
    }
}
