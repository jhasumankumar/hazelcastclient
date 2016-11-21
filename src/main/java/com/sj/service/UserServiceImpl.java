package com.sj.service;




import com.sj.hazalcast.DistributedCacheManager;
import com.sj.model.UserModel;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ConcurrentMap;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private DistributedCacheManager distributedCacheManager;


    @Override
    @Transactional
    public boolean saveUser(UserModel userModel) {
        ConcurrentMap<Long, UserModel> cache = distributedCacheManager.getCache("store");
        cache.put(userModel.getId(), userModel);
       // userBagDao.save(userModel);
        ConcurrentMap naer = distributedCacheManager.getCache("near");
        naer.put(userModel.getId(), userModel);
        return true;
    }

    @Override
    public UserModel getUser(Long id) {
        ConcurrentMap<Integer, UserModel> cache = distributedCacheManager.getCache("store");
        UserModel userModel = cache.get(id);
        //return userBagDao.findOne(id);
        ConcurrentMap naer = distributedCacheManager.getCache("near");
        userModel = (UserModel)naer.get(id);
        return userModel;
    }




}
