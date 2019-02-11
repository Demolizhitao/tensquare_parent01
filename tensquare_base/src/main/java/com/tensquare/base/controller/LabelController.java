package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("labelID") String labelId){
        return new Result(true,StatusCode.OK,"查询成功");
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        return new Result(true,StatusCode.OK,"增加成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId,@RequestBody Label label){
        return new Result(true,StatusCode.OK,"更新成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelId){
        return new Result(true,StatusCode.OK,"删除成功");
    }

}
