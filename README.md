### springboot-ueditor-simple

使用步骤如下:

   第一步 添加ueditor-repo maven引用
     
     <repositories>
             <repository>
                 <id>ueditor-repo</id>
                 <url>https://raw.github.com/lyueliang/ueditor-repo/master</url>
                 <snapshots>
                     <enabled>true</enabled>
                     <updatePolicy>always</updatePolicy>
                 </snapshots>
             </repository>
     </repositories>
     
     <dependencies>
            <dependency>
                 <groupId>com.yueliang.thirdparty</groupId>
                 <artifactId>ueditor-repo</artifactId>
                 <version>1.0.0</version>
            </dependency>
     <dependencies>
   
   第二步 添加ueditor js文件到项目中  
   
   第三步 修改ueditor.config 配置服务器上传路径
        
        window.UEDITOR_CONFIG = {
        
                //为编辑器实例添加一个路径，这个不能被注释
                UEDITOR_HOME_URL: URL
        
                // 服务器统一请求接口路径
                , serverUrl: "/ueditor.do"
                
   第四步 调用ActioinEnter类
            
      @RequestMapping(value = "/ueditor.do")
      @ResponseBody
      public String ueditor(HttpServletRequest request)throws Exception{
         String rootPaht = ResourceUtils.getURL("classpath:").getPath();
         //config.js路径
         String jsconfigPaht = rootPaht+"static/";
         String result = new ActionEnter(request,jsconfigPaht).exec();
         return result;
      }
   
   
   第五步 未上传数据错误
        
        spring.servlet.multipart.enabled=false
        
   联系方式
    
        Email:person_lyl@163.com