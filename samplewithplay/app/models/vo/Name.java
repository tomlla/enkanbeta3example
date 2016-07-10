package models.vo;

import javax.persistence.*;

import base.domain.model.shared.*;
import lombok.*;
import lombok.Value;
import lombok.experimental.*;

@Value
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class Name extends ValueObject<Name> {
    
    @Column(name = "name", length = 255)
    private final String value;
    
    public static Name factory(final String name) {
        return null;
    }
}
