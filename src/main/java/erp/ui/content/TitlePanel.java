package erp.ui.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import erp.dto.Title;
import erp.ui.exception.InvalidCheckException;

@SuppressWarnings("serial")
public class TitlePanel extends AbstractContentPanel<Title>{
	private JTextField tfTNo;
	private JTextField tfTName;

	public TitlePanel() {
		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "직책 정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblTNo = new JLabel("직책번호");
		lblTNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTNo);
		
		tfTNo = new JTextField();
		tfTNo.setColumns(10);
		add(tfTNo);
		
		JLabel lblTname = new JLabel("직책명");
		lblTname.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTname);
		
		tfTName = new JTextField();
		tfTName.setColumns(10);
		add(tfTName);
	}
	
	@Override
	public void clearTf() {
		tfTNo.setText("");
		tfTName.setText("");
		
		if (!tfTNo.isEditable()) {
			tfTNo.setEditable(true);
		}
	}
	
	@Override
	public void setItem(Title item) {
		tfTNo.setText(String.valueOf(item.gettNo()));
		tfTName.setText(item.gettName());
		
		tfTNo.setEditable(false);
	}
	
	@Override
	public Title getItem() {
		validCheck();
		int TNo = Integer.parseInt(tfTNo.getText().trim());
		String TName = tfTName.getText().trim();
		return new Title(TNo, TName);
	}
	
	@Override
	public void validCheck() {
		if(tfTNo.getText().contentEquals("") || tfTName.getText().equals("")) {
			throw new InvalidCheckException();
		}
	}
	
}
