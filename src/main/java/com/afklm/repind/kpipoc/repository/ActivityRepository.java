package com.afklm.repind.kpipoc.repository;

import com.afklm.repind.kpipoc.model.Activity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ActivityRepository extends ElasticsearchRepository<Activity, String> {
}
