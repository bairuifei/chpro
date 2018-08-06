package com.jeecg.client.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 用户表
 * @author onlineGenerator
 * @date 2018-08-01 18:22:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "ch_client", schema = "")
@SuppressWarnings("serial")
public class ChClientEntity implements java.io.Serializable {
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
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String clientName;
	/**性别*/
	@Excel(name="性别",width=15)
	private java.lang.String clientSex;
	/**手机号码*/
	@Excel(name="手机号码",width=15)
	private java.lang.String clientMobile;
	/**登录密码*/
	private java.lang.String clientPwd;
	/**微信openID*/
	private java.lang.String clientOpenid;
	/**公众号*/
	private java.lang.String clientGzwx;
	/**头像*/
	@Excel(name="头像",width=15)
	private java.lang.String clientHeadimg;
	/**真实姓名*/
	@Excel(name="真实姓名",width=15)
	private java.lang.String clientRealname;
	/**身份证号*/
	@Excel(name="身份证号",width=15)
	private java.lang.String clientCreditid;
	/**是否VIP*/
	@Excel(name="是否VIP",width=15)
	private java.lang.String clientVip;
	/**VIP截止时间*/
	@Excel(name="VIP截止时间",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date clientVipend;
	
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
	 *@return: java.lang.String  姓名
	 */

	@Column(name ="CLIENT_NAME",nullable=false,length=32)
	public java.lang.String getClientName(){
		return this.clientName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setClientName(java.lang.String clientName){
		this.clientName = clientName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */

	@Column(name ="CLIENT_SEX",nullable=false,length=32)
	public java.lang.String getClientSex(){
		return this.clientSex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setClientSex(java.lang.String clientSex){
		this.clientSex = clientSex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号码
	 */

	@Column(name ="CLIENT_MOBILE",nullable=false,length=32)
	public java.lang.String getClientMobile(){
		return this.clientMobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号码
	 */
	public void setClientMobile(java.lang.String clientMobile){
		this.clientMobile = clientMobile;
	}

	@Column(name ="CLIENT_PWD",nullable=false,length=32)
	public String getClientPwd() {
		return clientPwd;
	}

	public void setClientPwd(String clientPwd) {
		this.clientPwd = clientPwd;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信openID
	 */

	@Column(name ="CLIENT_OPENID",nullable=true,length=255)
	public java.lang.String getClientOpenid(){
		return this.clientOpenid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信openID
	 */
	public void setClientOpenid(java.lang.String clientOpenid){
		this.clientOpenid = clientOpenid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公众号
	 */

	@Column(name ="CLIENT_GZWX",nullable=true,length=32)
	public java.lang.String getClientGzwx(){
		return this.clientGzwx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公众号
	 */
	public void setClientGzwx(java.lang.String clientGzwx){
		this.clientGzwx = clientGzwx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像
	 */

	@Column(name ="CLIENT_HEADIMG",nullable=true,length=255)
	public java.lang.String getClientHeadimg(){
		return this.clientHeadimg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像
	 */
	public void setClientHeadimg(java.lang.String clientHeadimg){
		this.clientHeadimg = clientHeadimg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  真实姓名
	 */

	@Column(name ="CLIENT_REALNAME",nullable=true,length=32)
	public java.lang.String getClientRealname(){
		return this.clientRealname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  真实姓名
	 */
	public void setClientRealname(java.lang.String clientRealname){
		this.clientRealname = clientRealname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */

	@Column(name ="CLIENT_CREDITID",nullable=true,length=100)
	public java.lang.String getClientCreditid(){
		return this.clientCreditid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setClientCreditid(java.lang.String clientCreditid){
		this.clientCreditid = clientCreditid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否VIP
	 */

	@Column(name ="CLIENT_VIP",nullable=true,length=32)
	public java.lang.String getClientVip(){
		return this.clientVip;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否VIP
	 */
	public void setClientVip(java.lang.String clientVip){
		this.clientVip = clientVip;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  VIP截止时间
	 */

	@Column(name ="CLIENT_VIPEND",nullable=true,length=32)
	public java.util.Date getClientVipend(){
		return this.clientVipend;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  VIP截止时间
	 */
	public void setClientVipend(java.util.Date clientVipend){
		this.clientVipend = clientVipend;
	}
}