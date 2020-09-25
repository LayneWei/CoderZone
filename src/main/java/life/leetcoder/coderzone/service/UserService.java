package life.leetcoder.coderzone.service;

import life.leetcoder.coderzone.mapper.UserMapper;
import life.leetcoder.coderzone.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author laynewei
 * @time 9/25/20 12:15 AM
 * @e-mail lengning_wei@berkeley.edu
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public void createOrUpdate(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccountId());
        if (dbUser==null) {
            //insert
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        } else {
            //update
            dbUser.setGmtModified(System.currentTimeMillis());
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setToken(user.getToken());
            dbUser.setName(user.getName());
            userMapper.update(dbUser);
        }
    }
}
