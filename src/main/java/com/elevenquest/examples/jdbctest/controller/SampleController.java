package com.elevenquest.examples.jdbctest.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
  @Autowired
  DataSource ds;

  @GetMapping("/greeting")
  public String greeting(@RequestParam(value = "name", defaultValue = "World")String name) {
    Connection con = null;
    try {
      con = ds.getConnection();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      if(con != null) try { con.close(); } catch (Exception ne) {
        ne.printStackTrace();
      }
    }
    return "Hello " + name;
  }
  
}