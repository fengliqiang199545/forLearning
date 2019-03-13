package cn.com.taiji.controller;

import cn.com.taiji.pojo.Address;
import cn.com.taiji.pojo.Person;
import com.google.gson.Gson;
import org.aspectj.weaver.patterns.PerFromSuper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

/**
 * @author fengliqiang
 * @date 2019/03/06/3:20 PM
 **/
@Controller
@RequestMapping("first")
@SessionAttributes(value = "personse")
public class HelloController {

    public static final String SUCCESS = "success";

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("JavaEE HelloWorld!");
        return "success";
    }

    @RequestMapping(value = "/method" ,method = RequestMethod.POST)
    public String method(){
        System.out.println("test method!!");
        return "success";
    }

//    @RequestMapping(value = "testParams",params = {"username"},method = RequestMethod.GET)
//    public String testParams(){
//        System.out.println("testParams！！");
//        return "success";
//    }

    @RequestMapping("/*/flq*")
    public String flq(){
        System.out.println("test ant request");
        return "success";
    }

    @RequestMapping("pathVar/{id}")
    public String testPathvar(@PathVariable("id") String id){
        System.out.println(id);
        return "success";
    }

    @RequestMapping(value = "testREST/{id}",method = RequestMethod.GET)
    public String testREST(@PathVariable String id){
        System.out.println("testREST");
        System.out.println(id);
        return "success";
    }

    @RequestMapping(value = "testREST",method = RequestMethod.POST)
    public String testRES1T(){
        System.out.println("testREST");

        return "success";
    }
    @RequestMapping(value = "testREST/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String testRES1Tdelete(@PathVariable String id){
        System.out.println("testRESTdelete" + id);

        return "DELETE SUCCESS";
    }
    @RequestMapping(value = "testREST/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public String testRES1Tput(@PathVariable String id){
        System.out.println("testRESTput" + id);

        return "PUT SUCCESS";
    }

    @RequestMapping(value = "testRequestParam",method = RequestMethod.GET)
    public String testRequestParam(@RequestParam( value = "username",required = false,defaultValue = "fengliqiang") String username,@RequestParam(value = "password",required = false,defaultValue = "123")String password){
        System.out.println(username);
        System.out.println(password);
        return SUCCESS;
    }

    @RequestMapping("testHeader")
    public String testHeader(@RequestHeader(value = "User-Agent") String connection){
        System.out.println(connection);
        return SUCCESS;
    }

    @RequestMapping("testCookieVaule")
    public String testCookieVaule(@CookieValue("_gid") String cookieVaule){
        System.out.println("---------" + cookieVaule);
        return SUCCESS;
    }

    @RequestMapping(value = "testPojo",method = RequestMethod.POST)
    @ResponseBody
    public Person testPojo(@Valid Person person, BindingResult result){

        return person;
    }

    @RequestMapping("/ajaxTestWithJsonp")
    @ResponseBody
    public String ajaxTest(@RequestParam("callback") String callback){
        Person person = new Person(23,"fengliqiang","895005616@qq.com",new Address("sichuan","chengdu"));
        Gson gson = new Gson();
        Map<String ,Object> map = new HashMap<>();
        map.put("perosn",person);

        return callback + "(" + gson.toJson(map) + ")";
    }

    @RequestMapping("testAjax")
    @ResponseBody
    public Person testAjax(){
        return new Person(45,"fengliqiang","895005616@qq.com",new Address("china","beijing"));
    }

    @RequestMapping("testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("request: " + request);
        System.out.println("response: " + response);
        return SUCCESS;
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("person",new Person(1,"fengliqaing","@@89333.com",new Address("cn","bj")));
        mv.setViewName("list");
        return mv;
    }

    @RequestMapping("testMap")
    public String testMap(Map<String , Object> map){
        map.put("names", Arrays.asList("tom","jerry","harry")) ;
        return SUCCESS;
    }

    @RequestMapping("testSessionAttr")
    public String testSessionAttr(Model model){
        model.addAttribute("personse",new Person(2,"flq","@@@@",new Address("cn","北京")));
        return SUCCESS;
    }

    @RequestMapping("testRedirect")
    public String testRedirect(){
        return "redirect:testMap";
    }

    @RequestMapping(value = "testConverter",method = RequestMethod.POST)
    public String testConverter(@RequestParam("date") Date date){
        System.out.println(date);
        return SUCCESS;
    }

    @RequestMapping(value = "testRequestBody",method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String request){
        System.out.println(request);
        return SUCCESS;
    }

    @RequestMapping(value = "testException")
    public String testException(@RequestParam("num") int num){
        System.out.println(10/num);
        return SUCCESS;
    }

    @ExceptionHandler(java.lang.ArithmeticException.class)
    public String handleException(Exception ex){
        System.out.println("------ 出异常了：" + ex);
        return "error";
    }

    @RequestMapping(value = "testAjaxPost" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> testAjaxPost(Integer id,String name,String email,String country,String city){
        Person person = new Person(id,name,email,new Address(country,city));

        System.out.println(person);
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg","数据发送成功");
        return map;
    }

    @RequestMapping(value = "testAjaxDataPost" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String ,String >testAjaxDataPost(@RequestBody Map<String,Object> map){

        System.out.println( "id == " + map.get("id"));
        System.out.println( "name == " + map.get("name"));
        System.out.println( "password == " + map.get("password"));
        Map<String,String> mapResult = new HashMap<>();
        mapResult.put("msg","数据发送解析成功！！");
        return mapResult;
    }


    @RequestMapping("testFileUpload")
    public String testFileUpload(@RequestParam("file")MultipartFile file,@RequestParam("desc")String desc) throws Exception{
        System.out.println("desc : " +  desc);
        System.out.println("OriginalFilename : " + file.getOriginalFilename());
        System.out.println("getInputStream : " + file.getInputStream());
        return SUCCESS;
    }

}
