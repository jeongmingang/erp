package erp.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import erp.dto.Employee;
import erp.dto.EmployeeDetail;
import erp.service.EmployeeService;
import erp.ui.content.AbstractContentPanel;
import erp.ui.content.EmployeeDatailPanel;
import erp.ui.content.EmployeePanel;
import erp.ui.list.AbstractCustomTablePanel;
import erp.ui.list.EmployeeTablePanel;

@SuppressWarnings("serial")
public class EmployeeManagerUI extends AbstractManagerUI<Employee> {
	private EmployeeService service;
	
	public EmployeeManagerUI() {
	}
	
	@Override
	protected void setService() {
		service = new EmployeeService();
	}

	@Override
	protected void tableLoadData() {
		((EmployeeTablePanel)pList).setService(service);
		pList.loadData();
	}

	@Override
	protected AbstractContentPanel<Employee> createContentPanel() {
		EmployeePanel empPanel = new EmployeePanel();
		empPanel.setService(service);
		return empPanel;
	}

	@Override
	protected AbstractCustomTablePanel<Employee> createTablePanel() {
		return new EmployeeTablePanel();
	}

	@Override
	protected void actionPerformedMenuGubun() {
//		throw new UnsupportedOperationException("제공되지 않는 메소드입니다.");
		Employee item = pList.getItem();
		
		EmployeeDetail empDetail = service.showEmpDetailByEmpNo(item);
		if (empDetail == null) {
			JOptionPane.showMessageDialog(null, "해당 정보가 없음");
		}
		
		EmployeeDatailPanel subDetailPanel = new EmployeeDatailPanel();
		subDetailPanel.setItem(empDetail);
		
		JFrame empDetailFrame = new JFrame("사원 세부정보");
		empDetailFrame.setBounds(10, 10, 450, 600);
		empDetailFrame.getContentPane().add(subDetailPanel, BorderLayout.CENTER);
		empDetailFrame.setVisible(true);
		
	}

	@Override
	protected void actionPerformedMenuUpdate() {
		Employee updateEmp = pList.getItem();
		pContent.setItem(updateEmp);
		btnAdd.setText("수정");
	}

	@Override
	protected void actionPerformedMenuDelete() {
		Employee delEmp = pList.getItem();
		service.removeEmployee(delEmp);
		pList.loadData();
		JOptionPane.showMessageDialog(null, delEmp + "삭제 되었습니다.");
	}

	@Override
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Employee updateEmp = pContent.getItem();
		service.modifyEmployee(updateEmp);
		pList.loadData();
		pContent.clearTf();
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, updateEmp.getEmpName() + "정보가 수정되었습니다.");
	}

	@Override
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Employee addEmp = pContent.getItem();
		service.addEmployee(addEmp);
		pList.loadData();
		pContent.clearTf();
		JOptionPane.showMessageDialog(null, addEmp + " 추가했습니다.");
	}

}
