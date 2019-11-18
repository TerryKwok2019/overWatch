package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import online.shixun.project.pojo.UserPojo;
@Mapper
public interface UserMapper {

	List<UserPojo> getUser(UserPojo user);

	
}
