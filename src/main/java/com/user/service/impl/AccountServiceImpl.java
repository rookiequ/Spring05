package com.user.service.impl;

import com.user.service.AccountService;

/**
 * @author zzq
 */
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("保存一个账号信息...");
    }

    public void updateAccount(int i) {
//        int i1 = i/0;   //用于测试异常通知
        System.out.println("修改一个账号信息..."+i);
    }

    public int deleteAccount() {
        System.out.println("删除一个账号信息");
        return 1;
    }


}
