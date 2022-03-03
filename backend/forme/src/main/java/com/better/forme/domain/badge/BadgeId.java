package com.better.forme.domain.badge;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BadgeId implements Serializable {

    private Long userKey;  //@MapsId("userKey") 매핑

    @Column(name = "badge_id")
    private Long badge_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadgeId badgeId = (BadgeId) o;
        return badge_id.equals(badgeId.badge_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(badge_id);
    }
}
