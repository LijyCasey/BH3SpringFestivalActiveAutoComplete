package com.ljy.autoComplete;

public class BackpackInfoObject {

	private int luckyBag;
	private int historyBag;
	private int couplets;// 春联
	private int cake;// 吉祥结
	private int chipao;// 旗袍
	private int papercut;// 福字贴
	private int firecracker;// 鞭炮
	private int money;

	public String toString(){
		return "couplets:"+couplets+" cake:"+cake+" chipao:"+chipao+" papercut:"+papercut+" firecracker:"+firecracker;
	}
	public BackpackInfoObject(){
		
	}
	public BackpackInfoObject(int luckBag, int historyBag, int couplets, int cake, int chipao, int papercut,
			int firecracker, int money) {
		this.luckyBag = luckBag;
		this.historyBag = historyBag;
		this.couplets = couplets;
		this.cake = cake;
		this.chipao = chipao;
		this.papercut = papercut;
		this.firecracker = firecracker;
		this.money = money;
	}

	public int getLuckyBag() {
		return luckyBag;
	}

	public void setLuckyBag(int luckyBag) {
		this.luckyBag = luckyBag;
	}

	public int getHistoryBag() {
		return historyBag;
	}

	public void setHistoryBag(int historyBag) {
		this.historyBag = historyBag;
	}

	public int getCouplets() {
		return couplets;
	}

	public void setCouplets(int couplets) {
		this.couplets = couplets;
	}

	public int getCake() {
		return cake;
	}

	public void setCake(int cake) {
		this.cake = cake;
	}

	public int getChipao() {
		return chipao;
	}

	public void setChipao(int chipao) {
		this.chipao = chipao;
	}

	public int getPapercut() {
		return papercut;
	}

	public void setPapercut(int papercut) {
		this.papercut = papercut;
	}

	public int getFirecracker() {
		return firecracker;
	}

	public void setFirecracker(int firecracker) {
		this.firecracker = firecracker;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
