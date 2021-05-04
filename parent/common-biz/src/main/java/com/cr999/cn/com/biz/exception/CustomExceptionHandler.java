package com.cr999.cn.com.biz.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cr999.cn.common.DataResponse;
import com.cr999.cn.common.ResultEnum;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件描述：
 *
 * @version 1.0
 * @author wangqiang
 * @date 2021/4/1 22:23 
 */

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    public void postInit() {
        log.debug("CustomExceptionHandler post init...");
    }

    @ExceptionHandler(value = Exception.class)
    public Object defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        logger.error("服务器异常", e);

        if (e instanceof CustomException) {
            String feignType = request.getHeader("sys-client-type");
            CustomException be = (CustomException) e;
            if ("sys".equals(feignType)) {
                return new DataResponse<>(be.getCode(), be.getMsg(), null);
            } else {
                return new DataResponse<>(be.getCode(), be.getMsg(), null);
            }
        }

        /*if (e.getClass() == FeignServiceException.class) {
            throw e;
        }*/

        if (e instanceof RuntimeException) {
            RuntimeException fe = (RuntimeException) e;
            try {
                JSONObject jsonObject = JSON.parseObject(fe.getMessage());
                if (CustomException.EXCEPTION_ERROR_CODE == jsonObject.getInteger("code")) {
                    DataResponse result = new DataResponse<>(jsonObject.getInteger("code"), jsonObject.getString("message"), null);
                    return ResponseEntity.status(200).body(result);
                } else {
                    throw e;
                }
            } catch (Exception e1) {
                throw e1;
            }
        }
        throw e;

    }



    /**
     * 自定义异常
     */
    @ExceptionHandler(CustomException.class)
    public DataResponse handleCustomException(CustomException e) {
        logger.error("请求异常", e);
        return new DataResponse(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public DataResponse handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        e.printStackTrace();
        logger.error("数据库异常", e);
        return new DataResponse(ResultEnum.DATA_ABNORMAL.getCode(), "数据格式或数据长度不符合规则");
    }
}
