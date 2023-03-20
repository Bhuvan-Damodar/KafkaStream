package com.streamService.bindings;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

import com.streamService.model.Employee;

public interface StreamBindings {

	@Input("employee-input-channel")
	KStream<String, Employee> inputStream();

	@Output("emp-developer-output-channel")
	KStream<String, Employee> takeAwayStream();

	@Output("emp-tester-output-channel")
	KStream<String, Employee> homeDeliveryStream();

}
