package com.better.forme.domain.recipe_record;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Embeddable
public class RecipeRecordId implements Serializable {

    @Column
    private Long recipe_index;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeRecordId recipeRecordId = (RecipeRecordId) o;
        return recipe_index.equals(recipeRecordId.recipe_index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_index);
    }


}
