package com.miaoqi.tx.demo2;

/**
 * 转账业务层的实现类
 * @author miaoqi
 *
 */
public class AccountServiceImpl implements AccountService {

    // 注入Dao
    private AccountDao accountDao;


    /**
     * from: 转出账号
     * to: 转入账号
     * money: 转账金额
     */
    @Override
    public void transfer(String from, String to, Double money) {
        accountDao.outMoney(from, money);
        int d = 1 / 0;
        accountDao.inMoney(to, money);
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

}
