package com.yueliang.student.springbootueditorsimple;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UeditorController {
    @RequestMapping(value = "/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index.html");
        return modelAndView;
    }
    @RequestMapping(value = "/ueditor.do")
    @ResponseBody
    public String ueditor(HttpServletRequest request)throws Exception{
       String rootPaht = ResourceUtils.getURL("classpath:").getPath();
       //config.js路径
       String jsconfigPaht = rootPaht+"static/";
       String result = new ActionEnter(request,jsconfigPaht).exec();
       return result;
    }
}
