package com.ruban.usermapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ruban.predict.domain.RubanTaskConfig;

@Mapper
public interface RubanTaskConfigMapper {
	List<RubanTaskConfig> listAllUser();
}
