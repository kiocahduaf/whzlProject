
package com.whzl.common.utils;

import java.util.HashMap;


/**
 * Map工具类
 *
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
public class MapUtils extends HashMap<String, Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
