package com.crossent.example.backend.controller;

import com.crossent.example.backend.model.Record;
import com.crossent.example.backend.service.BackendRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BackendRecordController {

    private static final Logger logger = LoggerFactory.getLogger(BackendRecordController.class);

    private final BackendRecordService backendRecordService;

    public BackendRecordController(BackendRecordService backendRecordService) {
        this.backendRecordService = backendRecordService;
    }

    @GetMapping(value = "/record/list")
    public List<Record> selectData() {
        return backendRecordService.selectData();
    }

    @PostMapping(value = "/record/insert")
    public void insertData(@RequestBody Map<String, Object> body) {

        if (body != null) {
            Record record = new Record();
            record.setData((String)body.get("data"));
            backendRecordService.insertData(record);
        }

    }

}
