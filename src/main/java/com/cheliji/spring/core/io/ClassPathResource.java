package com.cheliji.spring.core.io;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 管理 classpath 路径下的资源
 */
public class ClassPathResource implements Resource{

    private final String path ;

    public ClassPathResource(String path) {
        this.path = path ;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        // 获取当先类对象，在获取类加载器，根据路径 this.path 加载资源
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(this.path);
        if (is == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return is ;
    }
}
