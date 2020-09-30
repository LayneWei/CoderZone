package life.leetcoder.coderzone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
@MapperScan("life.leetcoder.coderzone.mapper")
@SpringBootApplication
public class CoderzoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoderzoneApplication.class, args);
    }

}
