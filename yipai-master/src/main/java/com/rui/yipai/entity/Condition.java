package com.rui.yipai.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Condition {
    private int c1;
    private int c2;
    private byte state;
    private String createTime;
}
