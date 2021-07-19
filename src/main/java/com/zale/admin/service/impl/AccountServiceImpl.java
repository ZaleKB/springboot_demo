package com.zale.admin.service.impl;

import com.zale.admin.bean.Account;
import com.zale.admin.mapper.AccountMapper;
import com.zale.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcctByid(Long id){
        return accountMapper.getAcct(id);
    }
}
