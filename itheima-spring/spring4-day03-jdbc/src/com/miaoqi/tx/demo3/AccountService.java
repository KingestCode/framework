package com.miaoqi.tx.demo3;

/**
 * 转账业务层接口
 * @author miaoqi
 *
 */
public interface AccountService {

    public void transfer(String from, String to, Double money);

}
