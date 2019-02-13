package cn.itcast.domain;

public class Customer {
	
	/*
	 * CREATE TABLE `cst_customer` (
	  `cust_id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '�ͻ����(����)',1
	  `cust_name` VARCHAR(32) NOT NULL COMMENT '�ͻ�����(��˾����)',1
	  `cust_industry` VARCHAR(32) DEFAULT NULL COMMENT '�ͻ�������ҵ',
	  `cust_level` VARCHAR(32) DEFAULT NULL COMMENT '�ͻ�����',1
	  `cust_linkman` VARCHAR(64) DEFAULT NULL COMMENT '��ϵ��',1
	  `cust_linkman_mobile` VARCHAR(32) DEFAULT NULL COMMENT '��ϵ�˵绰',1
	  `cust_phone` VARCHAR(64) DEFAULT NULL COMMENT '�̶��绰',1
	  `cust_mobile` VARCHAR(16) DEFAULT NULL COMMENT '�ƶ��绰',1
	  PRIMARY KEY (`cust_id`)
	) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
	 */
	private Integer cust_id;
	
	private String cust_name;
	private String cust_linkman_mobile;
	private String cust_industry;
	private String cust_level;
	private String cust_linkman;
	private String cust_phone;
	private String cust_mobile;
	
	public Integer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	
	public String getCust_linkman_mobile() {
		return cust_linkman_mobile;
	}
	public void setCust_linkman_mobile(String cust_linkman_mobile) {
		this.cust_linkman_mobile = cust_linkman_mobile;
	}
	public String getCust_industry() {
		return cust_industry;
	}
	public void setCust_industry(String cust_industry) {
		this.cust_industry = cust_industry;
	}
	public String getCust_level() {
		return cust_level;
	}
	public void setCust_level(String cust_level) {
		this.cust_level = cust_level;
	}
	public String getCust_linkman() {
		return cust_linkman;
	}
	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_linkman_mobile="
				+ cust_linkman_mobile + ", cust_industry=" + cust_industry + ", cust_level=" + cust_level
				+ ", cust_linkman=" + cust_linkman + ", cust_phone=" + cust_phone + ", cust_mobile=" + cust_mobile
				+ "]";
	}
	
	
	
}
