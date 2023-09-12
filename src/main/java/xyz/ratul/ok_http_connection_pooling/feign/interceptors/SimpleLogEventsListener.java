package xyz.ratul.ok_http_connection_pooling.feign.interceptors;

import okhttp3.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.LocalDateTime;
import java.util.List;

public class SimpleLogEventsListener extends EventListener {

    private final static Logger LOGGER = LogManager.getLogger(SimpleLogEventsListener.class);

    @Override
    public void callStart(Call call) {
        LOGGER.info("callStart at {}", LocalDateTime.now());
    }

    @Override
    public void callEnd(Call call) {
        LOGGER.info("callEnd at {}", LocalDateTime.now());
    }

    @Override
    public void requestHeadersStart(Call call) {
        LOGGER.info("requestHeadersStart at {}", LocalDateTime.now());
    }

    @Override
    public void requestHeadersEnd(Call call, Request request) {
        LOGGER.info("requestHeadersEnd at {} with headers {}", LocalDateTime.now(), request.headers());
    }

    @Override
    public void responseHeadersStart(Call call) {
        LOGGER.info("responseHeadersStart at {}", LocalDateTime.now());
    }

    @Override
    public void responseHeadersEnd(Call call, Response response) {
        LOGGER.info("responseHeadersEnd at {} with headers {}", LocalDateTime.now(), response.headers());
    }

    @Override
    public void secureConnectStart(Call call) {
        LOGGER.info("secureConnectStart at {}", LocalDateTime.now());
    }

    @Override
    public void secureConnectEnd(Call call, Handshake handshake) {
        LOGGER.info("secureConnectEnd at {} with {}", LocalDateTime.now(), handshake);
    }

    @Override
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        LOGGER.info("connectStart at {}", LocalDateTime.now());
    }

    @Override
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        LOGGER.info("connectEnd at {}", LocalDateTime.now());
    }

    @Override
    public void connectionAcquired(Call call, Connection connection) {
        LOGGER.info("connectionAcquired at {} with {}", LocalDateTime.now(), connection);
    }

    @Override
    public void connectionReleased(Call call, Connection connection) {
        LOGGER.info("connectionReleased at {}", LocalDateTime.now());
    }

    @Override
    public void dnsStart(Call call, String domainName) {
        LOGGER.info("dnsStart at {} with domainName {}", LocalDateTime.now(), domainName);
    }

    @Override
    public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
        LOGGER.info("dnsEnd at {} with domainName {} inetAddressList {}", LocalDateTime.now(), domainName, inetAddressList);
    }
}
