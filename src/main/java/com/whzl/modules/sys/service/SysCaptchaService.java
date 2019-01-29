package com.whzl.modules.sys.service;

import java.awt.image.BufferedImage;

import com.baomidou.mybatisplus.service.IService;
import com.whzl.modules.sys.entity.SysCaptchaEntity;

/**
 * 验证码
 *
 * @author xuchao
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
public interface SysCaptchaService extends IService<SysCaptchaEntity> {

    /**
     * 获取图片验证码
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码效验
     * @param uuid  uuid
     * @param code  验证码
     * @return  true：成功  false：失败
     */
    boolean validate(String uuid, String code);
}
