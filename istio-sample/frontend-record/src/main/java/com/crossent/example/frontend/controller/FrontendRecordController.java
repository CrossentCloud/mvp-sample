package com.crossent.example.frontend.controller;

import java.util.List;
import com.crossent.example.frontend.model.Record;
import com.crossent.example.frontend.service.FrontendRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/record")
public class FrontendRecordController {

    private static final Logger logger = LoggerFactory.getLogger(FrontendRecordController.class);

    private final FrontendRecordService frontendRecordService;

    @Autowired
    public FrontendRecordController(FrontendRecordService frontendRecordService) {
        this.frontendRecordService = frontendRecordService;
    }

    @GetMapping(value = "/list")
    public List<Record> selectData() {
        return frontendRecordService.selectData();
    }

    @PostMapping(value = "/insert")
    public void insertData(@RequestBody Record record,
                             BindingResult result) {
        if (!result.hasErrors()) {
            frontendRecordService.insertData(record);
        }
    }

}
