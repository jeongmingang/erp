package erp;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erp.ui.DepartmentManagerUI;
import erp.ui.EmployeeManagerUI;
import erp.ui.TitleManagerUI;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnTitle;
	private JButton btnDeprtment;
	private JButton btnEmployee;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 134);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnTitle = new JButton("직책 관리");
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);
		
		btnDeprtment = new JButton("부서 관리");
		btnDeprtment.addActionListener(this);
		contentPane.add(btnDeprtment);
		
		btnEmployee = new JButton("사원 관리");
		btnEmployee.addActionListener(this);
		contentPane.add(btnEmployee);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmployee) {
			actionPerformedBtnEmployee(e);
		}
		if (e.getSource() == btnDeprtment) {
			actionPerformedBtnDeprtment(e);
		}
		if (e.getSource() == btnTitle) {
			actionPerformedBtnTitle(e);
		}
	}
	protected void actionPerformedBtnTitle(ActionEvent e) {
		TitleManagerUI frame = new TitleManagerUI();
		frame.setTitle("직책 관리");
		frame.setVisible(true);
	}
	protected void actionPerformedBtnDeprtment(ActionEvent e) {
		DepartmentManagerUI frame = new DepartmentManagerUI();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnEmployee(ActionEvent e) {
		EmployeeManagerUI frame = new EmployeeManagerUI();
		frame.setVisible(true);
	}
}
