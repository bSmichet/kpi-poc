package com.afklm.repind.kpipoc.service;

import com.afklm.repind.kpipoc.enums.KpiActionEnum;
import com.afklm.repind.kpipoc.model.Activity;
import com.afklm.repind.kpipoc.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class KpiService {
    private final ActivityRepository activityRepository;

    public void sendKpi(KpiActionEnum kpiActionEnum, String gin, String type, String creator) {
        // Create Activity and save it
        Activity activity = new Activity();
        activity.setAction(kpiActionEnum.getValue());
        activity.setGin(gin);
        activity.setType(type);
        activity.setCreator(creator);
        activity.setDate(new Date());
        activityRepository.save(activity);
    }
}
