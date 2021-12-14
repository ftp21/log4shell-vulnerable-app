package fr.christophetd.log4shell.vulnerableapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.*;
import java.util.*;
@RestController
public class MainController {

    private static final Logger logger = LogManager.getLogger("VulnApp");

    @GetMapping("/**")
/*    public String index(@RequestHeader("User-Agent") String apiVersion) {
        logger.info("User-Agent: " + apiVersion);
        return "Hello, world!";
    }*/
	public String listAllHeaders(
	  @RequestHeader Map<String, String> headers, @PathVariable(required = false) String path, HttpServletRequest request) {


	    headers.forEach((key, value) -> {
		logger.info(String.format("Header '%s' = %s", key, value));
	    });
	    logger.info(String.format("Path: %s",request.getRequestURL()));
	    return  "Hey girls Hey boys Superstar DJ's Here we go";
	}
}
