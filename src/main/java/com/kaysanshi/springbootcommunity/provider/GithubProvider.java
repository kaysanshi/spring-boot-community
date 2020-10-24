package com.kaysanshi.springbootcommunity.provider;

import com.alibaba.fastjson.JSON;
import com.kaysanshi.springbootcommunity.dto.AccessTokenDTO;
import com.kaysanshi.springbootcommunity.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author kay三石
 * @date:2019/10/6
 * @Component :仅仅的初始化为bean
 */
@Component
public class GithubProvider {
    public static final MediaType MEDIA_TYPE
            = MediaType.get("application/json; charset=utf-8");
    /**
     * 获取 access_token
     * @param dto
     * @return
     */
    public String getAccessToken(AccessTokenDTO dto){
        System.out.println("dto:"+dto.toString());
        RequestBody body = RequestBody.create(MEDIA_TYPE, JSON.toJSONString(dto));
        OkHttpClient client =new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string_json=response.body().string();
            String token =string_json.split("&")[0].split("=")[1];
            System.out.println("token:"+ token);
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取user信息
     * @param accessToken
     * @return
     */
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String json= response.body().string();
            System.out.println(json);
            GithubUser githubUser = JSON.parseObject(json, GithubUser.class);
//            System.out.println(githubUser.toString());
            return githubUser;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
