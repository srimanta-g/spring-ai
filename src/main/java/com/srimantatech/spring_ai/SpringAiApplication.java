package com.srimantatech.spring_ai;

import com.srimantatech.spring_ai.etl.EtlJsonReader;
import com.srimantatech.spring_ai.etl.EtlTokenTextSplitter;
import com.srimantatech.spring_ai.etl.EtlWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringAiApplication.class, args);

		context.getBean(EtlWriter.class)
				.writeDocument(context.getBean(EtlTokenTextSplitter.class).splitDocuments(
						context.getBean(EtlJsonReader.class).loadJsonAsDocument()
				));
	}
}
