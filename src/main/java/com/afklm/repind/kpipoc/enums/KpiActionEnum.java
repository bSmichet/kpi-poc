package com.afklm.repind.kpipoc.enums;

import lombok.Getter;

/**
 * KPI Actions Enumeration
 */
@Getter
public enum KpiActionEnum {
    CREATE("create"), PURGE("purge"), MERGE("merge");

    private String value;

    KpiActionEnum(String value) {
        this.value = value;
    }
}
