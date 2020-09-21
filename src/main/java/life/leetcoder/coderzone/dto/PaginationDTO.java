package life.leetcoder.coderzone.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laynewei
 * @time 9/21/20 12:09 AM
 * @e-mail lengning_wei@berkeley.edu
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Boolean showPrevious;
    private Boolean showFirstPage;
    private Boolean showNext;
    private Boolean showEndPage;

    private Integer page;
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();


    public void setPagination(Integer totalCount, Integer page, Integer size) {
        Integer totalPage = 0;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        if (page <1) {
            page = 1;
        } else if (page>totalPage){
            page = totalPage;
        }

        this.page=page;
        this.totalPage=totalPage;

        pages.add(page);
        for ( int i = 1; i <= 3 ; i++){
            if (page - i > 0) {
                pages.add(0, page-i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
