package com.cheliji.spring.test.core.io;

import cn.hutool.core.io.IoUtil;
import com.cheliji.spring.core.io.DefaultResourceLoader;
import com.cheliji.spring.core.io.Resource;
import com.cheliji.spring.core.io.ResourceLoader;
import com.cheliji.spring.core.io.UrlResource;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResourceAndResourceLoaderTest {

    @Test
    public void testResourceLoader() throws IOException {

        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource classpathResource = resourceLoader.getResource("classpath:hello.txt");
        InputStream classpathResourceInputStream = classpathResource.getInputStream();
        String classpath = IoUtil.readUtf8(classpathResourceInputStream);

        System.out.println("classpath = " + classpath);

        Resource fileResource = resourceLoader.getResource("src/test/resources/hello.txt");
        InputStream fileResourceInputStream = fileResource.getInputStream();
        String file = IoUtil.readUtf8(fileResourceInputStream);
        System.out.println("file = " + file);

        //加载url资源
        Resource urlResource = resourceLoader.getResource("https://www.baidu.com");
        assertThat(urlResource instanceof UrlResource).isTrue();
        InputStream urlInputStream = urlResource.getInputStream();
        String url = IoUtil.readUtf8(urlInputStream);
        System.out.println("url = " + url);




    }

}
