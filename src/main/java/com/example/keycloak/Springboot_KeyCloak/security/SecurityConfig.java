package com.example.keycloak.Springboot_KeyCloak.security;

import java.io.IOException;

//import org.keycloak.adapters.authorization.integration.jakarta.ServletPolicyEnforcerFilter;
//import org.keycloak.adapters.authorization.spi.ConfigurationResolver;
//import org.keycloak.adapters.authorization.spi.HttpRequest;
//import org.keycloak.representations.adapters.config.PolicyEnforcerConfig;
//import org.keycloak.util.JsonSerialization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http.csrf(t -> t.disable());
        http.authorizeHttpRequests(authorize -> {
            authorize.anyRequest().authenticated();
        });
        //Có 2 cách để oauth với keycloak
        //Cách 1 sử dụng jwwt để đocker token lấy được
        //Khi token được gửi tới thì jwt sẽ check token đó nếu hợp lệ thì nó sẽ
        //trả luôn ra response mà ko cầ ncheck lại validate với keycloak
        //=> kể cả đã logout nhưng vẫn có thể dùng token cũ để lấy response
//        http.oauth2ResourceServer(t -> {
//            t.jwt(Customizer.withDefaults());
//        });
        //Cách 2: Sử dụng opaqueToken
		// cách này sau khi lấy đc token thì sẽ gửi lại lên keycloak để check rồi
		//khi kết quả trr về là accept thì mới trả ra kết quả
        http.oauth2ResourceServer(t -> {
            t.opaqueToken(Customizer.withDefaults());
        });
        http.sessionManagement(
                t -> t.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        return http.build();
    }

//	private ServletPolicyEnforcerFilter createPolicyEnforcerFilter() {
//		return new ServletPolicyEnforcerFilter(new ConfigurationResolver() {
//			@Override
//			public PolicyEnforcerConfig resolve(HttpRequest request) {
//				try {
//					return JsonSerialization.
//							readValue(getClass().getResourceAsStream("/policy-enforcer.json"),
//									PolicyEnforcerConfig.class);
//				} catch (IOException e) {
//					throw new RuntimeException(e);
//				}
//			}
//		});
//	}

}
