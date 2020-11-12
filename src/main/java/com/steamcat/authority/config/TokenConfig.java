package com.steamcat.authority.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.jwt.crypto.sign.SignatureVerifier;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @ClassName TokenStore
 * @Description token存储策略
 * @Author Administrator
 * @Data 上午 01:22
 * @Version 1.0
 **/
@Configuration
public class TokenConfig {
    @Value("${steamCatAuthority.signKey}")
    private String signKey;
    // 内存方式储存
   /* @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }*/

    // jwt方式储存
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(signKey); //对称秘钥
        return converter;
    }
}
