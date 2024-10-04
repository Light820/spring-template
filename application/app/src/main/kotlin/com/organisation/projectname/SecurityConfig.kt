package com.organisation.projectname

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher

@Configuration
class SecurityConfig {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { request ->
                request
                    .requestMatchers(MvcRequestMatcher(null, "/pokemon/**"))
                    .hasRole("POKEMON-OWNER")
            }.httpBasic(Customizer.withDefaults())
            .csrf { csrf -> csrf.disable() }
        return http.build()
    }

    @Bean
    fun testOnlyUsers(passwordEncoder: PasswordEncoder): UserDetailsService {
        val users: User.UserBuilder = User.builder()
        val sarah: UserDetails =
            users
                .username("Light")
                .password(passwordEncoder.encode("abc123"))
                .roles("POKEMON-OWNER")
                .build()

        val hankOwnsNoPokemons =
            users
                .username("hank-owns-no-Pokemons")
                .password(passwordEncoder.encode("qrs456"))
                .roles("NON-OWNER")
                .build()

        val kumar =
            users
                .username("Ashe")
                .password(passwordEncoder.encode("xyz789"))
                .roles("POKEMON-OWNER")
                .build()

        return InMemoryUserDetailsManager(sarah, hankOwnsNoPokemons, kumar)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}
