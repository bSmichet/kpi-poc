package com.afklm.repind.kpipoc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.afklm.repind.kpipoc.repository")
@ComponentScan(basePackages = { "com.afklm.repind.kpipoc" })
@EnableAspectJAutoProxy
public class KpiPocConfig  {
}
