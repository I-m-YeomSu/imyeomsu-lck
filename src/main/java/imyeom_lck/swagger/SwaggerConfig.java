package imyeom_lck.swagger;


import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi memberControllerApi() {
        // 경로
        String[] paths = {"/members/**"}; 

        // 그룹 만들어서 리턴
        return GroupedOpenApi.builder()
                .group("RestMemberController")
                .pathsToMatch(paths)
                .build();
    }

}
