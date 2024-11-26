package com.afklm.repind.kpipoc.service;

import com.afklm.repind.kpipoc.annotation.Kpi;
import com.afklm.repind.kpipoc.enums.KpiActionEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Activity Service Layer
 */
@Slf4j
@Service
@AllArgsConstructor
public class ActivityService {
    private static final Random RANDOM = new Random();
    private static final List<String> TYPE_LIST = Arrays.asList("I", "W", "T", "E");

    private final KpiService kpiService;

    @Kpi(action = KpiActionEnum.CREATE)
    public void create(String gin, String type, String signature) {
//        kpiService.sendKpi(KpiActionEnum.CREATE, gin, type, signature);
        log.info("create", gin, type, signature);
    }

    @Kpi(action = KpiActionEnum.MERGE)
    public void merge(String gin, String type, String signature) {
//        kpiService.sendKpi(KpiActionEnum.MERGE, gin, type, signature);
        log.info("merge", gin, type, signature);
    }

    @Kpi(action = KpiActionEnum.PURGE)
    public void purge(String gin, String type, String signature) {
//        kpiService.sendKpi(KpiActionEnum.PURGE, gin, type, signature);
        log.info("purge", gin, type, signature);
    }

    public void random() {
        KpiActionEnum[] actions = KpiActionEnum.values();
//        kpiService.sendKpi(actions[RANDOM.nextInt(actions.length)],
        kpiService.sendKpi(KpiActionEnum.PURGE,
                RandomStringUtils.random(10, false, true),
                TYPE_LIST.get(RANDOM.nextInt(TYPE_LIST.size())),
                "Creator" + RandomStringUtils.random(1, false, true));
        kpiService.sendKpi(KpiActionEnum.MERGE,
                RandomStringUtils.random(10, false, true),
                TYPE_LIST.get(RANDOM.nextInt(TYPE_LIST.size())),
                "Creator" + RandomStringUtils.random(1, false, true));
    }

}
