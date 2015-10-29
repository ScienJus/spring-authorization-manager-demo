package com.scienjus.controller;

import com.scienjus.authorization.annotation.Authorization;
import com.scienjus.authorization.annotation.CurrentUser;
import com.scienjus.authorization.manager.TokenManager;
import com.scienjus.domain.User;
import com.scienjus.model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 获取和删除token的请求地址，在Restful设计中其实就对应着登录和退出登录的资源映射
 * @author ScienJus
 * @date 2015/7/30.
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    private TokenManager tokenManager;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResultModel> createToken(@RequestParam String username) {
        //如果是单点登录的话，清除掉其他token
        tokenManager.delRelationshipByKey(username);
        //生成一个token
        String token = UUID.randomUUID().toString();
        tokenManager.createRelationship(username, token);
        return new ResponseEntity<>(ResultModel.ok(token), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    @Authorization
    public ResponseEntity<ResultModel> getUsername(@CurrentUser User user) {
        //生成一个token
        return new ResponseEntity<>(ResultModel.ok(user.getUsername()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Authorization
    public ResponseEntity<ResultModel> logout(@CurrentUser User user) {
        tokenManager.delRelationshipByKey(user.getUsername());
        return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
    }

}
