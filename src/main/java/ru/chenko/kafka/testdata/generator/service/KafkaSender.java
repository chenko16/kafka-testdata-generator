package ru.chenko.kafka.testdata.generator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.chenko.kafka.testdata.generator.dto.TestDataDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class KafkaSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

    @Value("${kafka.topic}")
    private String jsonTopic;

    @Autowired
    private KafkaTemplate<String, TestDataDto> kafkaTemplate;

    public void send(TestDataDto testDataDto) {
        LOGGER.info("sending testDataDto='{}'", testDataDto.toString());
        kafkaTemplate.send(jsonTopic, testDataDto);
    }
}
