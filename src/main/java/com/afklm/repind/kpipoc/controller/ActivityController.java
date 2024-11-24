package com.afklm.repind.kpipoc.controller;

import com.afklm.repind.kpipoc.dto.ActivityDTO;
import com.afklm.repind.kpipoc.service.ActivityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/create")
    public void create(@Valid @RequestBody ActivityDTO activityDTO) {
        log.info("ActivityController create", activityDTO);
        activityService.create(activityDTO.getGin(), activityDTO.getType(), activityDTO.getSignature());
    }

    @PostMapping("/merge")
    public void merge(@Valid @RequestBody ActivityDTO activityDTO) {
        log.info("ActivityController merge", activityDTO);
        activityService.merge(activityDTO.getGin(), activityDTO.getType(), activityDTO.getSignature());
    }

    @PostMapping("/purge")
    public void purge(@Valid @RequestBody ActivityDTO activityDTO) {
        log.info("ActivityController purge", activityDTO);
        activityService.purge(activityDTO.getGin(), activityDTO.getType(), activityDTO.getSignature());
    }

}
