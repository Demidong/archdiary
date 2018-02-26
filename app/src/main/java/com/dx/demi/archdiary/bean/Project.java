package com.dx.demi.archdiary.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;

import java.io.Serializable;

/**
 * Created by demi on 2018/2/26.
 */
@Entity
public class Project {

    @Id(autoincrement = true)
    private long id;
    @Unique
    @Property(nameInDb = "projname")
    private String projName;
    @Property(nameInDb = "projhost")
    private String projHost;
    @Property(nameInDb = "projdtate")
    private String projState;
    @Property(nameInDb = "projdescrib")
    private String projDescrib;

    @Keep
    public Project(long id, String projName, String projState, String projHost,
            String projDescrib) {
        this.id = id;
        this.projName = projName;
        this.projHost = projHost;
        this.projState = projState;
        this.projDescrib = projDescrib;
    }

    @Keep
    public Project() {
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjHost() {
        return projHost;
    }

    public void setProjHost(String projHost) {
        this.projHost = projHost;
    }

    public String getProjState() {
        return projState;
    }

    public void setProjState(String projState) {
        this.projState = projState;
    }

    public String getProjDescrib() {
        return projDescrib;
    }

    public void setProjDescrib(String projDescrib) {
        this.projDescrib = projDescrib;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
