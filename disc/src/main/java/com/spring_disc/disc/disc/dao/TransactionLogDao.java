package com.spring_disc.disc.disc.dao;

import com.spring_disc.disc.disc.model.TransactionLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionLogDao extends MongoRepository<TransactionLog,String> {
}
