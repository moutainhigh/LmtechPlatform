package com.lmtech.infrastructure.dao;

import com.lmtech.dao.Dao;
import com.lmtech.infrastructure.model.Tenancy;

/**
 * 租户Dao
 * @author huang.jb
 */
public interface TenancyDao extends Dao<Tenancy> {
    /**
     * 通过code获取租户信息
     * @param code
     * @return
     */
    Tenancy getByCode(String code);
}
