package com.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableWebSecurity
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Value("${custom.security.oauth2.client.accessTokenUri}") String accessTokenUri;
    @Value("${custom.security.oauth2.client.clientId}") String clientId;
    @Value("${custom.security.oauth2.client.clientSecret}") String clientSecret;

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and()
            .authorizeRequests()
            .anyRequest()
            .permitAll();
    }

    @Override
    public void configure(final ResourceServerSecurityConfigurer config) {
        config.tokenServices(tokenService());
    }

    @Primary
    @Bean
    public ResourceServerTokenServices tokenService() {
        final RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(accessTokenUri);
        tokenService.setClientId(clientId);
        tokenService.setClientSecret(clientSecret);
        return tokenService;
    }
}
