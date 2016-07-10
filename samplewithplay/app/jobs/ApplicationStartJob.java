package jobs;

import lombok.*;
import models.dto.*;
import models.entity.*;
import models.service.*;
import play.jobs.*;
import play.libs.F.*;
import toprockgeneral.datastruct.*;

@OnApplicationStart
public class ApplicationStartJob extends Job<ApplicationStartJob> {
    
    @Override
    public void doJob() {
        createTestDate();
    }
    
    private static void createTestDate() {
        val dto = WebAppDto.builder()
                           .name("しゃないChatTool")
                           .vcsUrl("https://github.com/solitonimc/shanaiChatTool.git")
                           .build();
        final Either<WebApp, ErrorMessages> r = WebAppFactory.create(dto);
        for (val error : r._2) {
            throw new RuntimeException(r.toString());
        }
    }
}
