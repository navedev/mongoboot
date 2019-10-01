package com.example.mongoboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongoboot.domain.Details;
import com.example.mongoboot.model.Student;
import com.example.mongoboot.service.DemoService;
import com.lowes.webclient.loweswebclient.client.LowesWebClient;

import reactor.core.publisher.Mono;

@RestController
public class DemoController {

	@Autowired
	private DemoService demoService;

	@Autowired
	private LowesWebClient lowesWebClient;

	@RequestMapping("mongoMessage")
	public String retieveString() {

		ResponseEntity<String> result = lowesWebClient.builder.delete().uri("http://localhost:8080/stores/clearCache")
				.header("Authorization", "Basic ZXN1c2VyOmVzcGFzc3dvcmQ=").accept(MediaType.APPLICATION_JSON).exchange()
				.flatMap(response -> response.toEntity(String.class)).block();

		System.out.println(result.toString());

		Mono<String> resp = lowesWebClient.builder.get()
				.uri("http://localhost:8080/stores/retrieve/nodelist_75/1/60601").accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToMono(String.class);

		resp.subscribe(output -> System.out.println(output.toString()));

		return "Rock the World!";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/retrieveDetails/{name}")
	public List<Details> retrieveDetails(@PathVariable("name") String name) {

		return demoService.retrieveDetails(name);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/createStudent")
	public void createStudentRecord(@RequestBody Student student) {
		demoService.createStudent(student);
	}

}
