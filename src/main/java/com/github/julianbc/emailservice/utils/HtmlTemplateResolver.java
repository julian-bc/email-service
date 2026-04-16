package com.github.julianbc.emailservice.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class HtmlTemplateResolver {

    public String resolve(String templatePath, Map<String, String> data) {
        try {
            InputStream is = getClass().getResourceAsStream(templatePath);
            assert is != null;
            String template = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            for (Map.Entry<String, String> entry : data.entrySet()) {
                template = template.replace("${" + entry.getKey() + "}", entry.getValue());
            }

            return template;
        } catch (IOException ex) {
            throw new RuntimeException("No se pudo leer la plantilla HTML", ex);
        }
    }
}
