package com.crossent.example.backend.service;

import com.crossent.example.backend.model.Record;
import com.crossent.example.backend.repository.RecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackendRecordService {

    private RecordRepository repository;

    @Autowired
    public BackendRecordService(RecordRepository repository) {
        this.repository = repository;
    }

    private static final Logger logger = LoggerFactory.getLogger(BackendRecordService.class);

    public List<Record> selectData() {
        List<Record> list = repository.findAll();
        logger.info(">>>> selectData method");
        return list;
    }

    public void insertData(Record record) {
        logger.info(">>>> insertData method");
        repository.save(record);
    }

}
