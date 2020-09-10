package ru.chenko.kafka.testdata.generator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@EnableScheduling
@Service
public class GenerateScheduler {

    @Autowired
    private TestDataGenerator testDataGenerator;

    private static final Integer GROUP_COUNT = 2;

    @Scheduled(fixedRate = 60 * 1000)
    public void generateDateForFirstGroup() {
        for(Long groupId = 1L; groupId <= GROUP_COUNT; groupId++) {
            testDataGenerator.generateAndSentTestData(groupId);
        }

    }
}
