package org.wpattern.easy.buying.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;
import org.wpattern.easy.buying.utils.ResourcePaths;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    public static final String AUTH_USER = "ROLE_USER";

    public static final String AUTH_CLIENT = "ROLE_CLIENTE";

    public static final String AUTH_ADMIN = "ROLE_ADMIN";

    public static final String AUTH_FORNECEDOR = "ROLE_FORNECEDOR";

    @Autowired
    private UserDetailsService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HeaderHandler headerHandler;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(this.passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("index.html").permitAll()
                // Global Authority to OPTIONS (permit all).
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // Public (permit all).
                .antMatchers(ResourcePaths.PUBLIC_ROOT_PATH + ResourcePaths.ALL).permitAll()
                // User Authorities.
                .antMatchers(HttpMethod.GET, ResourcePaths.USER_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.POST, ResourcePaths.USER_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.PUT, ResourcePaths.USER_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.DELETE, ResourcePaths.USER_PATH).hasAnyAuthority(AUTH_ADMIN)
                // Permission Authorities.
                .antMatchers(HttpMethod.GET, ResourcePaths.PERMISSION_PATH).hasAnyAuthority(AUTH_USER,AUTH_ADMIN,AUTH_FORNECEDOR,AUTH_CLIENT)

                // User Produtos.
                .antMatchers(HttpMethod.GET, ResourcePaths.PRODUCT_PATH).hasAnyAuthority(AUTH_ADMIN,AUTH_USER,AUTH_FORNECEDOR,AUTH_CLIENT)
                .antMatchers(HttpMethod.POST, ResourcePaths.PRODUCT_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.PUT, ResourcePaths.PRODUCT_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.DELETE, ResourcePaths.PRODUCT_PATH).hasAnyAuthority(AUTH_ADMIN)

                //Notification_type.
                .antMatchers(HttpMethod.GET, ResourcePaths.NOTIFICATION_TYPE_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.POST, ResourcePaths.NOTIFICATION_TYPE_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.PUT, ResourcePaths.NOTIFICATION_TYPE_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.DELETE, ResourcePaths.NOTIFICATION_TYPE_PATH).hasAnyAuthority(AUTH_ADMIN)


                // Notification Template.
                .antMatchers(HttpMethod.GET, ResourcePaths.NOTIFICATION_TEMPLATE_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.POST, ResourcePaths.NOTIFICATION_TEMPLATE_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.PUT, ResourcePaths.NOTIFICATION_TEMPLATE_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.DELETE, ResourcePaths.NOTIFICATION_TEMPLATE_PATH).hasAnyAuthority(AUTH_ADMIN)

                // Authorities.
                .antMatchers(HttpMethod.GET, ResourcePaths.NOTIFICATION_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.POST, ResourcePaths.NOTIFICATION_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.PUT, ResourcePaths.NOTIFICATION_PATH).hasAnyAuthority(AUTH_ADMIN)
                .antMatchers(HttpMethod.DELETE, ResourcePaths.NOTIFICATION_PATH).hasAnyAuthority(AUTH_ADMIN)



                .anyRequest().fullyAuthenticated().and()
                // Logout configuration.
                .logout().logoutRequestMatcher(new AntPathRequestMatcher(ResourcePaths.LOGOUT_PATH)).logoutSuccessHandler(headerHandler).and()
                // CSRF configuration.
                .csrf().csrfTokenRepository(csrfTokenRepository()).and()
                .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class)
                .addFilterAfter(headerHandler, ChannelProcessingFilter.class);
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }

    private Filter csrfHeaderFilter() {
        return new OncePerRequestFilter() {

            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain filterChain) throws ServletException, IOException {
                CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());

                if (csrf != null) {
                    Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
                    String token = csrf.getToken();

                    if (cookie == null || token != null && !token.equals(cookie.getValue())) {
                        cookie = new Cookie("XSRF-TOKEN", token);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }

                filterChain.doFilter(request, response);
            }

        };
    }

}
