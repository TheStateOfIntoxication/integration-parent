package com.example.cloud.pojo.utils;

public enum CardEnum {
    /* 梅花 */
    spade("♧"),
    /* 黑桃 */
    heart("♤"),
    /* 红桃 */
    club("♡"),
    /* 方块 */
    diamonds("♢");
    private String color;

    public String getColor() {
        return color;
    }

    CardEnum(String color) {
        this.color = color;
    }
}
