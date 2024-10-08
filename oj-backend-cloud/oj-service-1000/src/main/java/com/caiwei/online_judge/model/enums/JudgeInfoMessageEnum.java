package com.caiwei.online_judge.model.enums;

import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 判题信息枚举
 */
@Getter
public enum JudgeInfoMessageEnum {


    ACCEPT("accepte", "成功"),
    WRONG_ANSWER("wrong_answer", "答案错误"),
    COMPILE_ERROR("compile_error", "编译错误"),
    MEMORY_LIMIT_EXCEEDED("memory_limit_exceeded", "内存溢出"),
    TIME_LIMIT_EXCEEDED("time_limit_exceeded", "超时"),
    PRESENTATION_ERROR("presentation_error", "展示错误"),
    WAITING("waiting", "等待中"),
    OUTPUT_LIMIT_EXCEEDED("output_limit_exceeded", "输出溢出"),
    DANGEROUS_OPERATION("dangerous_operation", "危险操作"),
    RUNTIME_ERROR("runtime_error", "运行错误"),
    SYSTEM_ERROR("system_error", "系统错误");


    private final String text;

    private final String value;

    JudgeInfoMessageEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static JudgeInfoMessageEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoMessageEnum anEnum : JudgeInfoMessageEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

}
