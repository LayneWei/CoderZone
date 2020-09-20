package life.leetcoder.coderzone.mapper;

import life.leetcoder.coderzone.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author laynewei
 * @time 9/19/20 10:36 AM
 * @e-mail lengning_wei@berkeley.edu
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
