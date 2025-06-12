package com.example.gateway.adaptor;

import java.util.Map;

/**
 * Simple client adaptor interface supporting fluent calls.
 */
public interface ClientAdaptor {
    ClientAdaptor get();
    ClientAdaptor uri(String uri);
    ClientAdaptor params(Map<String, Object> params);
    <T> RestMessage<T> retrieve(Class<T> responseType);
}
