package com.whzl.modules.oss.cloud;


import com.whzl.common.utils.ConfigConstant;
import com.whzl.common.utils.Constant;
import com.whzl.common.utils.SpringContextUtils;
import com.whzl.modules.sys.service.SysConfigService;

/**
 * 文件上传Factory
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
public final class OSSFactory {
    private static SysConfigService sysConfigService;

    static {
        OSSFactory.sysConfigService = (SysConfigService) SpringContextUtils.getBean("sysConfigService");
    }

    public static CloudStorageService build(){
        //获取云存储配置信息
        CloudStorageConfig config = sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

        if(config.getType() == Constant.CloudService.QINIU.getValue()){
            return new QiniuCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            return new AliyunCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
            return new QcloudCloudStorageService(config);
        }

        return null;
    }

}
