目录规范<br>
```
projname
    --web.rest
        --DemoResource.java(restAPI强调的核心是资源)
    --service
        --DemoService.java(不建议使用接口，因为大部分方法没有抽象接口的必要）
    --mapper
        --DemoMapper.java(mybatis最简化的使用方法）
    --domain
        --dto
            DemoDto.java（DTO是不同进程间用于数据传递的对象，很适合在controller层使用）
        --entity
            DemoEntity.java（数据库映射对象）
        --pojo
            DemoPojo.java（内部用于表示数据的简单对象）
    --util
        --DemoUtil.java（工具类）
    --config
        --DemoConfiguration.java（配置类）
```
Url接口规范<br>
>   rest是一套互联网软件设计架构：<br>
        http://www.ruanyifeng.com/blog/2011/09/restful.html<br>
>   restfulapi是一套互谅网应用程序api设计标准：<br>
        http://www.ruanyifeng.com/blog/2014/05/restful_api.html<br>
>   请参考极光推送的restapi接口文档理解：<br>
        https://docs.jiguang.cn/jpush/server/push/rest_api_admin_api_v1/<br>

farmfriend接口规范<br>
> 1、遵守restapi设计规范<br>
> 2、url路径路径全部小写，如需分词，请使用-进行分隔，如https://dev.farmfriend.com.cn/usercenter/user-token-relation<br>
> 3、错误码部分：业务相关的错误信息统一收敛到<br>
    ```
        http.code=200
        response.body
        {
            "errno" :xxxx
            "data"  :xxxx
            "errmsg":xxxx
        }
    ```