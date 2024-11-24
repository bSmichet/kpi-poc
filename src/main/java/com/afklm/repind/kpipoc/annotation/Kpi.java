package com.afklm.repind.kpipoc.annotation;

import com.afklm.repind.kpipoc.enums.KpiActionEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Kpi {
    KpiActionEnum action() default KpiActionEnum.CREATE;
}
