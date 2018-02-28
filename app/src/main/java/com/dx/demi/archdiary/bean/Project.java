package com.dx.demi.archdiary.bean;

import com.dx.demi.archdiary.utils.TimeFormatUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.io.Serializable;
import java.util.List;
import org.greenrobot.greendao.DaoException;
import com.dx.demi.archdiary.db.DaoSession;
import com.dx.demi.archdiary.db.StaffDao;
import com.dx.demi.archdiary.db.ProjectDao;

/**
 * Created by demi on 2018/2/26.
 */
@Entity
public class Project implements Serializable{
private static final long serialVersionUID = 536871008;
    @Id(autoincrement = true)
    private Long id;
    @Unique
    @Property(nameInDb = "projname")    //工程名字
    private String projName;
    @Property(nameInDb = "projhost")   //工程发起人
    private String projHost;
    @Property(nameInDb = "projdtate")   //工程状态
    private String projState;
    @Property(nameInDb = "projdescrib")   //工程简介
    private String projDescrib;
    @Property(nameInDb = "projtime")    //工程开工时间
    private String projTime;

    @ToMany(referencedJoinProperty = "pid")    //工人
    private List<Staff> mStaffs;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1378029107)
    private transient ProjectDao myDao;

    public Project( String projName, String projState, String projHost,
            String projDescrib) {
        this.projName = projName;
        this.projHost = projHost;
        this.projState = projState;
        this.projDescrib =projDescrib;
        this.projTime = TimeFormatUtils.getDay(System.currentTimeMillis());
    }

    @Keep
    public Project() {
    }


    @Keep
    public Project(Long id, String projName, String projHost, String projState,
            String projDescrib,String projTime) {
        this.id = id;
        this.projName = projName;
        this.projHost = projHost;
        this.projState = projState;
        this.projDescrib = projDescrib;
        this.projTime =  projTime;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjTime() {
        return projTime;
    }

    public void setProjTime(String projTime) {
        this.projTime = projTime;
    }

    public List<Staff> getStaffs() {
        return mStaffs;
    }

    public void setStaffs(List<Staff> staffs) {
        mStaffs = staffs;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1125932752)
    public List<Staff> getMStaffs() {
        if (mStaffs == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StaffDao targetDao = daoSession.getStaffDao();
            List<Staff> mStaffsNew = targetDao._queryProject_MStaffs(id);
            synchronized (this) {
                if (mStaffs == null) {
                    mStaffs = mStaffsNew;
                }
            }
        }
        return mStaffs;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1155939284)
    public synchronized void resetMStaffs() {
        mStaffs = null;
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
    @Generated(hash = 2081800561)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getProjectDao() : null;
    }
}
