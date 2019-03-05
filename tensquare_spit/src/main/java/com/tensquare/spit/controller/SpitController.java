package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<Spit> lists = spitService.findAll();
        return  new Result(true,StatusCode.OK,
                "查询成功",lists);
    }

    @RequestMapping(value ="/{spitId}",method = RequestMethod.GET)
    public Result findById(@PathVariable String spitId){
        return new Result(true,StatusCode.OK,"查询成功",spitService.findById(spitId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody  Spit spit){
        spitService.save(spit);
        return  new Result(true, StatusCode.OK,"增加成功");
    }

    @RequestMapping(value = "/{spitId}",method = RequestMethod.PUT)
    public Result update(@PathVariable String spitId,@RequestBody  Spit spit){
        spitService.update(spit);
        return  new Result(true, StatusCode.OK,"修改成功");
    }

    @RequestMapping(value = "/{spitId}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable  String id){
        spitService.deleteById(id);
        return  new Result(true, StatusCode.OK,"删除成功");
    }

    @RequestMapping(value = "/comment/{parentid}/{page}/{size}",method = RequestMethod.GET)
    public Result findByParentid(
            @PathVariable String parentid,
            @PathVariable Integer page,
            @PathVariable Integer size
    ){
        Page<Spit> lists= this.spitService.findByParentid(parentid,page,size);
        return new Result(true,StatusCode.OK,"查询成功",lists);

    }

    @RequestMapping(value = "/thumbup/{spitId}",method = RequestMethod.PUT)
    public Result thumbup(@PathVariable String spitId){
        String userid = "111";
        if(redisTemplate.opsForValue().get("thumbup_"+userid)!=null){
            return new Result(true,StatusCode.REPREEOR,"不能重复点赞");
        };
        spitService.thumbup(spitId);
        redisTemplate.opsForValue().set("thumbup_"+userid,1);
        return new Result(true,StatusCode.OK,"点赞成功");
    }
}
