package com.rj.enump;

/**
 * @author ruanjin
 * @since 2019/5/20 16:10
 */
public enum  ToolEnum {
    TOOL_ONE("one"),
    TOOL_TWO("two"),
    TOOL_THREE("three");

    private String name;

    ToolEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
