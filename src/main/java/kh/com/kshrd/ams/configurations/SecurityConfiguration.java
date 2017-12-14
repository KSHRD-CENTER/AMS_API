package kh.com.kshrd.ams.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Base64Utils;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("RESTAuthenticationEntryPoint")
	private RESTAuthenticationEntryPoint authenticationEntryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("AMSAPIADMIN").password("AMSAPIP@SSWORD").roles("API");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//MAYBE COME FROM SECURITY HOUY DISABLE IT SIN TOV
		// OK SO DISABLE IT MEAN NO NEED HEADER KEY  YES CLOSE SIN TOV OK BYE BYE SAK TEST
		//http.antMatcher("/v1/api/**").authorizeRequests().anyRequest().hasRole("API");
//		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
		//http.authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests().anyRequest().permitAll();
		//http.httpBasic().authenticationEntryPoint(authenticationEntryPoint);
		
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		

	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/webjars/**");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		//Authorization: Basic cmVzdGF1cmFudEFETUlOOnJlc3RhdXJhbnRQQFNTV09SRA==
		System.out.println(Base64Utils.encodeToString("AMSAPIADMIN:AMSAPIP@SSWORD".getBytes()));
		
	}
}
