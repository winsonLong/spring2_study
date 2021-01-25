package com.longson.boot05web01.controller;

import com.longson.boot05web01.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PrameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id")Integer id,
                                     @PathVariable("username")String username,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters")List<String> inters,
                                     @RequestParam Map<String,String> params
                                     ){
        Map<String,Object> map=new HashMap<>();
        /*map.put("name",username);
        map.put("id",id);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("header",header);*/
        map.put("age",age);
        map.put("params",params);
        map.put("inters",inters);

        return map;

    }

    //springboot默认是禁用了矩阵变量
    //手动开启，原理，对于路径处理，urlPathHelper进行解析，
    // removeSemicolonContent（移除分号内容 ）支持矩阵变量
    //矩阵变量必须有url路径变量才能被解析
    //http://localhost:8080/cars/sell;low=34;brand=byd,audi,yd;brand=haha
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable Integer low,
                        @MatrixVariable List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();

        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);

        return map;
    }

    //http://localhost:8080/boss/1;age=10/2;age=20
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId")Integer empAge){
        Map<String,Object> map=new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }

    @GetMapping(value = "/test/person")
    public Person getPerson(){
        Person person=new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setUserName("zhangsan");
        return person;
    }



}
