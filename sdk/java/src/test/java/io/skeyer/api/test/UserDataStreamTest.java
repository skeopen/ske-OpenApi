package io.skeyer.api.test;

import io.skeyer.api.client.SkeyerApiClientFactory;
import io.skeyer.api.client.SkeyerApiRestClient;
import io.skeyer.api.client.SkeyerApiWebSocketClient;
import io.skeyer.api.client.constant.SkeyerConstants;
import io.skeyer.api.test.constant.Constants;

//@Slf4j
public class UserDataStreamTest {

    public static void main(String[] args) {
//
        SkeyerApiWebSocketClient client = SkeyerApiClientFactory.newInstance().newWebSocketClient();
        SkeyerApiRestClient restClient = SkeyerApiClientFactory.newInstance(Constants.ACCESS_KEY, Constants.SECRET_KEY).newRestClient();

        System.out.println("\n ------Get Listen Key -----");
        System.out.println();
        String listenKey = restClient.startUserDataStream(SkeyerConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
        System.out.println("listenKey:" + listenKey);
        // order
        client.onUserEvent(listenKey, response -> System.out.println(response), true);

    }
}
