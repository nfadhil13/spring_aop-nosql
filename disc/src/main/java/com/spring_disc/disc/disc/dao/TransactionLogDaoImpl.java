package com.spring_disc.disc.disc.dao;

import com.spring_disc.disc.disc.model.TransactionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class TransactionLogDaoImpl {

    @Autowired
    TransactionLogDao transactionLogDao;


    public void newTransaction(TransactionLog transactionLog) {
        transactionLogDao.save(transactionLog);
    }

    public Collection<TransactionLog> getTransaction() {
        return transactionLogDao.findAll();
    }
}
