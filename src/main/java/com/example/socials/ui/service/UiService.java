package com.example.socials.ui.service;

import com.example.socials.ui.client.GeneratorClient;
import com.example.socials.ui.client.StorageClient;
import com.example.socials.ui.model.ExecutorScheduler;
import com.example.socials.ui.model.SocialItem;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@AllArgsConstructor
public class UiService {

    private StorageClient storageClient;
    private GeneratorClient generatorClient;
    private DiscoveryClient discoveryClient;


    public List<ExecutorScheduler> getGenerators() {
        return generatorClient.executorSchedulers()
                .getEmbedded()
                .getExecutorSchedulers();
    }

    public List<SocialItem> search() {
        return storageClient.search();
    }

    public Map<String, String> getActiveServices() {
        List<String> services = discoveryClient.getServices();
        services.remove("socials-ui");
        services.remove("socials-storage");
        services.remove("socials-generator");
        Map<String, String> activeServices = new HashMap<>();
        for (String service : services) {
            activeServices.put(service,
                    discoveryClient.getInstances(service).get(0).getUri()
                            .resolve("/api/socials/" + service.split("-")[1] + "/ui").toString());
        }
        return activeServices;
    }

    public void deleteGenerator(String id) {
        generatorClient.deleteGenerator(id);
    }

    public void addGenerator(ExecutorScheduler executorScheduler) {
        executorScheduler.setLastTimeFetched(new Date());
        generatorClient.addGenerator(executorScheduler);
    }

    public void forceExecute(String id) {
        generatorClient.forceExecute(id);
    }
}
