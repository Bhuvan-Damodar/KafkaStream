package com.streamService.service;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.streamService.bindings.StreamBindings;
import com.streamService.model.Employee;

@EnableBinding(StreamBindings.class)
@Service
public class StreamService {

	@StreamListener("employee-input-channel")
	@SendTo("emp-developer-output-channel")
	public KStream<String, Employee> takeAway(KStream<String, Employee> employee) {
		return employee.filter((k,v)-> v.getRole().equalsIgnoreCase("developer"));
	}

	@StreamListener("employee-input-channel")
	@SendTo("emp-tester-output-channel")
	public KStream<String, Employee> homeDelivery(KStream<String, Employee> employee) {
		return employee.filter((k,v)-> v.getRole().equalsIgnoreCase("tester"));
	}

}
