package ru.chenko.kafka.testdata.generator.dto;

import java.util.Date;

public class TestDataDto {

    private Long id;

    private Date time;

    private Float value;

    public TestDataDto() {}

    public TestDataDto(Long id,Date time, Float value) {
        this.id = id;
        this.time = time;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TestDataDto [id=" + id + ", time=" + time + ", value=" + value + "]";
    }
}
