package life.leetcoder.coderzone.mapper;

import life.leetcoder.coderzone.model.Question;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
}