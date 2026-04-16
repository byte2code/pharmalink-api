package com.CN.PharmaLink.communicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.CN.PharmaLink.dto.MedicalStoreDto;

import java.util.List;
import java.util.Arrays;

@Component
public class StoreFinderCommunicator {

    @Autowired
    private RestTemplate restTemplate;

    public List<MedicalStoreDto> getNearestMedicalStores(Long userId, Long distance, String jwtToken) {
        String url = "http://localhost:8081/store/getNearestStores/" + userId + "/" + distance + "/" + jwtToken;
        MedicalStoreDto[] stores = restTemplate.getForObject(url, MedicalStoreDto[].class);
        return Arrays.asList(stores);
    }

    public List<MedicalStoreDto> getMedicalStoresWithMedicine(String medicine, String jwtToken) {
        String url = "http://localhost:8081/store/getStoresWithMedicine/" + medicine + "/" + jwtToken;
        MedicalStoreDto[] stores = restTemplate.getForObject(url, MedicalStoreDto[].class);
        return Arrays.asList(stores);
    }
}
