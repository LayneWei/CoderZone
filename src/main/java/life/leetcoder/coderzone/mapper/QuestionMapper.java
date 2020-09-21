package life.leetcoder.coderzone.mapper;

import life.leetcoder.coderzone.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author laynewei
 * @time 9/20/20 7:27 AM
 * @e-mail lengning_wei@berkeley.edu
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question limit #{offSet},#{size}")
    List<Question> list(Integer offSet,Integer size);

    @Select("select count(1) from question")
    Integer count();
}
