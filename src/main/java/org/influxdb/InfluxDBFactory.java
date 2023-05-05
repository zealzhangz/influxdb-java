package org.influxdb;

import org.influxdb.InfluxDB.ResponseFormat;
import org.influxdb.impl.InfluxDBImpl;

import okhttp3.OkHttpClient;
import org.influxdb.impl.Preconditions;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * A Factory to create a instance of a InfluxDB Database adapter.
 *
 * @author stefan.majer [at] gmail.com
 *
 */
public enum InfluxDBFactory {
  INSTANCE;

  /**
   * Create a connection to a InfluxDB.
   *
   * @param url
   *            the url to connect to.
   * @return a InfluxDB adapter suitable to access a InfluxDB.
   */
  public static InfluxDB connect(final String url) {
    Preconditions.checkNonEmptyString(url, "url");
    return new InfluxDBImpl(Arrays.asList(url), null, null, new OkHttpClient.Builder());
  }

  /**
   * Create a connection to a InfluxDB.
   *
   * @param urls 
                the url to connect to.
   * @return a InfluxDB adapter suitable to access a InfluxDB.
   */
  public static InfluxDB connect(final List<String> urls) {
        Preconditions.checkNonEmptyString(urls, "urls");
        return new InfluxDBImpl(urls, null, null, new OkHttpClient.Builder());
  }
  
  /**
   * Create a connection to a InfluxDB.
   *
   * @param url
   *            the url to connect to.
   * @param username
   *            the username which is used to authorize against the influxDB instance.
   * @param password
   *            the password for the username which is used to authorize against the influxDB
   *            instance.
   * @return a InfluxDB adapter suitable to access a InfluxDB.
   */
  public static InfluxDB connect(final String url, final String username, final String password) {
    Preconditions.checkNonEmptyString(url, "url");
    Preconditions.checkNonEmptyString(username, "username");
    return new InfluxDBImpl(Arrays.asList(url), username, password, new OkHttpClient.Builder());
  }
  
  /**
   * Create a connection to a InfluxDB.
   *
   * @param urls     
                the urls to connect to.
   * @param username 
                the username which is used to authorize against the influxDB instance.
   * @param password 
                the password for the username which is used to authorize against the influxDB instance.
   * @return a InfluxDB adapter suitable to access a InfluxDB.
   */
  public static InfluxDB connect(final List<String> urls, final String username, final String password) {
        Preconditions.checkNonEmptyString(urls, "urls");
        Preconditions.checkNonEmptyString(username, "username");
        return new InfluxDBImpl(urls, username, password, new OkHttpClient.Builder());
  }
  
  /**
   * Create a connection to a InfluxDB.
   *
   * @param url
   *            the url to connect to.
   * @param client
   *            the HTTP client to use
   * @return a InfluxDB adapter suitable to access a InfluxDB.
   */
  public static InfluxDB connect(final String url, final OkHttpClient.Builder client) {
    Preconditions.checkNonEmptyString(url, "url");
    Objects.requireNonNull(client, "client");
    return new InfluxDBImpl(Arrays.asList(url), null, null, client);
  }
  
  /**
   * Create a connection to a InfluxDB.
   *
   * @param urls   the urls to connect to.
   * @param client the HTTP client to use
   * @return a InfluxDB adapter suitable to access a InfluxDB.
   */
  public static InfluxDB connect(final List<String> urls, final OkHttpClient.Builder client) {
        Preconditions.checkNonEmptyString(urls, "urls");
        Objects.requireNonNull(client, "client");
        return new InfluxDBImpl(urls, null, null, client);
  }
  

  /**
   * Create a connection to a InfluxDB.
   *
   * @param url
   *            the url to connect to.
   * @param username
   *            the username which is used to authorize against the influxDB instance.
   * @param password
   *            the password for the username which is used to authorize against the influxDB
   *            instance.
   * @param client
   *            the HTTP client to use
   * @return a InfluxDB adapter suitable to access a InfluxDB.
   */
  public static InfluxDB connect(final String url, final String username, final String password,
      final OkHttpClient.Builder client) {
    return connect(url, username, password, client, ResponseFormat.JSON);
  }
  
  /**
   * Create a connection to a InfluxDB.
   *
   * @param urls     the urls to connect to.
   * @param username the username which is used to authorize against the influxDB instance.
   * @param password the password for the username which is used to authorize against the influxDB
   *                 instance.
   * @param client   the HTTP client to use
   * @return a InfluxDB adapter suitable to access a InfluxDB.
   */
  public static InfluxDB connect(final List<String> urls, final String username, final String password,
                                   final OkHttpClient.Builder client) {
    return connect(urls, username, password, client, ResponseFormat.JSON);
  }

  /**
   * Create a connection to a InfluxDB.
   *
   * @param url
   *            the url to connect to.
   * @param username
   *            the username which is used to authorize against the influxDB instance.
   * @param password
   *            the password for the username which is used to authorize against the influxDB
   *            instance.
   * @param client
   *            the HTTP client to use
   * @param responseFormat
   *            The {@code ResponseFormat} to use for response from InfluxDB server
   * @return a InfluxDB adapter suitable to access a InfluxDB.
   */
  public static InfluxDB connect(final String url, final String username, final String password,
      final OkHttpClient.Builder client, final ResponseFormat responseFormat) {
    Preconditions.checkNonEmptyString(url, "url");
    Preconditions.checkNonEmptyString(username, "username");
    Objects.requireNonNull(client, "client");
    return new InfluxDBImpl(Arrays.asList(url), username, password, client, responseFormat);
  }
  
  /**
   * Create a connection to a InfluxDB.
   *
   * @param urls           the urls to connect to.
   * @param username       the username which is used to authorize against the influxDB instance.
   * @param password       the password for the username which is used to authorize against the influxDB
   *                       instance.
   * @param client         the HTTP client to use
   * @param responseFormat The {@code ResponseFormat} to use for response from InfluxDB server
   * @return a InfluxDB adapter suitable to access a InfluxDB.
   */
  public static InfluxDB connect(final List<String> urls, final String username, final String password,
                                   final OkHttpClient.Builder client, final ResponseFormat responseFormat) {
    Preconditions.checkNonEmptyString(urls, "urls");
    Preconditions.checkNonEmptyString(username, "username");
    Objects.requireNonNull(client, "client");
    return new InfluxDBImpl(urls, username, password, client, responseFormat);
  }
}
