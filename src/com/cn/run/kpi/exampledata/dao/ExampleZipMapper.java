package com.cn.run.kpi.exampledata.dao;

import java.util.List;

import com.cn.run.kpi.exampledata.entity.ExampleZip;

public interface ExampleZipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExampleZip record);

    int insertSelective(ExampleZip record);

    ExampleZip selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExampleZip record);

    int updateByPrimaryKey(ExampleZip record);

	/**
	 * @param example
	 * @return
	 */
	List<ExampleZip> getList(ExampleZip example);
}