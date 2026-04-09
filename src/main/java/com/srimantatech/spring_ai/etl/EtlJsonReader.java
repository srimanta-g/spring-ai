package com.srimantatech.spring_ai.etl;

//import io.modelcontextprotocol.spec.McpSchema.Resource;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.JsonReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EtlJsonReader {

    private final Resource resource;

    public EtlJsonReader (@Value("classpath:bikes.json") Resource resource) {
        this.resource = resource;
    }

    public List<Document> loadJsonAsDocument () {
        JsonReader jsonReader = new JsonReader(this.resource, "description", "context");
        return jsonReader.get();
    }

}
