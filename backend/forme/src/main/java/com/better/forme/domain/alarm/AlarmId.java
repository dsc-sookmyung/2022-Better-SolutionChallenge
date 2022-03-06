package com.better.forme.domain.alarm;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AlarmId implements Serializable {

    private Long userKey;  //@MapsId("userKey") 매핑

    @Column(name = "alarm_id")
    private Long alarm_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlarmId alarmId = (AlarmId) o;
        return alarm_id.equals(alarmId.alarm_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alarm_id);
    }
}
