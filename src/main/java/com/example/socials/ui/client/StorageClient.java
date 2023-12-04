package com.example.socials.ui.client;

import com.example.socials.ui.model.SocialItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/*
Error Handling
https://www.baeldung.com/java-feign-client-exception-handling
 */

@FeignClient(name = "socialStorageClient", url = "http://localhost:8081/api/socials/storage")
public interface StorageClient {

    @GetMapping(value = "/search", produces = APPLICATION_JSON_VALUE)
    List<SocialItem> search();

}
