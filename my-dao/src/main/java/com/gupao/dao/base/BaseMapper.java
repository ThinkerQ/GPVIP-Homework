package com.gupao.dao.base;


/**
 * Description: Base Mapper
 *
 * @author luxiaolong
 * @date 2018年1月12日
 */
public interface BaseMapper<T> {

    /**
     * 根据主键删除
     * 
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增 包含全部字段
     * 
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 新增 可部分字段
     * 
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 根据主键查询
     * 
     * @param id
     * @return
     */
    T selectByPrimaryKey(Long id);

    /**
     * 更新 可部分字段
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 更新 全部字段
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);


    int updateByPrimaryKeyWithBLOBs(T record);

}
