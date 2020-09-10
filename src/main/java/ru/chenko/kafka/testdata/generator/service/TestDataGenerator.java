package ru.chenko.kafka.testdata.generator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chenko.kafka.testdata.generator.dto.TestDataDto;

import java.util.Date;

@Service
public class TestDataGenerator {

    @Autowired
    private KafkaSender kafkaSender;

    public void generateAndSentTestData(Long messageId) {
        Long id = messageId;
        Date time = new Date();
        Float value = (float) Math.random() * 100;

        TestDataDto testDataDto = new TestDataDto(id, time, value);
        kafkaSender.send(testDataDto);
    }
}
