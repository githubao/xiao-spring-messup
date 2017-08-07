package me.xiao.springlearn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

import java.util.Arrays;

/**
 * 安全配置模式
 *
 * @author BaoQiang
 * @version 2.0
 * @date: 2017/8/7 15:11
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.ldapAuthentication().userDnPatterns("uid={0},ou=people")
//                .groupSearchBase("ou=groups")
//                .contextSource(contextSource())
//                .passwordCompare()
//                .passwordEncoder(new LdapShaPasswordEncoder())
//                .passwordAttribute("userPassword");

        auth.ldapAuthentication().contextSource().url("ldap://localhost:8389/dc=example,dc=com")
                .managerDn("uid=admin,ou=system").managerPassword("secret")
                .and()
                .userSearchBase("ou=users")
                .userSearchFilter("(cn={0})");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin();
    }

    @Bean
    public DefaultSpringSecurityContextSource contextSource() {
//        return new DefaultSpringSecurityContextSource(Arrays.asList("ldap://localhost:8389/", "dc=springframework,dc=org"));
        return new DefaultSpringSecurityContextSource("ldap://localhost:8389/dc=springframework,dc=org");
    }
}
