package io.skeyer.api.client;

import io.skeyer.api.client.constant.SkeyerConstants;
import io.skeyer.api.client.impl.SkeyerApiRestClientImpl;
import io.skeyer.api.client.impl.SkeyerApiWebSocketClientImpl;
import io.skeyer.api.client.impl.SkeyerOptionApiRestClientImpl;

import static io.skeyer.api.client.impl.SkeyerApiServiceGenerator.getSharedClient;

/**
 * A factory for creating SkeyerApi client objects.
 */
public final class SkeyerApiClientFactory {

    /**
     * API Key
     */
    private String apiKey;

    /**
     * Secret.
     */
    private String secret;

    private String baseUrl = SkeyerConstants.API_BASE_URL;

    /**
     * Instantiates a new Skeyer api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private SkeyerApiClientFactory(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    private SkeyerApiClientFactory(String baseUrl, String apiKey, String secret) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.secret = secret;
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the Skeyer api client factory
     */
    public static SkeyerApiClientFactory newInstance(String apiKey, String secret) {
        return new SkeyerApiClientFactory(apiKey, secret);
    }

    /**
     * for bhop.cloud client and inner test only
     *
     * @param baseUrl
     * @param apiKey
     * @param secret
     * @return
     */
    public static SkeyerApiClientFactory newInstance(String baseUrl, String apiKey, String secret) {
        return new SkeyerApiClientFactory(baseUrl, apiKey, secret);
    }

    /**
     * New instance without authentication.
     *
     * @return the Skeyer api client factory
     */
    public static SkeyerApiClientFactory newInstance() {
        return new SkeyerApiClientFactory(null, null);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public SkeyerApiRestClient newRestClient() {
        return new SkeyerApiRestClientImpl(baseUrl, apiKey, secret);
    }


    public SkeyerApiWebSocketClient newWebSocketClient() {
        return new SkeyerApiWebSocketClientImpl(getSharedClient(), SkeyerConstants.WS_API_BASE_URL, SkeyerConstants.WS_API_USER_URL);
    }

    /**
     * for bhop.cloud client and inner test only
     *
     * @param wsApiBaseUrl
     * @param wsApiUserUrl
     * @return
     */
    public SkeyerApiWebSocketClient newWebSocketClient(String wsApiBaseUrl, String wsApiUserUrl) {
        return new SkeyerApiWebSocketClientImpl(getSharedClient(), wsApiBaseUrl, wsApiUserUrl);
    }

    /**
     * Creates a new synchronous/blocking Option REST client.
     */
    public SkeyerOptionApiRestClient newOptionRestClient() {
        return new SkeyerOptionApiRestClientImpl(baseUrl, apiKey, secret);
    }

}
