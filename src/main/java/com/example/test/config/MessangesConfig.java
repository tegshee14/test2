package com.example.test.config;

import dev.akkinoc.util.YamlResourceBundle;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Configuration
public class MessangesConfig  extends ResourceBundleMessageSource implements WebMvcConfigurer  {

    /**
     * 변경된 언어 정보를 기억할 로케일 리졸버를 생성한다.
     * 여기서는 세션에 저장하는 방실을 사용한다.
     * @return
     */
    @Bean
    public SessionLocaleResolver localeResolver(){
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.JAPAN);
        return localeResolver;
    }

    /**
     * 언어 변경을 위한 인터셉터를 생성한다
     * @return
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(localeChangeInterceptor())
               .excludePathPatterns("/resources/**","/resource/");
    }

    @Override
    protected ResourceBundle doGetBundle(String basename, Locale locale) throws MissingResourceException {
        return ResourceBundle.getBundle(basename,locale, YamlResourceBundle.Control.INSTANCE);
    }

    /**
     * 각 언어별 메세지 정보를 yml-bundle를 통해 가져옴
     * @param basename
     * @param encoding
     * @return
     */
    @Bean("messageSource")
    public MessageSource messageSource(@Value("${spring.config.messages.basename}") String basename , @Value("${spring.config.messages.encoding}") String encoding){
        this.setBasename(basename);
        this.setDefaultEncoding(encoding);
        this.setAlwaysUseMessageFormat(true);
        this.setUseCodeAsDefaultMessage(true);
        this.setFallbackToSystemLocale(false);
        return this;
    }


}

