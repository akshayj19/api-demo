package jp.co.axa.apidemo.controllers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/basic45error45controller"), regex("/api/v1.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("AXA Life")
				.description("AXA Life coding challange for Java/Node.js Developers")
				.termsOfServiceUrl("http://akshayj19@gmail.com")
				.contact("Akshay Jain").build();
	}

}