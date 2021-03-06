package com.jeecg.shipdate.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.jeecg.client.entity.ChClientEntity;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 船期
 * @author onlineGenerator
 * @date 2018-08-26 18:14:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "ch_ship_date", schema = "")
@SuppressWarnings("serial")
public class ChShipDateEntity implements java.io.Serializable {
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
	/**船ID*/
	private java.lang.String shipId;
	/**船名*/
	@Excel(name="船名",width=15)
	private java.lang.String shipName;
	/**载重吨数*/
	@Excel(name="载重吨数",width=15)
	private java.lang.Integer shipZaizhong;
	/**空船日期*/
	@Excel(name="空船日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date shipEmptyDate;
	/**日期偏移天数*/
	@Excel(name="日期偏移天数",width=15)
	private java.lang.Integer shipEmptyDateCha;
	/**船图片*/
	@Excel(name="船图片",width=15)
	private java.lang.String shipImg;
	/**空船港*/
	@Excel(name="空船港",width=15)
	private java.lang.String shipFromPort;
	private java.lang.String shipFromPortStr;
	/**目的港*/
	@Excel(name="目的港",width=15)
	private java.lang.String shipToPorts;
	private java.lang.String shipToPortsStr;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String shipNote;
	/**备用装货港*/
	@Excel(name="备用装货港",width=15)
	private java.lang.String shipStayPorts;
	private java.lang.String shipStayPortsStr;
	/**用户ID*/
	private java.lang.String shipClientId;
	/**继续找货*/
	private java.lang.String shipContinue;

	/**关联用户信息*/
	private ChClientEntity client;

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
	 *@return: java.lang.String  船ID
	 */

	@Column(name ="SHIP_ID",nullable=true,length=36)
	public java.lang.String getShipId(){
		return this.shipId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  船ID
	 */
	public void setShipId(java.lang.String shipId){
		this.shipId = shipId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  船名
	 */

	@Column(name ="SHIP_NAME",nullable=true,length=200)
	public java.lang.String getShipName(){
		return this.shipName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  船名
	 */
	public void setShipName(java.lang.String shipName){
		this.shipName = shipName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  载重吨数
	 */

	@Column(name ="SHIP_ZAIZHONG",nullable=true,length=32)
	public java.lang.Integer getShipZaizhong(){
		return this.shipZaizhong;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  载重吨数
	 */
	public void setShipZaizhong(java.lang.Integer shipZaizhong){
		this.shipZaizhong = shipZaizhong;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  空船日期
	 */

	@Column(name ="SHIP_EMPTY_DATE",nullable=true,length=32)
	public java.util.Date getShipEmptyDate(){
		return this.shipEmptyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  空船日期
	 */
	public void setShipEmptyDate(java.util.Date shipEmptyDate){
		this.shipEmptyDate = shipEmptyDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  日期偏移天数
	 */

	@Column(name ="SHIP_EMPTY_DATE_CHA",nullable=true,length=32)
	public java.lang.Integer getShipEmptyDateCha(){
		return this.shipEmptyDateCha;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  日期偏移天数
	 */
	public void setShipEmptyDateCha(java.lang.Integer shipEmptyDateCha){
		this.shipEmptyDateCha = shipEmptyDateCha;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  船图片
	 */

	@Column(name ="SHIP_IMG",nullable=true,length=200)
	public java.lang.String getShipImg(){
		return this.shipImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  船图片
	 */
	public void setShipImg(java.lang.String shipImg){
		this.shipImg = shipImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  空船港
	 */

	@Column(name ="SHIP_FROM_PORT",nullable=true,length=36)
	public java.lang.String getShipFromPort(){
		return this.shipFromPort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  空船港
	 */
	public void setShipFromPort(java.lang.String shipFromPort){
		this.shipFromPort = shipFromPort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  目的港
	 */

	@Column(name ="SHIP_TO_PORTS",nullable=true,length=32)
	public java.lang.String getShipToPorts(){
		return this.shipToPorts;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目的港
	 */
	public void setShipToPorts(java.lang.String shipToPorts){
		this.shipToPorts = shipToPorts;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="SHIP_NOTE",nullable=true,length=300)
	public java.lang.String getShipNote(){
		return this.shipNote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setShipNote(java.lang.String shipNote){
		this.shipNote = shipNote;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用装货港
	 */

	@Column(name ="SHIP_STAY_PORTS",nullable=true,length=32)
	public java.lang.String getShipStayPorts(){
		return this.shipStayPorts;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用装货港
	 */
	public void setShipStayPorts(java.lang.String shipStayPorts){
		this.shipStayPorts = shipStayPorts;
	}

	@Column(name ="ship_client_id",nullable=true,length=36)
	public String getShipClientId() {
		return shipClientId;
	}

	public void setShipClientId(String shipClientId) {
		this.shipClientId = shipClientId;
	}

	@Transient
	public String getShipFromPortStr() {
		return shipFromPortStr;
	}

	public void setShipFromPortStr(String shipFromPortStr) {
		this.shipFromPortStr = shipFromPortStr;
	}

	@Transient
	public String getShipToPortsStr() {
		return shipToPortsStr;
	}

	public void setShipToPortsStr(String shipToPortsStr) {
		this.shipToPortsStr = shipToPortsStr;
	}

	@Transient
	public String getShipStayPortsStr() {
		return shipStayPortsStr;
	}

	public void setShipStayPortsStr(String shipStayPortsStr) {
		this.shipStayPortsStr = shipStayPortsStr;
	}

	@Column(name ="ship_continue",nullable=true,length=32)
	public String getShipContinue() {
		return shipContinue;
	}

	public void setShipContinue(String shipContinue) {
		this.shipContinue = shipContinue;
	}

	@Transient
	public ChClientEntity getClient() {
		return client;
	}

	public void setClient(ChClientEntity client) {
		this.client = client;
	}
}
