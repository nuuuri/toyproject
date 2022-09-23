package com.nuuuri.backend.controller;

import com.nuuuri.backend.dto.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    //http://localhost:8080/test/request1/123
    @GetMapping(value = "request1/{id}")
    public String getTest1(@PathVariable Long id) {
        return "Test ID is " + id;
    }

    /*
    @GetMapping(value={"/{variable}"})
    public String getTest1(@PathVariable("variable") int id){
        return "Test ID is " + id;
    }
    */

    //http://localhost:8080/test/request2?id=123
    @GetMapping(value = "/request2")
    public String getTest2(@RequestParam Long id) {
        return "Test ID is " + id;
    }

    //http://localhost:8080/test/request3?key1=value1&key2=value2
    @GetMapping(value = "/request3")
    public String getTest3(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    /*
    //http://localhost:8080/test/request4?id=123&title=hello&content=hello&...
    @GetMapping(value={"/request4"})
    public String getTest4(TestDTO testDTO) {
        return testDTO.toString();
    }
    */

    @PostMapping(value = "/request1")
    public String postTest1(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    /*
    @PostMapping(value="/request2")
    public String postTest2(@RequestBody TestDTO testDTO {
        return testDTO.toString();
    }
    */

    @PutMapping(value = "/request1")
    public String putTest1(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    /*
    @PutMapping(value="/request2")
    public String putTest2(@RequestBody TestDTO testDTO {
        return testDTO;
    }
    */

    @PutMapping(value = "/request3")
    public ResponseEntity<PostDTO> pustTest2(@RequestBody PostDTO postDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(postDTO);
    }

    @DeleteMapping(value = "/request1/{id}")
    public String deleteTest1(@PathVariable Long id) {
        return "Test " + id + " deleted";
    }

    @DeleteMapping(value = "/request2")
    public String deleteTest2(@RequestParam Long id) {
        return "Test " + id + " deleted";
    }
}
