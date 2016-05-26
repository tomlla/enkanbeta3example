package enkanexample;

import enkan.Env;
import enkan.collection.OptionMap;
import enkan.config.EnkanSystemFactory;
import enkan.system.EnkanSystem;
import enkan.component.ApplicationComponent;
import enkan.component.doma2.DomaProvider;
import enkan.component.jackson.JacksonBeansConverter;
import enkan.component.flyway.FlywayMigration;
import enkan.component.hikaricp.HikariCPComponent;
import enkan.component.freemarker.FreemarkerTemplateEngine;
import enkan.component.undertow.UndertowComponent;
import static enkan.component.ComponentRelationship.component;
import static enkan.util.BeanBuilder.builder;

/**
 * @author kawasima
 */
public class MyExampleSystemFactory implements EnkanSystemFactory {
    @Override
    public EnkanSystem create() {
        return EnkanSystem.of(
                "doma", new DomaProvider(),
                "jackson", new JacksonBeansConverter(),
                "flyway", new FlywayMigration(),
                "template", new FreemarkerTemplateEngine(),
                "datasource", new HikariCPComponent(OptionMap.of("uri", "jdbc:h2:mem:test")),
                "app", new ApplicationComponent("enkanexample.MyApplicationFactory"),
                "http", builder(new UndertowComponent())
                        .set(UndertowComponent::setPort, Env.getInt("PORT", 3000))
                        .build()
        ).relationships(
                component("http").using("app"),
                component("app").using("datasource", "template", "doma", "jackson"),
                component("doma").using("datasource", "flyway"),
                component("flyway").using("datasource")
        );

    }

}
