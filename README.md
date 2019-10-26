## 博客交流
来源于码匠
  主要功能如下：
    1.登录页面，包含授权登录
        1.1流程
        github授权登录:https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/
        在登录时调用：
            <li><a href="https://github.com/login/oauth/authorize?client_id=7ca29fa415327edbec6c&redirect_uri=http://localhost:8081/callback&scope=user&state=1">登录</a></li>
        1.2 github返回一个code所以需要用这个code进行验证获取token
            使用OkHttp进行请求 https://square.github.io/okhttp/

                    RequestBody body = RequestBody.create(MEDIA_TYPE, JSON.toJSONString(dto));
                    OkHttpClient client =new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://github.com/login/oauth/access_token")
                            .post(body)
                            .build();
                    try (Response response = client.newCall(request).execute()) {
                        String string=response.body().string();
                        String token =string.split("&")[0].split("=")[1];
                        return token;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                   ///通过token 获取user信息
                   OkHttpClient client = new OkHttpClient();
                   Request request = new Request.Builder()
                           .url("https://api.github.com/user?access_token="+accessToken)
                           .build();
                    
                   try {
                       Response response = client.newCall(request).execute();
                       String json= response.body().string();
                       System.out.println(json);
                       GithubUser githubUser = JSON.parseObject(json, GithubUser.class);
                       return githubUser;
                   }catch (IOException e){
                       e.printStackTrace();
                   }
                   return null;
                  
    
   2.
###git命令
在git上进行初始化项目人通过以下命令报项目进行传输到本地
    创建Readme文档
echo "# spring-boot-community" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/kaysanshi/spring-boot-community.git
git push -u origin master
### springboot
### thymeleaf用法
    thymeleaf的常用属性：
    th:action
    th:each
    th:href
    th:id
    th:if
    th:unless
    th:switch/th:case
    th:object
    th:src
    th:text
    th:value
    th:attr
    th:onclick
    th:style
    th:method
    th:name
    th:inline
    这些标记大多数和html的标记名称是一样的。
    
    thymeleaf表达式基本对象
    模板引擎提供了一组内置的对象，这些内置的对象可以直接在模板中使用，这些对象由#号开始引用。
    
    #request
    相当于HttpServletRequest对象，这是3.x版本，若是2.x版本使用#httpServletRequest
    ${#request.getContextPath()}
    ${#request.getAttribute("name")}
    
    #session
    相当于HttpSession
    对象，这是3.x版本，若是2.x版本使用#httpSession，需要在后头controller中设置session，
    ${#session.getAttribute("phone")}
    ${#session.id}
    
    thymeleaf表达式功能对象
    1.模板引擎提供的一组功能性内置对象，可以在模板中直接使用这些对象提供的功能方法。
    2.工作中常使用的数据类型，如集合、时间、数值，可以使用thymeleaf提供的功能性对象来处理它们。
    3.内置功能对象前都需要加#号，内置对象一般都以s结尾。
    
    #dates：java.util.Date对象的实用方法，<span th:text="${#dates.format(curDate,'yyyy-MM-dd HH:mm:ss')}"></span>
    #calendars：和dates类似，但是是java.util.Calendar对象。
    #numbers：格式化数据对象的实用方法。
    #strings：字符串对象的实用方法。contains,startsWith,prepending/appending等。
    #objects：对objects操作的实用方法。
    #bools：对布尔值求值的实用方法。
    #arrays：数组的实用方法。
    #lists：list的实用方法.
    #sets：set的实用方法.
    #maps：map的实用方法
    #aggregates：对数组或集合创建聚合的实用方法。
    还有条件表达式等等，更多内容可以参考thymeleaf的官网：http://www.thymeleaf.org
    
    thymeleaf th:text 不显示标签
    解决办法，通过追加th:remove属性，演示如下：
    
    <span th:text="${title}" th:remove="tag"></span>
### mysql
### bootstrap

### Flyway Migration
     
 #### flyway简介
      Flyway是独立于数据库的应用、管理并跟踪数据库变更的数据库版本管理工具。用通俗的话讲，
      Flyway可以像SVN管理不同人的代码那样，管理不同人的sql脚本，从而做到数据库同步。 
        1、不仅支持sql 脚本，还支持Java 代码直接操作数据库（flyway-core-x.x.x.jar）；
        2、有Maven 插件；
        3、支持命令行；
        4、与Spring 框结合，很方便地实现应用启动时自动检查并升级数据库的功能。
      命名规范：
         V+版本号(版本号的数字间以"."或"_"分隔开)+双下划线(用来分隔版本号和描述)+文件描述+后缀名，例如：V2017.9.30__Update.sql。
      flyway默认的读取的SQl的位置
         项目的源文件夹下的db/migration目录。
      指令：
         一共就6个基本指令：migrate、clean、info、validate、baseline、repair。   
 #### flyway使用
     <!-- flyway -->
             <dependency>
                 <groupId>org.flywaydb</groupId>
                 <artifactId>flyway-core</artifactId>
                 <version>4.2.0</version>
             </dependency>
    在src/main/resources目录下建立存放sql版本文件的路径dataBase/sqlite（也可以写默认路径db/migration），
    并将sql文件放在下面。
### lombok使用
    
### editmd使用
    application.properties加入
    spring.servlet.multipart.max-file-size=128MB
    spring.servlet.multipart.max-request-size=108MB
    upload.path.product.img=F:/home/ubuntu/upload/community/
    加入editormd的文件
    <div class="form-group" id="question-editor">
                        <label for="description">问题补充 (必填，请参照右侧提示):</label>
                        <textarea name="description" id="description" th:text="${description}" style="display:none;"
                                  class="form-control"
                                  cols="40"
                                  rows="20"></textarea>
                    </div>
                    <script type="text/javascript">
                        $(function () {
                            var editor = editormd("question-editor", {
                                width: "100%",
                                height: 450,
                                path: "../static/js/lib/",
                                delay: 0,
                                watch: false,
                                emoji: true,
                                saveHTMLToTextarea:true,
                                placeholder: "请输入问题描述",
                                imageUpload: true,
                                imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                                imageUploadURL: "/file/upload"
                                // /*上传图片成功后可以做一些自己的处理*/
                                // onload: function () {
                                //     console.log('onload', this);
                                //     this.fullscreen();
                                //     this.unwatch();
                                //     this.watch().fullscreen();
                                //     this.width("100%");
                                //     this.height(480);
                                //     this.resize("100%", 640);
                                // },
    
                            });
                        });
                    </script>
          这里后台必须返回的格式为json数据
          @RequestParam(value = "editormd-image-file", required = false) MultipartFile multipartFile
          返回数据的格式：
                 1,0必须是数字不可以是字符，
                 map.put("success", 1); //这里必须是数字返回否则不会回显(字符不能解析前台)
                 map.put("message", "上传成功");
                 map.put("url", "http://localhost:" + port + "/pimg/" + newFileName);
              失败时：
                map.put("success", 0);
                map.put("message", "上传失败");
                map.put("url", "");
### idea命令使用
    1.使用alt+鼠标左键进行选择下拉一列
    2.