package life.leetcoder.coderzone.mapper;

import life.leetcoder.coderzone.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author laynewei
 * @time 9/19/20 10:36 AM
 * @e-mail lengning_wei@berkeley.edu
 */
@Mapper
public interface UserMapper {
    /* insert user information to user table*/
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    /* find the user token*/
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user set name=#{name}, token=#{token}, gmt_modified=#{gmtModified}, AVATAR_URL=#{avatarUrl} where id=#{id}")
    void update(User dbUser);
}
