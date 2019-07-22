package com.wolf.javacommon.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: liu lei
 * @Date: 2019/7/22
 */
@Setter
@Getter
@AllArgsConstructor
public class TraceNodeVO {
    private Long firstId;     //第一层结点
    private Long secondId;//第二层结点
    private Long thirdId; //第三层结点
    private Long forthId; //第四层结点
}
