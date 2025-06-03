package org.estore.estore.integration;

import lombok.RequiredArgsConstructor;
import org.estore.estore.dto.response.walrus.WalrusUploadResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpMethod.PUT;

@Component
@RequiredArgsConstructor
public class WalrusCloudService implements CloudService {

    @Value("${walrus.app.url}")
    private String walrusUrl;
    @Value("${walrus.app.epoch}")
    private  String epoch;
    @Value("${walrus.app.address}")
    private String walrusUploadAddress;
    private final RestTemplate restTemplate;


    @Override
    public String upload(MultipartFile file) {


        return extraBlobId(restTemplate.exchange(walrusUrl, PUT,  buiildUploadRequest(file), WalrusUploadResponse.class, createQueryParmas()));

//        return extraBlobId(response);
    }

    private static String extraBlobId(ResponseEntity<WalrusUploadResponse> response) {
        WalrusUploadResponse walrusUploadResponse = response.getBody();
        boolean isFileAlreadyExists = walrusUploadResponse != null && walrusUploadResponse.getNewlyCreated() == null;
        if (isFileAlreadyExists)
            return walrusUploadResponse.getAlreadyCertified().getBlobId();
        return walrusUploadResponse.getNewlyCreated().getBlobObject().getBlobId();
    }

    private HttpEntity<?> buiildUploadRequest(MultipartFile file) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        RequestEntity<?> requestEntity = new RequestEntity<>(file, PUT, URI.create(walrusUrl));

        Resource resource = file.getResource();
        return new HttpEntity<>(resource, headers);

    }
    private Map<String, ?> createQueryParmas() {
        Map<String, Object> params = new HashMap<>();
        params.put("epochs", Integer.parseInt(epoch));
        params.put("send_object_to", walrusUploadAddress);
        return params;

    }

}
