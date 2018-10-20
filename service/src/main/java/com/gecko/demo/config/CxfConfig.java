package com.gecko.demo.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {

    @Bean
    public JacksonJaxbJsonProvider jsonProvider() {
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        ObjectMapper mapper = new ObjectMapper();
        provider.setMapper(mapper);


        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        //mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        return provider;
    }

    @Bean
    public Feature swagger2Feature(@Value("${cxf.path}")String basePath) {
        Swagger2Feature result = new Swagger2Feature();
        result.setResourcePackage("com.gecko.demo.resource");
        result.setVersion("1.0.0");
        result.setBasePath(basePath);
        result.setTitle("IHUB Image Service");
        result.setDescription("IHUB Image Service");
        result.setContact("hoo@intuit.com");
        result.setLicense("Intuit Private License");
        result.setLicenseUrl("http://insight.intuit.com");
        result.setScan(true);
        return result;
    }
}
