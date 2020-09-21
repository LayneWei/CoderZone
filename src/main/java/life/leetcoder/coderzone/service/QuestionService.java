package life.leetcoder.coderzone.service;

import life.leetcoder.coderzone.dto.PaginationDTO;
import life.leetcoder.coderzone.dto.QuestionDTO;
import life.leetcoder.coderzone.mapper.QuestionMapper;
import life.leetcoder.coderzone.mapper.UserMapper;
import life.leetcoder.coderzone.model.Question;
import life.leetcoder.coderzone.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laynewei
 * @time 9/20/20 7:57 PM
 * @e-mail lengning_wei@berkeley.edu
 */


@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO list(Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount,page,size);
        Integer totalPage = 0;
        if (page <1) {
            page = 1;
        } else if (page>paginationDTO.getTotalPage()){
            page = paginationDTO.getTotalPage();
        }
        Integer offSet = size*(page-1);

        List<Question> questions = questionMapper.list(offSet,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }
}