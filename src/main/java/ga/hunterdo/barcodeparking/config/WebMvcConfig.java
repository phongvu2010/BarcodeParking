package ga.hunterdo.barcodeparking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Access Bootstrap static resource:
		registry.addResourceHandler("css/**").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("fonts/**").addResourceLocations("classpath:/static/fonts/");
		registry.addResourceHandler("images/**").addResourceLocations("classpath:/static/images/");
		registry.addResourceHandler("js/**").addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("vendors/**").addResourceLocations("classpath:/static/vendors/");
	}
}