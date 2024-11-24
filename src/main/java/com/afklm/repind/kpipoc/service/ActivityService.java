package com.afklm.repind.kpipoc.service;

import com.afklm.repind.kpipoc.annotation.Kpi;
import com.afklm.repind.kpipoc.enums.KpiActionEnum;
import com.afklm.repind.kpipoc.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class ActivityService {
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

}
