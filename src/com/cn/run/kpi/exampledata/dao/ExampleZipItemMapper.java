package com.cn.run.kpi.exampledata.dao;

import java.util.List;

import com.cn.run.kpi.exampledata.entity.ExampleZipItem;

public interface ExampleZipItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExampleZipItem record);

    int insertSelective(ExampleZipItem record);

    ExampleZipItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExampleZipItem record);

    int updateByPrimaryKey(ExampleZipItem record);

	List<ExampleZipItem> getSubList(ExampleZipItem exampleitem);

	void insertBatch(List<ExampleZipItem> list);
}