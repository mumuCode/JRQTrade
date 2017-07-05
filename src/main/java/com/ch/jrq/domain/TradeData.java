package com.ch.jrq.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * 
 * @author chenheng
 * 交易数据domain
 */
public class TradeData {

	//持仓订单
    private String orderId;//订单号 16170920
    private String symbol; //货币 XAUUSD
    private String openTime;  //开仓时间 1491293028
    private String closeTime; //平仓时间 0
    private String originalOrder;//最初订单
    private String openPrice; //开仓价格 1257.86
    private String closePrice; //平仓价格 1258.36
    private String volume; //手数 100/100=1手
    private String stopLoss; // 止损 sl
    private String takeProfit; // 止盈 tp
    private String profit; //盈利 3.3709958
    private String priceDigit;// 价格数字 2
    private String ofSsb;
    private String swap;//库存费用
    private String type;//类型
    private String status;//状态 0:持有 3:撤单
    private String demoLiveType;
    private String direction;//方向 BUY
    private String margin;// 保证金
	private String commission; //委托 0
	private String cloPrice;//平仓价格 1257.0172
	private String exchRatio;//交易比率
	private String singleMargin;//单一盈利 50.3144
	private String cmd;//命令 0:买入 1:卖出 3:撤单
	private String sl; //止损价格
	private String tp; //止盈价格
	private String digits;//数字 2	
	private String state; //状态 0:持仓 3:关闭
	private String orderStatus; //最终订单状态描述 手动平仓/止盈平仓/止损平仓/撤单	
	private String tradeCmd; //交易命令 0:买入 1:卖出 2:挂单买入  3:挂单卖出
	private String orderStatus2; //初始订单状态描述 卖出	
	private String symBrief; //系统概要 XAUUSD
	
	//关闭订单(与持仓订单数据不同的字段)
	private String login; //22788916
	private String masterLogin; //0
	private String masterOrderId; //0
    private String orderType; //1
    private String crid;
    private String closeReason; //1
    private String copySummaryId; //摘要
	
	//功能开发新增
	private String traderId; //牛人ID
	private String traderName;//牛人名称
	private Integer traderStatus;//牛人状态	
	private String openStatus;//开仓状态
	private String openDescribe;//开仓描述
	private String closeStatus;//平仓状态
	private String closeDescribe;//平仓描述
	private String content;//订单信息备注
	
	private String createTime;//创建时间
	private String updateTime;//更新时间
	
	//无参构造
	public TradeData(){};
	
	//抓取数据作为参数构造
	//交易数据：{"login":22788916,"master_login":0,"masterorder_id":0,"order_id":"16482742","order_type":1,"crid":"","trade_cmd":1,"symbol":"USDCHF","volume":"8","status":3,"stop_loss":"0","take_profit":"0","profit":"-4.4100000000000001","open_time":1493009620,"open_price":"0.99666999999999994","close_time":1493013973,"close_price":"0.99722","single_margin":"200","commission":"0","swap":"0","digit":5,"timestamp":1493013973,"close_reason":1,"copy_summary_id":null,"cmd":1,"sl":"0","tp":"0","digits":5,"state":3,"order_status":"手动平仓","order_status2":"卖出","sym_brief":"USDCHF"}
	public TradeData(String jsonStr,String traderId,String traderName) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JSONObject obj = JSONObject.fromObject(jsonStr);
		this.orderId = obj.getString("order_id");
		this.traderId = traderId;
		this.traderName = traderName;
		this.symbol = obj.getString("symbol");
		this.openTime = sf.format(new Date(Long.valueOf(obj.getString("open_time")+"000")));
		this.closeTime = sf.format(new Date(Long.valueOf(obj.getString("close_time")+"000")));
		this.openPrice = obj.getString("open_price");
		this.closePrice = obj.getString("close_price");
		this.volume = new BigDecimal(obj.getString("volume").toString()).divide(new BigDecimal("100")).toString();//原值／杠杆值
		this.stopLoss = obj.getString("stop_loss");
		this.takeProfit = obj.getString("take_profit");
		this.profit = new BigDecimal(obj.getString("profit")).add(new BigDecimal(obj.getString("swap"))).toString();//盈利值+库存费用
		this.openStatus = obj.getString("trade_cmd");
		this.openDescribe = obj.getString("order_status2");
		this.closeStatus = obj.getString("status");
        this.closeDescribe = obj.getString("order_status");
        this.content = jsonStr;
	}
	
	public Map<String,String> tradeDataToMap(TradeData data){
		
		return null;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getOriginalOrder() {
		return originalOrder;
	}

	public void setOriginalOrder(String originalOrder) {
		this.originalOrder = originalOrder;
	}

	public String getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(String openPrice) {
		this.openPrice = openPrice;
	}

	public String getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(String closePrice) {
		this.closePrice = closePrice;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getTradeCmd() {
		return tradeCmd;
	}

	public void setTradeCmd(String tradeCmd) {
		this.tradeCmd = tradeCmd;
	}

	public String getStopLoss() {
		return stopLoss;
	}

	public void setStopLoss(String stopLoss) {
		this.stopLoss = stopLoss;
	}

	public String getTakeProfit() {
		return takeProfit;
	}

	public void setTakeProfit(String takeProfit) {
		this.takeProfit = takeProfit;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public String getPriceDigit() {
		return priceDigit;
	}

	public void setPriceDigit(String priceDigit) {
		this.priceDigit = priceDigit;
	}

	public String getOfSsb() {
		return ofSsb;
	}

	public void setOfSsb(String ofSsb) {
		this.ofSsb = ofSsb;
	}

	public String getSwap() {
		return swap;
	}

	public void setSwap(String swap) {
		this.swap = swap;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDemoLiveType() {
		return demoLiveType;
	}

	public void setDemoLiveType(String demoLiveType) {
		this.demoLiveType = demoLiveType;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getMargin() {
		return margin;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public String getCloPrice() {
		return cloPrice;
	}

	public void setCloPrice(String cloPrice) {
		this.cloPrice = cloPrice;
	}

	public String getExchRatio() {
		return exchRatio;
	}

	public void setExchRatio(String exchRatio) {
		this.exchRatio = exchRatio;
	}

	public String getSingleMargin() {
		return singleMargin;
	}

	public void setSingleMargin(String singleMargin) {
		this.singleMargin = singleMargin;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
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

	public String getDigits() {
		return digits;
	}

	public void setDigits(String digits) {
		this.digits = digits;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}

	public String getOpenDescribe() {
		return openDescribe;
	}

	public void setOpenDescribe(String openDescribe) {
		this.openDescribe = openDescribe;
	}

	public String getCloseStatus() {
		return closeStatus;
	}

	public void setCloseStatus(String closeStatus) {
		this.closeStatus = closeStatus;
	}

	public String getCloseDescribe() {
		return closeDescribe;
	}

	public void setCloseDescribe(String closeDescribe) {
		this.closeDescribe = closeDescribe;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSymBrief() {
		return symBrief;
	}

	public void setSymBrief(String symBrief) {
		this.symBrief = symBrief;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMasterLogin() {
		return masterLogin;
	}

	public void setMasterLogin(String masterLogin) {
		this.masterLogin = masterLogin;
	}

	public String getMasterOrderId() {
		return masterOrderId;
	}

	public void setMasterOrderId(String masterOrderId) {
		this.masterOrderId = masterOrderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getCrid() {
		return crid;
	}

	public void setCrid(String crid) {
		this.crid = crid;
	}

	public String getCloseReason() {
		return closeReason;
	}

	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}

	public String getCopySummaryId() {
		return copySummaryId;
	}

	public void setCopySummaryId(String copySummaryId) {
		this.copySummaryId = copySummaryId;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
