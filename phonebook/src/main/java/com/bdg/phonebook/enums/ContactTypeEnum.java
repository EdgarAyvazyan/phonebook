package com.bdg.phonebook.enums;

import java.util.HashMap;
import java.util.Map;

public enum ContactTypeEnum {

    MOBILE(1, "Բջջային"),
    HOME(2, "Տան"),
    WORK(3, "Աշխատանքային");

    private static final Map<Integer, ContactTypeEnum> codeMap = new HashMap<>();

    static {
        for (ContactTypeEnum s : ContactTypeEnum.values()) {
            codeMap.put(s.getCode(), s);
        }
    }

    private int code;
    private String name;

    ContactTypeEnum(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static ContactTypeEnum getById(int id) {
        return codeMap.get(id);
    }
}
