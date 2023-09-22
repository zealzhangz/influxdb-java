package org.influxdb.impl;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinInterceptor implements Interceptor {
  private static final AtomicInteger RR_INDEX = new AtomicInteger(0);
  private final List<String> urls;

  public RoundRobinInterceptor(final List<String> urls) {
    this.urls = urls;
  }

  @NotNull
  @Override
  public Response intercept(final @NotNull Chain chain) throws IOException {
    Request request = newRequst(chain);
    if (null == request) {
      return chain.proceed(chain.request());
    }
    return chain.proceed(request);
  }

  private Request newRequst(final Chain chain) {
    Request request = chain.request();
    URI uri = null;
    try {
      uri = new URI(this.urls.get(RR_INDEX.getAndIncrement() % this.urls.size()));
    } catch (URISyntaxException e) {
      return null;
    }
    return request.newBuilder()
            .url(request.url().newBuilder().host(uri.getHost()).port(uri.getPort()).build()).build();
  }
}
