package com.cr999.cn.common;

/**
 * 文件描述
 *
 * @author wangqiang
 * @date 2020年08月24日 17:10
 */
public enum ResultEnum {
    SUCCESS(200,"成功"),
    REPEAT_SUBMIT(556,"您操作太频繁，请稍后再试！"),
    ERROR(500200,"操作失败"),
    PARAMETER_EMPTY_ERROR(500100,"参数不能为空"),
    DELETE_DATA_ERROR(500101,"删除数据失败"),
    UPDATE_DATA_ERROR(500103,"修改数据失败"),
    ADD_DATA_ERROR(500117,"添加数据失败"),
    DATA_EXIST(500104,"数据已存在"),
    DATA_NOT_EXIST(500105,"数据不存在"),
    PARAMETER_CHECKOUT_ERROR(500106, "参数校验异常：%s"),
    STOP_STATE(500107,"已停用"),
    DATA_ABNORMAL(500110,"数据异常");

    private Integer code;
    private String msg;


    private ResultEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

}
