package com.better.forme.domain.character;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TomatoCharacterId implements Serializable {

    private Long userKey;  //@MapsId("userKey") 매핑

    @Column(name = "tomato_id")
    private Long tomato_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TomatoCharacterId tomatoId = (TomatoCharacterId) o;
        return tomato_id.equals(tomatoId.tomato_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tomato_id);
    }
}
