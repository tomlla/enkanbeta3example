package models.vo;

import base.domain.model.shared.*;
import lombok.*;
import lombok.Value;
import lombok.experimental.*;

@Value
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class VcsUrl extends ValueObject<VcsUrl> {
    private final String value;
}
