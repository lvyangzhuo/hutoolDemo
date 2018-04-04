package com.okhttp.okhttpdemo;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author Lyz
 * @time 2018-4-3 16:41
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    public Map demo(){
        String result2 = HttpRequest.get("http://open.api.tianyancha.com/services/v4/open/baseinfo?id=22822&name=北京百度网讯科技有限公司")
                .header("Authorization", "0f046838-fd81-4294-8f90-aff043f176a4")
                .execute().body();
        Map map = (Map)JSONUtil.parseObj(result2);
        System.out.println(map.get("error_code"));
        if((Integer)map.get("error_code")==0){
            Map businessMap = (Map)map.get("result");
            return businessMap;
        }
        return null;
    }
}
