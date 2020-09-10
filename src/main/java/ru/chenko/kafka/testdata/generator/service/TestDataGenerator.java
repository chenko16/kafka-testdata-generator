package ru.chenko.kafka.testdata.generator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.chenko.kafka.testdata.generator.dto.TestDataDto;

import java.util.Date;

@EnableScheduling
@Service
public class TestDataGenerator {

    @Autowired
    private KafkaSender kafkaSender;

    private Long messageId = 0L;

    @Scheduled(fixedRate = 60 * 1000)
    public void generateAndSentTestData() {
        Long id = ++messageId;
        Date time = new Date();
        Float value = (float) Math.random() * 100;

        TestDataDto testDataDto = new TestDataDto(id, time, value);
        kafkaSender.send(testDataDto);
    }
}
