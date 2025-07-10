package com.example.gateway.adaptor;

import com.example.gateway.client.AirbridgeClient;
import java.util.Collections;
import java.util.Map;

/**
 * Implementation of {@link ClientAdaptor} using a Feign client.
 */
public class FeignClientAdaptor implements ClientAdaptor {
    private final AirbridgeClient client;
    private final String authorization;
    private final String language;
    private String uri;
    private Map<String, Object> params = Collections.emptyMap();
    public FeignClientAdaptor(AirbridgeClient client, String authorization, String language) {
        this.client = client;
        this.authorization = authorization;
        this.language = language;
    }

    @Override
    public ClientAdaptor get() {
        return this;
    }

    @Override
    public ClientAdaptor uri(String uri) {
        this.uri = uri;
        return this;
    }

    @Override
    public ClientAdaptor params(Map<String, Object> params) {
        this.params = params;
        return this;
    }

    @Override
    public <T> RestMessage<T> retrieve(Class<T> responseType) {
        Object response = null;
        try {
            if ("/tracking-links".equals(uri)) {
                response = client.getTrackingLinks(authorization, language, params);
            } else if (uri != null && uri.startsWith("/tracking-links/")) {
                String id = uri.substring("/tracking-links/".length());
                String idType = (String) params.getOrDefault("idType", "id");
                response = client.getTrackingLinkDetail(authorization, language, id, idType);
            }
        } catch (Exception e) {
            return new RestMessage<>(false, e.getMessage(), null);
        }
        @SuppressWarnings("unchecked")
        T data = (T) response;
        return RestMessage.ok(data);
    }
}
