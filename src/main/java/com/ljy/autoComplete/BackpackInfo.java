package com.ljy.autoComplete;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

public class BackpackInfo {
	private static final String URL = "https://event.bh3.com/bh3_2018spring_festival/index.php";

	

	public static BackpackInfoObject getBackpackInfo() {
		HttpGet httpGet = new HttpGet(URL+"?"+ConnectUtils.AuthParam);
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
				Map<String, String> dataMap = (LinkedTreeMap) ((LinkedTreeMap) map.get("data")).get("backpack");
				BackpackInfoObject obj = new BackpackInfoObject();
				obj.setCake(Integer.parseInt(dataMap.get("cake")));
				obj.setChipao(Integer.parseInt(dataMap.get("chipao")));
				obj.setCouplets(Integer.parseInt(dataMap.get("couplets")));
				obj.setFirecracker(Integer.parseInt(dataMap.get("firecracker")));
				obj.setPapercut(Integer.parseInt(dataMap.get("papercut")));
				obj.setMoney(Integer.parseInt(dataMap.get("money")));
				return obj;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}
}
