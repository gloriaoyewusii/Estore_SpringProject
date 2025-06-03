package org.estore.estore.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCanAddProduct() throws Exception {
        String imagePath = "/home/gloriaoyewusii/Desktop/byte_buillder_store/estore/src/test/resources/assets/iphone.jpg";
        String videoPath = "/home/gloriaoyewusii/Desktop/byte_buillder_store/estore/src/test/resources/assets/iphone 16 video.mp4";

        Path image = Paths.get(imagePath);
        Path video = Paths.get(videoPath);
        mockMvc.perform(multipart("/api/v1/product")
               .file("media", new MockMultipartFile("image", Files.newInputStream(image)).getBytes())
               .file("media",  new MockMultipartFile("video", Files.newInputStream(video)).getBytes())
               .params(buildFormFields())
                        .with(request -> {
                            request.setMethod(HttpMethod.PUT.name());
                            return request;
                        }).contentType(MediaType.MULTIPART_FORM_DATA)
                ).andExpect(status().is2xxSuccessful())
                .andDo(print());
    }

    private static MultiValueMap<String, String>  buildFormFields() {
        MultiValueMap<String, String> fields = new LinkedMultiValueMap<>();
        fields.add("name", "iphone");
        fields.add("price", BigDecimal.valueOf(1000).toString());
        fields.add("description", "iphone 16 pro max");
        fields.add("quantity", "10");

        return fields;
    }

}
