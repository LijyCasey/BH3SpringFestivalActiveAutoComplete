package com.ljy.autoComplete;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ConnectUtils {
	public static CookieStore cookieStore = new BasicCookieStore();
	public static CloseableHttpClient httpCilent = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
	public static String AuthParam = "auth_key=3XpVDZz0zN5QzMycSMfZmbjl2ah5Wb9UWJ3UTJ0kWJ1IWJ5UTJmlWJzIWJ4UTJmhWJ5EWJ4UTJwkWJ4ElJs9XZlZDb30CNfZmdwl3XvBWa05TPwYTMwElJl9mduVDdy0DM4E3cyBWan52XlZ3cpRmdsFlJ09Wal1TP1ETM1gTOzQjN%3DM&sign=60dbc4bf1a28b7f1b6dcce20b0c0ac34ebf64b9efc1afeb45573d730936a3f2a";
	public static String SELL_ACTION = "2";
	public static String BUY_ACTION = "1";
}
