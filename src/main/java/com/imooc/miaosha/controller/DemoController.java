package com.imooc.miaosha.controller;

import com.imooc.miaosha.pojo.User;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;

import static javafx.scene.input.KeyCode.T;

@Controller
@RequestMapping("/demo")
public class DemoController {

		@Autowired
		private UserService userService;
		@Autowired
        private RedisService redisService;

	 	@RequestMapping("/")
	    @ResponseBody
	    String home() {
	        return "Hello World!";
	    }

	 	//1.rest api json输出 2.页面
	 	@RequestMapping("/hello")
	    @ResponseBody
	    public Result<String> hello() {
	 		return Result.createBySuccessMessage("成功");
	       // return new Result(0, "success", "hello,imooc");
	    }
	 	
	 	@RequestMapping("/helloError")
	    @ResponseBody
	    public Result<String> helloError() {
	 		return Result.createByErrorMessage("失败");
	 		//return new Result(500102, "XXX");
	    }
		@RequestMapping("/getUser")
		@ResponseBody
	    public Result<User> getUserByName(String name){
	 		if(name.equals("yang")){
	 			User user = new User(1,"yang","123456");
	 			return Result.createBySuccessMessageDate(CodeMsg.SUCCESS.getDesc(),user);
			}else return Result.createByErrorMessage("cha wu ci ren");
		}
	 	@RequestMapping("/thymeleaf")
		@ResponseBody
	    public String  thymeleaf(Model model) {
	 		model.addAttribute("name", "Joshua");
	 		return "hello";
	    }
	    //注册一个账号!
	    @RequestMapping("/db/tx")
		@ResponseBody
		public Result<User> dbTx(){
	 		User resUser = userService.tx();
	 		if(resUser != null){
				return Result.createBySuccessMessageDate("注册成功",resUser);
			}else{
	 			return Result.createByErrorMessage("注册失败");
			}
		}
		@RequestMapping("/redis/get")
		@ResponseBody
        public Result<Long> redisGet(){
	 	    Long v1 = redisService.get("key1",long.class);
	 	    return Result.createBySuccessMessageDate("成功",v1);
        }
        @RequestMapping("/redis/set")
        @ResponseBody
        public Result<String> redisSet() {
           boolean ret = redisService.set("key2","hello,immoc");
           String str = redisService.get("key2",String.class);
            return Result.createBySuccessMessageDate("成功了",str);
        }
}
