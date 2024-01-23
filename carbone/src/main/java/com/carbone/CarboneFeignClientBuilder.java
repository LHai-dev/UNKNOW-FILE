package com.carbone;

import feign.Feign;
import feign.okhttp.OkHttpClient;

import static feign.Logger.Level.FULL;

class CarboneFeignClientBuilder {

    private CarboneFeignClientBuilder(){}

    static Feign.Builder createCarboneFeignClient(String token, String version) {
        return Feign.builder()
            .client(new OkHttpClient())
            .errorDecoder(new CarboneErrorDecoder())
            .logLevel(FULL)
            .requestInterceptor(template -> {
                template.header("Authorization", "Bearer " + token);
                template.header("carbone-version", version);
            });
    }
}
