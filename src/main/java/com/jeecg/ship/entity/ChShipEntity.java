package com.jeecg.ship.entity;

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
 * @Description: 船舶信息
 * @author onlineGenerator
 * @date 2018-08-05 15:38:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "ch_ship", schema = "")
@SuppressWarnings("serial")
public class ChShipEntity implements java.io.Serializable {
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
	/**船名*/
	@Excel(name="船名",width=15)
	private java.lang.String shipName;
	/**船舶载重吨*/
	@Excel(name="船舶载重吨",width=15)
	private java.lang.Integer shipZaizhong;
	/**建造日期*/
	@Excel(name="建造日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date shipBuildtime;
	/**满载吃水*/
	@Excel(name="满载吃水",width=15)
	private java.lang.Double shipWater;
	/**船长*/
	@Excel(name="船长",width=15)
	private java.lang.Double shipLength;
	/**船宽*/
	@Excel(name="船宽",width=15)
	private java.lang.Double shipWidth;
	/**船高*/
	@Excel(name="船高",width=15)
	private java.lang.Double shipHigh;
	/**舱口数量*/
	@Excel(name="舱口数量",width=15)
	private java.lang.Integer shipCangCount;
	/**舱口长*/
	@Excel(name="舱口长",width=15)
	private java.lang.Double shipCangLength;
	/**舱口宽*/
	@Excel(name="舱口宽",width=15)
	private java.lang.Double shipCangWidth;
	/**舱口深*/
	@Excel(name="舱口深",width=15)
	private java.lang.Double shipCangDeep;
	/**驾驶舱位置*/
	@Excel(name="驾驶舱位置",width=15)
	private java.lang.String shipDriveLocation;
	/**封舱设备*/
	@Excel(name="封舱设备",width=15)
	private java.lang.String shipFengDevice;
	/**打孔*/
	@Excel(name="打孔",width=15)
	private java.lang.String shipDakong;
	/**水尺*/
	@Excel(name="水尺",width=15)
	private java.lang.String shipShuichi;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String shipNote;
	/**审核状态*/
	@Excel(name="审核状态",width=15)
	private java.lang.String shipAudit;
	
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
	 *@return: java.lang.String  船名
	 */

	@Column(name ="SHIP_NAME",nullable=false,length=100)
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
	 *@return: java.lang.Integer  船舶载重吨
	 */

	@Column(name ="SHIP_ZAIZHONG",nullable=false,length=32)
	public java.lang.Integer getShipZaizhong(){
		return this.shipZaizhong;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  船舶载重吨
	 */
	public void setShipZaizhong(java.lang.Integer shipZaizhong){
		this.shipZaizhong = shipZaizhong;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  建造日期
	 */

	@Column(name ="SHIP_BUILDTIME",nullable=true,length=32)
	public java.util.Date getShipBuildtime(){
		return this.shipBuildtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  建造日期
	 */
	public void setShipBuildtime(java.util.Date shipBuildtime){
		this.shipBuildtime = shipBuildtime;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  满载吃水
	 */

	@Column(name ="SHIP_WATER",nullable=true,scale=3,length=32)
	public java.lang.Double getShipWater(){
		return this.shipWater;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  满载吃水
	 */
	public void setShipWater(java.lang.Double shipWater){
		this.shipWater = shipWater;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  船长
	 */

	@Column(name ="SHIP_LENGTH",nullable=true,scale=2,length=32)
	public java.lang.Double getShipLength(){
		return this.shipLength;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  船长
	 */
	public void setShipLength(java.lang.Double shipLength){
		this.shipLength = shipLength;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  船宽
	 */

	@Column(name ="SHIP_WIDTH",nullable=true,scale=4,length=32)
	public java.lang.Double getShipWidth(){
		return this.shipWidth;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  船宽
	 */
	public void setShipWidth(java.lang.Double shipWidth){
		this.shipWidth = shipWidth;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  船高
	 */

	@Column(name ="SHIP_HIGH",nullable=true,scale=3,length=32)
	public java.lang.Double getShipHigh(){
		return this.shipHigh;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  船高
	 */
	public void setShipHigh(java.lang.Double shipHigh){
		this.shipHigh = shipHigh;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  舱口数量
	 */

	@Column(name ="SHIP_CANG_COUNT",nullable=true,length=32)
	public java.lang.Integer getShipCangCount(){
		return this.shipCangCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  舱口数量
	 */
	public void setShipCangCount(java.lang.Integer shipCangCount){
		this.shipCangCount = shipCangCount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  舱口长
	 */

	@Column(name ="SHIP_CANG_LENGTH",nullable=true,scale=2,length=32)
	public java.lang.Double getShipCangLength(){
		return this.shipCangLength;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  舱口长
	 */
	public void setShipCangLength(java.lang.Double shipCangLength){
		this.shipCangLength = shipCangLength;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  舱口宽
	 */

	@Column(name ="SHIP_CANG_WIDTH",nullable=true,scale=3,length=32)
	public java.lang.Double getShipCangWidth(){
		return this.shipCangWidth;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  舱口宽
	 */
	public void setShipCangWidth(java.lang.Double shipCangWidth){
		this.shipCangWidth = shipCangWidth;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  舱口深
	 */

	@Column(name ="SHIP_CANG_DEEP",nullable=true,scale=3,length=32)
	public java.lang.Double getShipCangDeep(){
		return this.shipCangDeep;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  舱口深
	 */
	public void setShipCangDeep(java.lang.Double shipCangDeep){
		this.shipCangDeep = shipCangDeep;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶舱位置
	 */

	@Column(name ="SHIP_DRIVE_LOCATION",nullable=true,length=32)
	public java.lang.String getShipDriveLocation(){
		return this.shipDriveLocation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶舱位置
	 */
	public void setShipDriveLocation(java.lang.String shipDriveLocation){
		this.shipDriveLocation = shipDriveLocation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  封舱设备
	 */

	@Column(name ="SHIP_FENG_DEVICE",nullable=true,length=32)
	public java.lang.String getShipFengDevice(){
		return this.shipFengDevice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  封舱设备
	 */
	public void setShipFengDevice(java.lang.String shipFengDevice){
		this.shipFengDevice = shipFengDevice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  打孔
	 */

	@Column(name ="SHIP_DAKONG",nullable=true,length=32)
	public java.lang.String getShipDakong(){
		return this.shipDakong;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  打孔
	 */
	public void setShipDakong(java.lang.String shipDakong){
		this.shipDakong = shipDakong;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  水尺
	 */

	@Column(name ="SHIP_SHUICHI",nullable=true,length=32)
	public java.lang.String getShipShuichi(){
		return this.shipShuichi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  水尺
	 */
	public void setShipShuichi(java.lang.String shipShuichi){
		this.shipShuichi = shipShuichi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="SHIP_NOTE",nullable=true,length=32)
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
	 *@return: java.lang.String  审核状态
	 */

	@Column(name ="SHIP_AUDIT",nullable=true,length=32)
	public java.lang.String getShipAudit(){
		return this.shipAudit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核状态
	 */
	public void setShipAudit(java.lang.String shipAudit){
		this.shipAudit = shipAudit;
	}
}