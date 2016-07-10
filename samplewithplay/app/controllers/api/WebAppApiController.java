package controllers.api;

import java.util.*;

import models.dto.*;
import models.entity.*;
import play.mvc.*;

public class WebAppApiController extends Controller {
    public static void index() {
        final List<WebApp> founds = WebApp.findAll();
        final List<WebAppDto> webAppDtoList = WebApp.toDtoList(founds);
        renderJSON(webAppDtoList);
    }
    
    public static void show(final long id) {
        final WebApp webapp = WebApp.findById(id);
        renderJSON(webapp);
    }
    
    public static void create() {}
    
    public static void update() {}
    
    public static void delete() {}
}
