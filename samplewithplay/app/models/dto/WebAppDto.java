package models.dto;

import lombok.*;

/**
 * 新規作成,変更の両用DTOとして作成(<-experimental)
 * 新規作成APIに使う場合はLong this.id=null
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class WebAppDto {
    public Long id;
    public final String name;
    public String vcsUrl;
}
