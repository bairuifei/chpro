package com.jeecg.huopan.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 货盘
 * @author onlineGenerator
 * @date 2018-08-09 19:28:19
 * @version V1.0   
 *
 */
@Entity
@Table(name = "ch_huopan", schema = "")
@SuppressWarnings("serial")
public class ChHuopanEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**装货港*/
	@Excel(name="装货港",width=15)
	private java.lang.String huopanBegin;
	/**装货港码头*/
	@Excel(name="装货港码头",width=15)
	private java.lang.String huopanBeginPort;
	/**卸货港*/
	@Excel(name="卸货港",width=15)
	private java.lang.String huopanEnd;
	/**卸货港码头*/
	@Excel(name="卸货港码头",width=15)
	private java.lang.String huopanEndPort;
	/**装货日期*/
	@Excel(name="装货日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date huopanDate;
	/**装货日期误差*/
	@Excel(name="装货日期误差",width=15)
	private java.lang.Integer huopanDateWucha;
	/**货物名称*/
	@Excel(name="货物名称",width=15)
	private java.lang.String huopanName;
	/**货量*/
	@Excel(name="货量",width=15)
	private java.lang.Double huopanCount;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String huopanNote;
	/**空船范围*/
	@Excel(name="空船范围",width=15)
	private java.lang.String huopanShipPosition;
	private java.lang.String huopanShipPositionStr;
	/**船舶载重吨最小*/
	@Excel(name="船舶载重吨最小",width=15)
	private java.lang.Integer huopanShipZaizhongMin;
	/**船舶载重吨最大*/
	@Excel(name="船舶载重吨最大",width=15)
	private java.lang.Integer huopanShipZaizhongMax;
	/**船舶数量*/
	@Excel(name="船舶数量",width=15)
	private java.lang.Integer huopanShipCount;
	/**封舱*/
	@Excel(name="封舱",width=15)
	private java.lang.String huopanShipFengcang;
	/**水尺*/
	@Excel(name="水尺",width=15)
	private java.lang.String huopanShipShuichi;
	/**驾驶舱位置*/
	@Excel(name="驾驶舱位置",width=15)
	private java.lang.String huopanShipDriveLocation;
	/**船口结构*/
	@Excel(name="船口结构",width=15)
	private java.lang.String huopanShipChuankou;
	/**打孔*/
	@Excel(name="打孔",width=15)
	private java.lang.String huopanShipDakong;
	/**吃水*/
	@Excel(name="吃水",width=15)
	private java.lang.String huopanShipChishui;
	/**船长*/
	@Excel(name="船长",width=15)
	private java.lang.String huopanShipLength;
	/**船宽*/
	@Excel(name="船宽",width=15)
	private java.lang.String huopanShipWidth;
	/**船高*/
	@Excel(name="船高",width=15)
	private java.lang.String huopanShipHigh;
	/**舱口长*/
	@Excel(name="舱口长",width=15)
	private java.lang.String huopanShipCangLength;
	/**舱口宽*/
	@Excel(name="舱口宽",width=15)
	private java.lang.String huopanShipCangWidth;
	/**舱口深*/
	@Excel(name="舱口深",width=15)
	private java.lang.String huopanShipCangDeep;
	/**运价*/
	@Excel(name="运价",width=15)
	private java.math.BigDecimal huopanFeeYun;
	/**开航费*/
	@Excel(name="开航费",width=15)
	private java.math.BigDecimal huopanFeeKaihang;
	/**滞期费*/
	@Excel(name="滞期费",width=15)
	private java.math.BigDecimal huopanFeeZhiqi;
	/**两港装卸时间*/
	@Excel(name="两港装卸时间",width=15)
	private java.lang.String huopanFeeLoadtime;
	/**结算方式*/
	@Excel(name="结算方式",width=15)
	private java.lang.String huopanFeeJstype;
	/**付款方式*/
	@Excel(name="付款方式",width=15)
	private java.lang.String huopanFeePaytype;
	/**审核状态*/
	private java.lang.String huopanAudit;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */

	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装货港
	 */

	@Column(name ="HUOPAN_BEGIN",nullable=true,length=36)
	public java.lang.String getHuopanBegin(){
		return this.huopanBegin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装货港
	 */
	public void setHuopanBegin(java.lang.String huopanBegin){
		this.huopanBegin = huopanBegin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装货港码头
	 */

	@Column(name ="HUOPAN_BEGIN_PORT",nullable=true,length=32)
	public java.lang.String getHuopanBeginPort(){
		return this.huopanBeginPort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装货港码头
	 */
	public void setHuopanBeginPort(java.lang.String huopanBeginPort){
		this.huopanBeginPort = huopanBeginPort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  卸货港
	 */

	@Column(name ="HUOPAN_END",nullable=true,length=36)
	public java.lang.String getHuopanEnd(){
		return this.huopanEnd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卸货港
	 */
	public void setHuopanEnd(java.lang.String huopanEnd){
		this.huopanEnd = huopanEnd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  卸货港码头
	 */

	@Column(name ="HUOPAN_END_PORT",nullable=true,length=32)
	public java.lang.String getHuopanEndPort(){
		return this.huopanEndPort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卸货港码头
	 */
	public void setHuopanEndPort(java.lang.String huopanEndPort){
		this.huopanEndPort = huopanEndPort;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  装货日期
	 */

	@Column(name ="HUOPAN_DATE",nullable=true,length=32)
	public java.util.Date getHuopanDate(){
		return this.huopanDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  装货日期
	 */
	public void setHuopanDate(java.util.Date huopanDate){
		this.huopanDate = huopanDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  装货日期误差
	 */

	@Column(name ="HUOPAN_DATE_WUCHA",nullable=true,length=32)
	public java.lang.Integer getHuopanDateWucha(){
		return this.huopanDateWucha;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  装货日期误差
	 */
	public void setHuopanDateWucha(java.lang.Integer huopanDateWucha){
		this.huopanDateWucha = huopanDateWucha;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  货物名称
	 */

	@Column(name ="HUOPAN_NAME",nullable=true,length=32)
	public java.lang.String getHuopanName(){
		return this.huopanName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货物名称
	 */
	public void setHuopanName(java.lang.String huopanName){
		this.huopanName = huopanName;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  货量
	 */

	@Column(name ="HUOPAN_COUNT",nullable=true,length=32)
	public java.lang.Double getHuopanCount(){
		return this.huopanCount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  货量
	 */
	public void setHuopanCount(java.lang.Double huopanCount){
		this.huopanCount = huopanCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="HUOPAN_NOTE",nullable=true,length=200)
	public java.lang.String getHuopanNote(){
		return this.huopanNote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setHuopanNote(java.lang.String huopanNote){
		this.huopanNote = huopanNote;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  空船范围
	 */

	@Column(name ="HUOPAN_SHIP_POSITION",nullable=true,length=300)
	public java.lang.String getHuopanShipPosition(){
		return this.huopanShipPosition;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  空船范围
	 */
	public void setHuopanShipPosition(java.lang.String huopanShipPosition){
		this.huopanShipPosition = huopanShipPosition;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  船舶载重吨最小
	 */

	@Column(name ="HUOPAN_SHIP_ZAIZHONG_MIN",nullable=true,length=32)
	public java.lang.Integer getHuopanShipZaizhongMin(){
		return this.huopanShipZaizhongMin;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  船舶载重吨最小
	 */
	public void setHuopanShipZaizhongMin(java.lang.Integer huopanShipZaizhongMin){
		this.huopanShipZaizhongMin = huopanShipZaizhongMin;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  船舶载重吨最大
	 */

	@Column(name ="HUOPAN_SHIP_ZAIZHONG_MAX",nullable=true,length=32)
	public java.lang.Integer getHuopanShipZaizhongMax(){
		return this.huopanShipZaizhongMax;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  船舶载重吨最大
	 */
	public void setHuopanShipZaizhongMax(java.lang.Integer huopanShipZaizhongMax){
		this.huopanShipZaizhongMax = huopanShipZaizhongMax;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  船舶数量
	 */

	@Column(name ="HUOPAN_SHIP_COUNT",nullable=true,length=32)
	public java.lang.Integer getHuopanShipCount(){
		return this.huopanShipCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  船舶数量
	 */
	public void setHuopanShipCount(java.lang.Integer huopanShipCount){
		this.huopanShipCount = huopanShipCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  封舱
	 */

	@Column(name ="HUOPAN_SHIP_FENGCANG",nullable=true,length=32)
	public java.lang.String getHuopanShipFengcang(){
		return this.huopanShipFengcang;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  封舱
	 */
	public void setHuopanShipFengcang(java.lang.String huopanShipFengcang){
		this.huopanShipFengcang = huopanShipFengcang;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  水尺
	 */

	@Column(name ="HUOPAN_SHIP_SHUICHI",nullable=true,length=32)
	public java.lang.String getHuopanShipShuichi(){
		return this.huopanShipShuichi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  水尺
	 */
	public void setHuopanShipShuichi(java.lang.String huopanShipShuichi){
		this.huopanShipShuichi = huopanShipShuichi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶舱位置
	 */

	@Column(name ="HUOPAN_SHIP_DRIVE_LOCATION",nullable=true,length=32)
	public java.lang.String getHuopanShipDriveLocation(){
		return this.huopanShipDriveLocation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶舱位置
	 */
	public void setHuopanShipDriveLocation(java.lang.String huopanShipDriveLocation){
		this.huopanShipDriveLocation = huopanShipDriveLocation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  船口结构
	 */

	@Column(name ="HUOPAN_SHIP_CHUANKOU",nullable=true,length=32)
	public java.lang.String getHuopanShipChuankou(){
		return this.huopanShipChuankou;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  船口结构
	 */
	public void setHuopanShipChuankou(java.lang.String huopanShipChuankou){
		this.huopanShipChuankou = huopanShipChuankou;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  打孔
	 */

	@Column(name ="HUOPAN_SHIP_DAKONG",nullable=true,length=32)
	public java.lang.String getHuopanShipDakong(){
		return this.huopanShipDakong;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  打孔
	 */
	public void setHuopanShipDakong(java.lang.String huopanShipDakong){
		this.huopanShipDakong = huopanShipDakong;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  吃水
	 */

	@Column(name ="HUOPAN_SHIP_CHISHUI",nullable=true,length=32)
	public java.lang.String getHuopanShipChishui(){
		return this.huopanShipChishui;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  吃水
	 */
	public void setHuopanShipChishui(java.lang.String huopanShipChishui){
		this.huopanShipChishui = huopanShipChishui;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  船长
	 */

	@Column(name ="HUOPAN_SHIP_LENGTH",nullable=true,length=32)
	public java.lang.String getHuopanShipLength(){
		return this.huopanShipLength;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  船长
	 */
	public void setHuopanShipLength(java.lang.String huopanShipLength){
		this.huopanShipLength = huopanShipLength;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  船宽
	 */

	@Column(name ="HUOPAN_SHIP_WIDTH",nullable=true,length=32)
	public java.lang.String getHuopanShipWidth(){
		return this.huopanShipWidth;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  船宽
	 */
	public void setHuopanShipWidth(java.lang.String huopanShipWidth){
		this.huopanShipWidth = huopanShipWidth;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  船高
	 */

	@Column(name ="HUOPAN_SHIP_HIGH",nullable=true,length=32)
	public java.lang.String getHuopanShipHigh(){
		return this.huopanShipHigh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  船高
	 */
	public void setHuopanShipHigh(java.lang.String huopanShipHigh){
		this.huopanShipHigh = huopanShipHigh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  舱口长
	 */

	@Column(name ="HUOPAN_SHIP_CANG_LENGTH",nullable=true,length=32)
	public java.lang.String getHuopanShipCangLength(){
		return this.huopanShipCangLength;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  舱口长
	 */
	public void setHuopanShipCangLength(java.lang.String huopanShipCangLength){
		this.huopanShipCangLength = huopanShipCangLength;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  舱口宽
	 */

	@Column(name ="HUOPAN_SHIP_CANG_WIDTH",nullable=true,length=32)
	public java.lang.String getHuopanShipCangWidth(){
		return this.huopanShipCangWidth;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  舱口宽
	 */
	public void setHuopanShipCangWidth(java.lang.String huopanShipCangWidth){
		this.huopanShipCangWidth = huopanShipCangWidth;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  舱口深
	 */

	@Column(name ="HUOPAN_SHIP_CANG_DEEP",nullable=true,length=32)
	public java.lang.String getHuopanShipCangDeep(){
		return this.huopanShipCangDeep;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  舱口深
	 */
	public void setHuopanShipCangDeep(java.lang.String huopanShipCangDeep){
		this.huopanShipCangDeep = huopanShipCangDeep;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  运价
	 */

	@Column(name ="HUOPAN_FEE_YUN",nullable=true,length=32)
	public java.math.BigDecimal getHuopanFeeYun(){
		return this.huopanFeeYun;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  运价
	 */
	public void setHuopanFeeYun(java.math.BigDecimal huopanFeeYun){
		this.huopanFeeYun = huopanFeeYun;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  开航费
	 */

	@Column(name ="HUOPAN_FEE_KAIHANG",nullable=true,length=32)
	public java.math.BigDecimal getHuopanFeeKaihang(){
		return this.huopanFeeKaihang;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  开航费
	 */
	public void setHuopanFeeKaihang(java.math.BigDecimal huopanFeeKaihang){
		this.huopanFeeKaihang = huopanFeeKaihang;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  滞期费
	 */

	@Column(name ="HUOPAN_FEE_ZHIQI",nullable=true,length=32)
	public java.math.BigDecimal getHuopanFeeZhiqi(){
		return this.huopanFeeZhiqi;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  滞期费
	 */
	public void setHuopanFeeZhiqi(java.math.BigDecimal huopanFeeZhiqi){
		this.huopanFeeZhiqi = huopanFeeZhiqi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  两港装卸时间
	 */

	@Column(name ="HUOPAN_FEE_LOADTIME",nullable=true,length=32)
	public java.lang.String getHuopanFeeLoadtime(){
		return this.huopanFeeLoadtime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  两港装卸时间
	 */
	public void setHuopanFeeLoadtime(java.lang.String huopanFeeLoadtime){
		this.huopanFeeLoadtime = huopanFeeLoadtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算方式
	 */

	@Column(name ="HUOPAN_FEE_JSTYPE",nullable=true,length=32)
	public java.lang.String getHuopanFeeJstype(){
		return this.huopanFeeJstype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算方式
	 */
	public void setHuopanFeeJstype(java.lang.String huopanFeeJstype){
		this.huopanFeeJstype = huopanFeeJstype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款方式
	 */

	@Column(name ="HUOPAN_FEE_PAYTYPE",nullable=true,length=32)
	public java.lang.String getHuopanFeePaytype(){
		return this.huopanFeePaytype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款方式
	 */
	public void setHuopanFeePaytype(java.lang.String huopanFeePaytype){
		this.huopanFeePaytype = huopanFeePaytype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核状态
	 */

	@Column(name ="HUOPAN_AUDIT",nullable=true,length=32)
	public java.lang.String getHuopanAudit(){
		return this.huopanAudit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核状态
	 */
	public void setHuopanAudit(java.lang.String huopanAudit){
		this.huopanAudit = huopanAudit;
	}

	@Transient
	public String getHuopanShipPositionStr() {
		return huopanShipPositionStr;
	}

	public void setHuopanShipPositionStr(String huopanShipPositionStr) {
		this.huopanShipPositionStr = huopanShipPositionStr;
	}
}
