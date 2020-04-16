package ga.hunterdo.barcodeparking.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import ga.hunterdo.barcodeparking.service.UserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailService userDetailService;

	@Autowired
	private DataSource dataSource;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http
			.authorizeRequests()
				.antMatchers("/login", "/logout", "/forgot-password", "/active").permitAll()	 // Các trang không yêu cầu login
				.antMatchers("/", "/profile").access("hasAnyRole('ROLE_SUPER', 'ROLE_ADMIN', 'ROLE_TENANT')")
				.antMatchers("/list-order", "/list-code", "/export-code").access("hasAnyRole('ROLE_SUPER', 'ROLE_ADMIN', 'ROLE_TENANT')")
				.antMatchers("/manage-code").access("hasAnyRole('ROLE_SUPER', 'ROLE_ADMIN')")
				.and()
			// Cấu hình cho Login page
			.formLogin()
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/")
				.failureUrl("/login?error")
				.and()
			// Cấu hình cho Logout page
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.and()
			// Cấu hình Remember Me
			.rememberMe()
				.tokenRepository(this.persistentTokenRepository("InMemoryToken"))
				.tokenValiditySeconds(1 * 24 * 60 * 60)	// 24h
				.and()
			// Khi người dùng đã login, với vai trò XX, nhưng truy cập vào trang yêu cầu vai trò YY,
			// ngoại lệ AccessDeniedException sẽ ném ra.
			.exceptionHandling()
				.accessDeniedPage("/403");
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository(String typeToken) {
		if (typeToken.equals("JdbcToken")) {
			// Token stored in Table (Persistent_Logins)
			JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
			db.setDataSource(this.dataSource);

			return db;
		} else
			// Token stored in Memory (Of Web Server)
			return new InMemoryTokenRepositoryImpl();
	}
}