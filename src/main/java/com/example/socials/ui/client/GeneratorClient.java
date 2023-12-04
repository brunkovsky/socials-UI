package com.example.socials.ui.client;

import com.example.socials.ui.model.Embedded;
import com.example.socials.ui.model.ExecutorScheduler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/*
Error Handling
https://www.baeldung.com/java-feign-client-exception-handling
 */

@FeignClient(name = "socialGeneratorClient", url = "http://localhost:8080/api/socials/generator")  // to set up the generator's endpoint more dynamic
public interface GeneratorClient {

    @GetMapping(value = "/executorSchedulers", produces = APPLICATION_JSON_VALUE)
    Embedded executorSchedulers();

    @DeleteMapping(value = "/executorSchedulers/{id}")
    void deleteGenerator(@PathVariable("id") String id);

    @PostMapping(value = "/executorSchedulers", produces = APPLICATION_JSON_VALUE)
    void addGenerator(ExecutorScheduler executorScheduler);

    @PostMapping(value = "/executor/{id}", produces = APPLICATION_JSON_VALUE)
    void forceExecute(@PathVariable("id") String id);

}
