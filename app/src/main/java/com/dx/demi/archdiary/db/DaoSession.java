package com.dx.demi.archdiary.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.dx.demi.archdiary.bean.Project;
import com.dx.demi.archdiary.bean.Staff;
import com.dx.demi.archdiary.bean.Work;

import com.dx.demi.archdiary.db.ProjectDao;
import com.dx.demi.archdiary.db.StaffDao;
import com.dx.demi.archdiary.db.WorkDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig projectDaoConfig;
    private final DaoConfig staffDaoConfig;
    private final DaoConfig workDaoConfig;

    private final ProjectDao projectDao;
    private final StaffDao staffDao;
    private final WorkDao workDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        projectDaoConfig = daoConfigMap.get(ProjectDao.class).clone();
        projectDaoConfig.initIdentityScope(type);

        staffDaoConfig = daoConfigMap.get(StaffDao.class).clone();
        staffDaoConfig.initIdentityScope(type);

        workDaoConfig = daoConfigMap.get(WorkDao.class).clone();
        workDaoConfig.initIdentityScope(type);

        projectDao = new ProjectDao(projectDaoConfig, this);
        staffDao = new StaffDao(staffDaoConfig, this);
        workDao = new WorkDao(workDaoConfig, this);

        registerDao(Project.class, projectDao);
        registerDao(Staff.class, staffDao);
        registerDao(Work.class, workDao);
    }
    
    public void clear() {
        projectDaoConfig.clearIdentityScope();
        staffDaoConfig.clearIdentityScope();
        workDaoConfig.clearIdentityScope();
    }

    public ProjectDao getProjectDao() {
        return projectDao;
    }

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public WorkDao getWorkDao() {
        return workDao;
    }

}
