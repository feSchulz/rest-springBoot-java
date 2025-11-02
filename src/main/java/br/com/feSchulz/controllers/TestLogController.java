package br.com.feSchulz.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {
    private Logger log = LoggerFactory.getLogger(TestLogController.class.getName());
@GetMapping("/teste")
    public String testLog(){
    log.debug("Log debug");
    log.info("Log info");
    log.warn("Log warn");
    log.error("Log error");

        return "Log gerados com sucesso";
    }
}
