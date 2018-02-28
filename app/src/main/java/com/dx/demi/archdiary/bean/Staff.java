package com.dx.demi.archdiary.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;
import java.util.List;
import org.greenrobot.greendao.DaoException;
import com.dx.demi.archdiary.db.DaoSession;
import com.dx.demi.archdiary.db.WorkDao;
import com.dx.demi.archdiary.db.StaffDao;

/**
 * Created by demi on 2018/2/27.
 */
@Entity
public class Staff implements Serializable {
    private static final long serialVersionUID = 536871008;
    @Id(autoincrement = true)
    private Long id;
    private Long pid;  //工程ID

    @Property(nameInDb = "name")  //工人名字
    private String name;
    @Property(nameInDb = "age")   //工人年龄
    private int age;
    @Property(nameInDb = "salary")  //工人薪资
    private double salary;
    @Property(nameInDb = "level")   //工人等级 小工，大工
    private String level;
    @Property(nameInDb = "money")  //工人总工资
    private double money;
    @ToMany(referencedJoinProperty = "sid")    //工人
    private List<Work> mWorks;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1940714421)
    private transient StaffDao myDao;

    public Staff(String name, Long pid, int age, double salary, String level,
            double money) {
        this.pid = pid;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.level = level;
        this.money = money;
    }

    @Keep
    public Staff() {
    }

    @Generated(hash = 430461292)
    public Staff(Long id, Long pid, String name, int age, double salary,
            String level, double money) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.level = level;
        this.money = money;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getSalary() {
        return this.salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getLevel() {
        return this.level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public double getMoney() {
        return this.money;
    }
    public void setMoney(double money) {
        this.money = money;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 894196060)
    public List<Work> getMWorks() {
        if (mWorks == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WorkDao targetDao = daoSession.getWorkDao();
            List<Work> mWorksNew = targetDao._queryStaff_MWorks(id);
            synchronized (this) {
                if (mWorks == null) {
                    mWorks = mWorksNew;
                }
            }
        }
        return mWorks;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 790804331)
    public synchronized void resetMWorks() {
        mWorks = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1573905378)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStaffDao() : null;
    }
}
