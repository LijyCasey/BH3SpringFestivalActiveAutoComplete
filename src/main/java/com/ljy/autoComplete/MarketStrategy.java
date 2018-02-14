package com.ljy.autoComplete;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

public class MarketStrategy {
	static String TradeURL = "https://event.bh3.com/bh3_2018spring_festival/trade.php";

	public static int getNumBer(String type, int price) {
		HttpGet httpGet = new HttpGet(TradeURL + "?" + ConnectUtils.AuthParam + "&action=" + ConnectUtils.BUY_ACTION);
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		httpGet.addHeader("user-agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
		try {

			HttpResponse httpResponse = ConnectUtils.httpCilent.execute(httpGet);
			String resultStr = "";
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				resultStr = EntityUtils.toString(httpResponse.getEntity());
				map = gson.fromJson(resultStr, map.getClass());
				Map<String, String> dataMap = (LinkedTreeMap) ((LinkedTreeMap) map.get("data")).get(type);
				int rs=Integer.parseInt(dataMap.get("0"+price));
				if(rs>0)
				System.out.println("========================================快买！type="+type+" 价格："+price+" 数量："+rs);
				return rs;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		return 0;
	}

	public static int buy(String type, int price, int count) {
		String buyUrl = TradeURL + "?" + ConnectUtils.AuthParam + "&action=" + ConnectUtils.BUY_ACTION + "&type=" + type
				+ "&quantity=" + count+"&price="+price;
		HttpPost httpGet = new HttpPost(buyUrl);
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		httpGet.addHeader("user-agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
		try {

			HttpResponse httpResponse = ConnectUtils.httpCilent.execute(httpGet);
			int number = 0;
			String resultStr = "";
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				resultStr = EntityUtils.toString(httpResponse.getEntity());
				map = gson.fromJson(resultStr, map.getClass());
				System.out.println("=======================购买提示："+map.get("msg")+"  return:"+map.get("retcode"));
				if(map.get(map.get("retcode"))!=null){
					Double temp=(Double)map.get(map.get("retcode"));
					number = temp.intValue();
					
				}else{
					number =-1;
				}
				return number;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		return -1;
	}

	public static int sell(String type, int price, int count) {
		String sellUrl = TradeURL + "?" + ConnectUtils.AuthParam + "&action=" + ConnectUtils.SELL_ACTION + "&type="
				+ type + "&quantity=" + count+"&price="+price;
		HttpPost httpGet = new HttpPost(sellUrl);
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		httpGet.addHeader("user-agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
		try {

			HttpResponse httpResponse = ConnectUtils.httpCilent.execute(httpGet);
			int number = 0;
			String resultStr = "";
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				resultStr = EntityUtils.toString(httpResponse.getEntity());
				map = gson.fromJson(resultStr, map.getClass());
				System.out.println("=======================卖出提示："+map.get("msg")+" 代码是："+map.get("retcode"));
				if(map.get(map.get("retcode"))!=null){
				Double temp=(Double)map.get(map.get("retcode"));
				number = temp.intValue();
				}else{
					number =-1;
				}
				return number;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		return -1;
	}
}
