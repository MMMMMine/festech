package com.festech.webapi.config.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    //http://localhost:8100/swagger-ui.html

    /**
     * 使用enableMVC注解的话,该配置必须,否则无法映射资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    @Bean
    public Docket createRestApi() {

        ParameterBuilder signParams = new ParameterBuilder();
//        signParams.name("X-Sign").description("签名").modelRef(new ModelRef("string")).parameterType("header").required(false).build();

        List<Parameter> headerParams = new ArrayList<>();
        headerParams.add(signParams.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("api")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.festech.webapi.controller"))
                .build()
                .globalOperationParameters(headerParams);

    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("frank", "", "1713445978.com");
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("接口文档")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
