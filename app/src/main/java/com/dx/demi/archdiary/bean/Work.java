package com.dx.demi.archdiary.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by demi on 2018/2/28.
 */
@Entity
public class Work {

    @Id(autoincrement = true)
    private Long id;

    private Long sid;   //工人ID

    @Property(nameInDb = "daytime")  //做工日期
    private String daytime;

    @Property(nameInDb = "duration")  //工人做工时长
    private String duration;

    @Property(nameInDb = "money")  //工人该天工资
    private double money;

    @Generated(hash = 1483075132)
    public Work(Long id, Long sid, String daytime, String duration, double money) {
        this.id = id;
        this.sid = sid;
        this.daytime = daytime;
        this.duration = duration;
        this.money = money;
    }

    public Work( Long sid, String daytime, String duration, double money) {
        this.sid = sid;
        this.daytime = daytime;
        this.duration = duration;
        this.money = money;
    }

    @Generated(hash = 572069219)
    public Work() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSid() {
        return this.sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getDaytime() {
        return this.daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
}
