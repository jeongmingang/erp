package erp.dto;

import java.util.Arrays;
import java.util.Date;

public class EmpDetail {
	private int empNo;
	private boolean gender;
	private Date hisDate;
	private byte[] plc;
	
	public EmpDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public EmpDetail(int empNo) {
		this.empNo = empNo;
	}
	
	public EmpDetail(int empNo, boolean gender, Date hisDate, byte[] plc) {
		this.empNo = empNo;
		this.gender = gender;
		this.hisDate = hisDate;
		this.plc = plc;
	}
	
	public int getEmpNo() {
		return empNo;
	}
	
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	
	public boolean isGender() {
		return gender;
	}
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	public Date getHisDate() {
		return hisDate;
	}
	
	public void setHisDate(Date hisDate) {
		this.hisDate = hisDate;
	}
	
	public byte[] getPlc() {
		return plc;
	}
	
	public void setPlc(byte[] plc) {
		this.plc = plc;
	}
	
	@Override
	public String toString() {
		return String.format("EmpDetail [empNo=%s, gender=%s, hisDate=%s, plc=%s]", empNo, gender, hisDate,
				Arrays.toString(plc));
	}
}
