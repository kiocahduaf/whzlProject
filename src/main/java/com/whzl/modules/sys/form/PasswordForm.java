package com.whzl.modules.sys.form;

/**
 * 密码表单
 *
 * @author xuchao
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
public class PasswordForm {
    /**
     * 原密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
