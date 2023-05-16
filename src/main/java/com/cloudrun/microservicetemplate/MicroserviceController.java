package com.cloudrun.microservicetemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroserviceController {

  @GetMapping("/")
  public @ResponseBody String index() {
    return "Hello Jakob!";
  }
}
