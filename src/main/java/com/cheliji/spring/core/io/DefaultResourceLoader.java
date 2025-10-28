package com.cheliji.spring.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 使用策略模式，根据不同情况获取不同的资源
 */
public class DefaultResourceLoader implements ResourceLoader {

    public static final String CLASSPATH_PREFIX = "classpath:";

    @Override
    public Resource getResource(String location) {

        if (location.startsWith(CLASSPATH_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location) ;
            }
        }

    }
}
