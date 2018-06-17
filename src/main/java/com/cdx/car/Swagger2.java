package com.cdx.car;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhuyubin
 * Date: 2017/12/14 0014
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.binger.goods"))
//                .paths(PathSelectors.any())
//                .build();
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("小车位置")
                .description("")
                .termsOfServiceUrl("")
                .contact("cgd")
                .version("1.0")
                .build();
    }
//
//    @Bean
//    SecurityConfiguration security() {
//        return new SecurityConfiguration(
//                null,
//                null,
//                null, // realm Needed for authenticate button to work
//                null, // appName Needed for authenticate button to work
//                "Bearer",// apiKeyValue
//                ApiKeyVehicle.HEADER,
//                "Authorization", //apiKeyName
//                null);
//    }
//
//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope
//                = new AuthorizationScope("openid", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Lists.newArrayList(
//                new SecurityReference("AUTHORIZATION", authorizationScopes));
//    }

}