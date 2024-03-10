package com.card.management.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.card.management.entity.AssembleDetailEntity;

@Mapper
public interface TAssembleDetailMapper {
	List<AssembleDetailEntity> selectAssembleDetailBybatchNumber(String batchNumber);

	long selectAssembleDetailCount(String batchNumber);
}