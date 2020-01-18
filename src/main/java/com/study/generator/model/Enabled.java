package com.study.generator.model;

/**
 * @author cao.mingyu
 */

public enum Enabled {
    /**
     * 禁用
     */
    DISABLED(1),
    /**
     * 启用
     */
    ENABLED(0);

    private final int value;

    private Enabled(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
