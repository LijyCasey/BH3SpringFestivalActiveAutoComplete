package com.ljy.autoComplete;

import java.util.Date;

public class Bin extends Thread {
	private static int moneySum = 0;
	private static int MAX = 60000;
	private String type;

	@Override
	public void run() {
		//
		while (moneySum < MAX) {
			// 查询当前背包情况
			BackpackInfoObject nowBackpack = BackpackInfo.getBackpackInfo();
			// 更新moneySum的数量
			moneySum = nowBackpack.getMoney();
			if(type.equals("chipao"))
			System.out.println(new Date() + "-----------现在的钱是：" + moneySum +" "+ nowBackpack.toString());
			// 查询type的数量
			if (type.equals("couplets") || type.equals("cake")) {
				int nowNumber = MarketStrategy.getNumBer(type, 100);
				if (nowNumber > 0) {
					int buyRes = MarketStrategy.buy(type, 100, nowNumber);
					System.out.println(new Date() + "------买到" + type + "  价格：100" + "  数量：" + nowNumber);
					MarketStrategy.sell(type, 200, nowNumber);
				}
			} else if (type.equals("papercut") || type.equals("firecracker")) {
				for (int i = 1; i < 10; i++) {
					int nowNumber = MarketStrategy.getNumBer(type, i * 100);
					if (nowNumber > 0) {
						int buyRes = MarketStrategy.buy(type, i * 100, nowNumber);
						System.out.println(new Date() + "------买到" + type + "  价格：" + i * 100 + "  数量：" + nowNumber);
						MarketStrategy.sell(type, 1000, nowNumber);
						// int buyRes=MarketStrategy.buy(type, i*100,
						// nowNumber);
					}
				}
			} else {
				for (int i = 1; i < 4; i++) {
					int nowNumber = MarketStrategy.getNumBer(type, i * 100);
					if (nowNumber > 0) {
						int buyRes = MarketStrategy.buy(type, i * 100, nowNumber);
						System.out.println(new Date() + "------买到" + type + "  价格：" + i * 100 + "  数量：" + nowNumber);
						MarketStrategy.sell(type, 400, nowNumber);
						// int buyRes=MarketStrategy.buy(type, i*100,
						// nowNumber);
						// if(buyRes==0){
						// System.out.println(new Date()+"------买到"+type+"
						// 价格："+i*100+" 数量："+nowNumber);
						// MarketStrategy.sell(type, 400, nowNumber);
						// }
					}
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.run();
	}

	public Bin(String type) {
		this.type = type;
	}

	public static void main(String[] args) {
		Bin couplets = new Bin("couplets");
		Bin cake = new Bin("cake");
		Bin chipao = new Bin("chipao");
		Bin papercut = new Bin("papercut");
		Bin firecracker = new Bin("firecracker");
		couplets.start();
		cake.start();
		chipao.start();
		papercut.start();
		firecracker.start();
	}
}
