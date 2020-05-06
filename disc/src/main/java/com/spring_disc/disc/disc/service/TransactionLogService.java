package com.spring_disc.disc.disc.service;

import com.spring_disc.disc.disc.dao.TransactionLogDao;
import com.spring_disc.disc.disc.dao.TransactionLogDaoImpl;
import com.spring_disc.disc.disc.model.TransactionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TransactionLogService {

    @Autowired
    TransactionLogDaoImpl transactionLogDaoImpl;


    public void newTransaction(TransactionLog transactionLog) {
        transactionLogDaoImpl.newTransaction(transactionLog);
    }

    public Collection<TransactionLog> getTransaction() {
        return transactionLogDaoImpl.getTransaction();
    }
}
