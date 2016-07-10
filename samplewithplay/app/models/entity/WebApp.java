package models.entity;

import static java.util.stream.Collectors.*;

import java.util.*;

import lombok.*;
import lombok.experimental.*;
import models.dto.*;
import models.vo.*;
import play.modules.ddd.entity.*;

@Getter
@Accessors(fluent = true)
@javax.persistence.Entity(name = "webapp")
public class WebApp extends AbstractEntity<WebApp> {
    
    /** 必須だけど変更可能なフィールドなのでfinalは付けられない */
    @Setter
    private Name name;
    
    @Setter
    private VcsUrl vcsUrl;
    
    // call only WebAppFactory
    public WebApp(final Name name, final VcsUrl vcsUrl) {
        this.name = name;
        this.vcsUrl = vcsUrl;
    }
    
    @Override
    public void isSatisfied() {}
    
    public static List<WebAppDto> toDtoList(@NonNull final List<WebApp> webApps) {
        return webApps.stream().map(WebApp::toDto).collect(toList());
    }
    
    public WebAppDto toDto() {
        return WebAppDto.builder().name(this.name.value()).vcsUrl(this.vcsUrl.value()).build();
    }
}
