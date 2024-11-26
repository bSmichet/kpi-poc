package com.afklm.repind.kpipoc.controller;

import com.afklm.repind.kpipoc.dto.ActivityDTO;
import com.afklm.repind.kpipoc.service.ActivityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Activity Controller REST endpoints layer
 */
@Slf4j
@RestController
@AllArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    /**
     * Create KPI endpoint
     *
     * @param activityDTO activity data
     */
    @PostMapping("/create")
    public void create(@Valid @RequestBody ActivityDTO activityDTO) {
        log.info("ActivityController create", activityDTO);
        activityService.create(activityDTO.getGin(), activityDTO.getType(), activityDTO.getSignature());
    }

    /**
     * Merge KPI endpoint
     *
     * @param activityDTO activity data
     */
    @PostMapping("/merge")
    public void merge(@Valid @RequestBody ActivityDTO activityDTO) {
        log.info("ActivityController merge", activityDTO);
        activityService.merge(activityDTO.getGin(), activityDTO.getType(), activityDTO.getSignature());
    }

    /**
     * Purge KPI endpoint
     *
     * @param activityDTO activity data
     */
    @PostMapping("/purge")
    public void purge(@Valid @RequestBody ActivityDTO activityDTO) {
        log.info("ActivityController purge", activityDTO);
        activityService.purge(activityDTO.getGin(), activityDTO.getType(), activityDTO.getSignature());
    }

    /**
     * Create KPI endpoint : random actions and values
     */
    @GetMapping("/random")
    public void random() {
        log.info("ActivityController random");
        activityService.random();
    }
}
