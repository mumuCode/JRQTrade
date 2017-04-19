package com.ch.jrq.domain;

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
    private String tradeCmd; //交易命令 1: 2:  3:挂单
    private String stopLoss; // 止损 sl
    private String takeProfit; // 止盈 tp
    private String profit; //盈利 3.3709958
    private String priceDigit;// 价格数字 2
    private String ofSsb;
    private String swap;//库存费用
    private String type;//类型
    private String status;//状态 0:持有 3:关闭
    private String demoLiveType;
    private String direction;//方向 BUY
    private String margin;// 50.3144
	private String commission; //委托 0
	private String cloPrice;//平仓价格 1257.0172
	private String exchRatio;//交易比率
	private String singleMargin;//单一盈利 50.3144
	private String cmd;//命令 3:撤单
	private String sl; //止损价格
	private String tp; //止盈价格
	private String digits;//数字 2
	private String state; //状态 0 3:关闭
	private String orderStatus; //订单状态 卖出
	private String order_status2; //订单状态2 卖出
	private String symBrief; //系统概要 XAUUSD
	
	//关闭订单(与持仓订单数据不同的字段)
	private String login; //22788916
	private String masterLogin; //0
	private String masterOrderId; //0
    private String orderType; //1
    private String crid;
    private String closeReason; //1
    private String copySummaryId; //摘要
    	
	/*金融圈改版数据字段有变更
	private String trOrder; //订单号
	private String copiedOrder; //复制订单
	private String copiedOrderType; //复制订单类型
	private String copiedCount; //复制总数
	private String isAuto; //是否自动
	private String isFromCopier;
	private String utype;	
	private String valueDate;
	private String expiration; //截止
	private String convReserv;
	private String convRates0; //转换费率0
	private String conv_rates1; //转换费率1
	private String commissionAgent; //委托人
	private String storage; //存储 -7.910000	
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
	private String orderStatus2; //订单状态：买入，卖出，挂单卖出，挂单买入 买入
	private String symName; //系统名称 现货黄金*/
	
	//功能开发新增
	private String traderId; //牛人ID
	private String traderName;//牛人名称
	private Integer traderStatus;//牛人状态

}
