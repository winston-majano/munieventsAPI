package com.munievents.munievents;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;


import java.util.List;
import java.util.Properties;

@Configuration

public class SwaggerConfig implements ApplicationListener<ApplicationPreparedEvent> {
    @Override
    public void onApplicationEvent(final ApplicationPreparedEvent event) {
        ConfigurableEnvironment environment = event.getApplicationContext().getEnvironment();
        Properties props = new Properties();
        props.put("springdoc.swagger-ui.path", swaggerPath());
        environment.getPropertySources()
                .addFirst(new PropertiesPropertySource("programmatically", props));
    }

    @Bean
    public OpenAPI openAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Munievents");

        Contact myContact = new Contact();
        myContact.setName("Munievents Dev Team");
        myContact.setEmail("support.munievents@gmail.com");

        Info information = new Info()
                .title("Munievents Management System API")
                .version("1.0")
                .description("This API exposes endpoints to manage events.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }


    private String swaggerPath() {
        return "/munievents"; // TODO: implement your logic here.
    }

}
