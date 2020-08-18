package com.gupao.module.common;

import com.gupao.dao.base.BaseMapper;

/**
 * Description: 基础Service接口
 *
 * @author luxiaolong
 * @date 2018年2月12日
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseMapper<T> getBaseMapper();

    @Override
    public int deleteByPrimaryKey(Long id) {
        return getBaseMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        return getBaseMapper().insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return getBaseMapper().insertSelective(record);
    }

    @Override
    public T getById(Long id) {
        return getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    public int updateSelective(T record) {
        return getBaseMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public int update(T record) {
        return getBaseMapper().updateByPrimaryKey(record);
    }

    @Override
    public int updateWithBLOBs(T record) {
        return getBaseMapper().updateByPrimaryKeyWithBLOBs(record);
    }

}
