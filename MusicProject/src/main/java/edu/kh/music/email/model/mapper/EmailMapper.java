package edu.kh.music.email.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailMapper {

	int udpateAuthKey(Map<String, Object> map);

	int insertAuthKey(Map<String, Object> map);

	int checkAuthKey(Map<String, Object> map);

}
