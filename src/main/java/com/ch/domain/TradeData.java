package com.ch.domain;

/**
 * 
 * @author chenheng
 * 交易数据domain
 */
public class TradeData {

	private String trOrder; //订单号
	private String copiedOrder; //复制订单
	private String copiedOrderType; //复制订单类型
	private String copiedCount; //复制总数
	private String isAuto; //是否自动
	private String isFromCopier;
	private String singleMargin;//单一盈利 1133.100000
	private String utype;
	private String symbol; //货币 XAUUSD
	private String digits; //数字 2
	private String cmd;
	private String volume; //杠杆 100
	private String openTime;  //开仓时间
	private String state; //状态
	private String openPrice; //开仓价格 1133.100000
	private String sl; //止损价格
	private String tp; //止盈价格
	private String closeTime; //平仓时间
	private String valueDate;
	private String expiration; //截止
	private String convReserv;
	private String convRates0; //转换费率0
	private String conv_rates1; //转换费率1
	private String commission; //委托
	private String commissionAgent; //委托人
	private String storage; //存储 -7.910000
	private String closePrice; //平仓价格 1132.160000
	private String profit; //收益 -94.000000
	private String taxes; //税
	private String magic; //魔法
	private String comment; //评论
	private String internalId; //内部ID
	private String activation; //激活
	private String spread; //范围
	private String marginRate; //盈利费率
	private String timestamp; //时间戳
	private String reserved0; //保留0
	private String reserved1; //保留1
	private String reserved2; //保留2
	private String reserved3; //保留3
	private String closeReason; //关闭原因
	private String logTime; //日志时间
	private String isReverse; //是否转换
	private String rebate; //减少、折扣
	private String turnoverOpen; //转换开启 113310.000000
	private String turnoverClose; //转换关闭
	private String orderFlag; //订单标识
	private String bonusEquityRate; //奖励平均费率
	private String basicAsk; //基本要求
	private String basicBid; //基本出价
	private String basicCurrency; //基本市价
	private String orderStatus; //订单状态 买入
	private String orderStatus2; //订单状态：买入，卖出，挂单卖出，挂单买入 买入
	private String symName; //系统名称 现货黄金
	private String symBrief; //系统概要 XAUUSD
	private String traderId; //牛人ID
	
	private String traderName;//牛人名称
	private Integer traderStatus;//牛人状态
	
	public String getTrOrder() {
		return trOrder;
	}
	public void setTrOrder(String trOrder) {
		this.trOrder = trOrder;
	}
	public String getCopiedOrder() {
		return copiedOrder;
	}
	public void setCopiedOrder(String copiedOrder) {
		this.copiedOrder = copiedOrder;
	}
	public String getCopiedOrderType() {
		return copiedOrderType;
	}
	public void setCopiedOrderType(String copiedOrderType) {
		this.copiedOrderType = copiedOrderType;
	}
	public String getCopiedCount() {
		return copiedCount;
	}
	public void setCopiedCount(String copiedCount) {
		this.copiedCount = copiedCount;
	}
	public String getIsAuto() {
		return isAuto;
	}
	public void setIsAuto(String isAuto) {
		this.isAuto = isAuto;
	}
	public String getIsFromCopier() {
		return isFromCopier;
	}
	public void setIsFromCopier(String isFromCopier) {
		this.isFromCopier = isFromCopier;
	}
	public String getSingleMargin() {
		return singleMargin;
	}
	public void setSingleMargin(String singleMargin) {
		this.singleMargin = singleMargin;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getDigits() {
		return digits;
	}
	public void setDigits(String digits) {
		this.digits = digits;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(String openPrice) {
		this.openPrice = openPrice;
	}
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getTp() {
		return tp;
	}
	public void setTp(String tp) {
		this.tp = tp;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getValueDate() {
		return valueDate;
	}
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	public String getConvReserv() {
		return convReserv;
	}
	public void setConvReserv(String convReserv) {
		this.convReserv = convReserv;
	}
	public String getConvRates0() {
		return convRates0;
	}
	public void setConvRates0(String convRates0) {
		this.convRates0 = convRates0;
	}
	public String getConv_rates1() {
		return conv_rates1;
	}
	public void setConv_rates1(String conv_rates1) {
		this.conv_rates1 = conv_rates1;
	}
	public String getCommission() {
		return commission;
	}
	public void setCommission(String commission) {
		this.commission = commission;
	}
	public String getCommissionAgent() {
		return commissionAgent;
	}
	public void setCommissionAgent(String commissionAgent) {
		this.commissionAgent = commissionAgent;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(String closePrice) {
		this.closePrice = closePrice;
	}
	public String getProfit() {
		return profit;
	}
	public void setProfit(String profit) {
		this.profit = profit;
	}
	public String getTaxes() {
		return taxes;
	}
	public void setTaxes(String taxes) {
		this.taxes = taxes;
	}
	public String getMagic() {
		return magic;
	}
	public void setMagic(String magic) {
		this.magic = magic;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getInternalId() {
		return internalId;
	}
	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}
	public String getActivation() {
		return activation;
	}
	public void setActivation(String activation) {
		this.activation = activation;
	}
	public String getSpread() {
		return spread;
	}
	public void setSpread(String spread) {
		this.spread = spread;
	}
	public String getMarginRate() {
		return marginRate;
	}
	public void setMarginRate(String marginRate) {
		this.marginRate = marginRate;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getReserved0() {
		return reserved0;
	}
	public void setReserved0(String reserved0) {
		this.reserved0 = reserved0;
	}
	public String getReserved1() {
		return reserved1;
	}
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}
	public String getReserved2() {
		return reserved2;
	}
	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}
	public String getReserved3() {
		return reserved3;
	}
	public void setReserved3(String reserved3) {
		this.reserved3 = reserved3;
	}
	public String getCloseReason() {
		return closeReason;
	}
	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}
	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
	public String getIsReverse() {
		return isReverse;
	}
	public void setIsReverse(String isReverse) {
		this.isReverse = isReverse;
	}
	public String getRebate() {
		return rebate;
	}
	public void setRebate(String rebate) {
		this.rebate = rebate;
	}
	public String getTurnoverOpen() {
		return turnoverOpen;
	}
	public void setTurnoverOpen(String turnoverOpen) {
		this.turnoverOpen = turnoverOpen;
	}
	public String getTurnoverClose() {
		return turnoverClose;
	}
	public void setTurnoverClose(String turnoverClose) {
		this.turnoverClose = turnoverClose;
	}
	public String getOrderFlag() {
		return orderFlag;
	}
	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}
	public String getBonusEquityRate() {
		return bonusEquityRate;
	}
	public void setBonusEquityRate(String bonusEquityRate) {
		this.bonusEquityRate = bonusEquityRate;
	}
	public String getBasicAsk() {
		return basicAsk;
	}
	public void setBasicAsk(String basicAsk) {
		this.basicAsk = basicAsk;
	}
	public String getBasicBid() {
		return basicBid;
	}
	public void setBasicBid(String basicBid) {
		this.basicBid = basicBid;
	}
	public String getBasicCurrency() {
		return basicCurrency;
	}
	public void setBasicCurrency(String basicCurrency) {
		this.basicCurrency = basicCurrency;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderStatus2() {
		return orderStatus2;
	}
	public void setOrderStatus2(String orderStatus2) {
		this.orderStatus2 = orderStatus2;
	}
	public String getSymName() {
		return symName;
	}
	public void setSymName(String symName) {
		this.symName = symName;
	}
	public String getSymBrief() {
		return symBrief;
	}
	public void setSymBrief(String symBrief) {
		this.symBrief = symBrief;
	}
	public String getTraderId() {
		return traderId;
	}
	public void setTraderId(String traderId) {
		this.traderId = traderId;
	}
	public String getTraderName() {
		return traderName;
	}
	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}
	public Integer getTraderStatus() {
		return traderStatus;
	}
	public void setTraderStatus(Integer traderStatus) {
		this.traderStatus = traderStatus;
	}
	
}
