package me.zhyd.oauth.model;

import lombok.*;
import me.zhyd.oauth.enums.AuthResponseStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * JustAuth统一授权响应类
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @since 1.8
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse<T> implements Serializable {
    /**
     * 授权响应状态码
     */
    private int code;

    /**
     * 授权响应信息
     */
    private String msg;

    /**
     * 授权响应数据，当且仅当 code = 2000 时返回
     */
    private T data;

    private Map<String,Object> ext = new HashMap<>();

    public void putExt(String k,Object v){
        if(this.ext == null) {
            ext = new HashMap<>();
        }
        ext.put(k,v);
    }
    public Object getExt(String k){
        if(this.ext == null) {
            return null;
        }
        return ext.get(k);
    }
    /**
     * 是否请求成功
     *
     * @return true or false
     */
    public boolean ok() {
        return this.code == AuthResponseStatus.SUCCESS.getCode();
    }
}
