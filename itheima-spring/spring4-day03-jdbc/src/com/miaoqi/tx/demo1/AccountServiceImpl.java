package com.miaoqi.tx.demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 转账业务层的实现类
 * @author miaoqi
 *
 */
public class AccountServiceImpl implements AccountService {

    // 注入Dao
    private AccountDao accountDao;

    private TransactionTemplate transactionTemplate;

    /**
     * from: 转出账号
     * to: 转入账号
     * money: 转账金额
     */
    @Override
    public void transfer(final String from, final String to, final Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                accountDao.outMoney(from, money);
                int d = 1 / 0;
                accountDao.inMoney(to, money);
            }
        });
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

}
