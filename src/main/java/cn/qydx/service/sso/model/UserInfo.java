package cn.qydx.service.sso.model;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType
public class UserInfo {

    private String usrname;

    private String passwd;

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
