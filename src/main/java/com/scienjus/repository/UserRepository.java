package com.scienjus.repository;

import com.scienjus.authorization.repository.UserModelRepository;
import com.scienjus.domain.User;

/**
 * @author XieEnlong
 * @date 2015/10/26.
 */
public class UserRepository implements UserModelRepository {
    @Override
    public Object getCurrentUser(String key) {
        User user = new User();
        user.setUsername(key);
        return user;
    }
}
