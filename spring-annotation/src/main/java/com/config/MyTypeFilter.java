package com.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/15 11:17
 */
public class MyTypeFilter implements TypeFilter {

    //metadataReader:读取到的当前正在扫描的类的信息
    //metadataReaderFactory:可以获取到其他任何类的信息
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源(类的路径)
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("classname="+className);

        //指定扫描规则,指定扫描到的组件名字中包含“er"的返回true
        if(className.contains("er")){
            return true;
        }
        return false;
    }

}
