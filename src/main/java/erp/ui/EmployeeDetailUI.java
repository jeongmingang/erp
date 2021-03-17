package erp.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erp.dto.Employee;
import erp.dto.EmployeeDetail;
import erp.service.EmployeeDetailService;
import erp.ui.content.EmployeeDatailPanel;

@SuppressWarnings("serial")
public class EmployeeDetailUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JPanel pBtns;
	private EmployeeDatailPanel pItem;
	private JButton btnAdd;
	private EmployeeDetailService service;
	private JButton btnCancel;

	public EmployeeDetailUI(boolean isBtns, EmployeeDetailService service) {
		this.service = service;
		initialize(isBtns);
	}
	
	private void initialize(boolean isBtns) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 461, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pItem = new EmployeeDatailPanel();
		contentPane.add(pItem, BorderLayout.CENTER);
		
		pBtns = new JPanel();

			contentPane.add(pBtns, BorderLayout.SOUTH);
			
			btnAdd = new JButton();
			btnAdd.addActionListener(this);
			pBtns.add(btnAdd);
			
			btnCancel = new JButton();
			btnCancel.addActionListener(this);
			pBtns.add(btnCancel);
			
			if (isBtns) {
				btnAdd.setText("수정");
				btnCancel.setText("삭제");
			}else {
			contentPane.add(pBtns, BorderLayout.SOUTH);
//			btnUpdate = new JButton("수정");
//			btnUpdate.addActionListener(this);
//			pBtns.add(btnUpdate);
//			
//			btnDel = new JButton("삭제");
//			btnDel.addActionListener(this);
//			pBtns.add(btnDel);
		}
	}
	
	public void setEmpNo(Employee empNo) {
		pItem.setTfEmpno(empNo);
	}
	
	public void setDetailItems(EmployeeDetail empDetail) {
//		btnAdd.setText("수정");
		pItem.setItem(empDetail);
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("삭제")) {
			actionPerformedBtnDel(e);
		}
		if (e.getActionCommand().equals("취소")) {
			actionPerformedBtnCancel(e);
		}
		if (e.getActionCommand().equals("추가")) {
			actionPerformedBtnAdd(e);
		}
		if (e.getActionCommand().equals("수정")) {
			actionPerformedBtnUpdate(e);
		}
	}
	
	private void actionPerformedBtnUpdate(ActionEvent e) {
		EmployeeDetail updateDetail = pItem.getItem();
		service.modifyEmployeeDetail(updateDetail);
		pItem.clearTf();
		JOptionPane.showMessageDialog(null, "수정 완료");
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		//1. 입력된 empDetail 가져오기
		//2. service에 적용하기
		EmployeeDetail newEmpDetail = pItem.getItem();
		service.addEmployeeDetail(newEmpDetail);
		pItem.clearTf();
		JOptionPane.showMessageDialog(null, "추가 완료");
		dispose();
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pItem.clearTf();
		if (btnAdd.getText().contentEquals("수정")) {
			btnAdd.setText("추가");
		}
	}
	protected void actionPerformedBtnDel(ActionEvent e) {
		EmployeeDetail empDetail = pItem.getItem();
		service.removeEmployeeDetail(new Employee(empDetail.getEmpNo()));
		pItem.clearTf();
		JOptionPane.showMessageDialog(null, "삭제 완료");
	}
}