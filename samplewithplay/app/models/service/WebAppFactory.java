package models.service;

import java.util.*;

import lombok.*;
import models.dto.*;
import models.entity.*;
import models.vo.*;
import play.libs.F.*;
import toprockgeneral.datastruct.*;

public class WebAppFactory {
    
    public static Either<WebApp, ErrorMessages> create(final WebAppDto createApiDto) {
        // validation,
        final Optional<ErrorMessages> err = validateForCreate(createApiDto);
        if (err.isPresent()) {
            return Either._2(err.get());
        }
        
        final Name name = Name.factory(createApiDto.name);
        final VcsUrl vcsUrl = new VcsUrl(createApiDto.vcsUrl);
        final WebApp webApp = new WebApp(name, vcsUrl);
        webApp.save();
        return Either._1(webApp);
    }
    
    public static Optional<ErrorMessages> validateForCreate(final WebAppDto createApiDto) {
        val errors = new ErrorMessages();
        val name = createApiDto.name;
        if (name == null || name.length() == 0) {
            errors.add("name", "空欄です。入力してください", "名前");
        }
        return Optional.empty();
    }
}
