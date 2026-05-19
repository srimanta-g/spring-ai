package com.srimantatech.spring_ai.etl;

import org.springframework.ai.document.Document;
import org.springframework.ai.document.DocumentWriter;
import org.springframework.ai.document.MetadataMode;
import org.springframework.ai.writer.FileDocumentWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EtlWriter {

    public void writeDocument (List<Document> documents) {
        DocumentWriter writer = new FileDocumentWriter("src/main/resources/output.txt", true, MetadataMode.ALL, true);
        writer.accept(documents);
    }
}
