package com.uwjx.components.commons.util;

import com.uwjx.components.commons.constant.HttpConstant;
import com.uwjx.components.commons.vo.DataVO;

/**
 * @author SalleyGardens
 */
public class ResponseUtil {

    public static DataVO<Object> success(){
        return new DataVO<>(HttpConstant.SUCCESS_CODE , HttpConstant.SUCCESS_MESSAGE);
    }

    public static DataVO<Object> success(Object data){
        return new DataVO<>(HttpConstant.SUCCESS_CODE , HttpConstant.SUCCESS_MESSAGE , data);
    }
}
