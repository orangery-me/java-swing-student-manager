package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.Controller;
import model.Contestant;
import model.Model;
import model.Filter;
import model.Province;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JRadioButton;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Properties;
import java.awt.Font;

class DateLabelFormatter extends AbstractFormatter {

    private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }
}

public class MenuView extends JFrame {
 
	public Model model;
	private JComboBox<String> comboBox;
	private JPanel contentPane;
	private JTable table;
	private JComboBox<String> comboBox_1;
	private JTextField studentIDtextField;
	private JTextField idTextField;
	private JTextField score1TextField;
	private JTextField nameTextField;
	private JTextField score2TextField;
	private JTextField score3TextField;
	private ButtonGroup btg;
	private JDatePickerImpl datePicker;
	private JRadioButton femaleRadioButton;
	private JRadioButton maleRadioButton;

	public MenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 549);
		setLocationRelativeTo(rootPane);
		Controller controller= new Controller(this);
		model= new Model(new ArrayList<Contestant>());
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem openMenuItem = new JMenuItem("Open");
		fileMenu.add(openMenuItem);
		openMenuItem.addActionListener(controller);
		
		JMenuItem saveAsMenuItem = new JMenuItem("Save As");
		fileMenu.add(saveAsMenuItem);
		saveAsMenuItem.addActionListener(controller);

		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exitMenuItem);
		exitMenuItem.addActionListener(controller);
		
		JMenu aboutMenu = new JMenu("About");
		menuBar.add(aboutMenu);
		
		JMenuItem aboutUsMenuItem = new JMenuItem("About us");
		aboutMenu.add(aboutUsMenuItem);
		aboutUsMenuItem.addActionListener(controller);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// FILTER PART
		JLabel provinceLabel = new JLabel("Birth Place: ");
		provinceLabel.setBounds(28, 26, 73, 16);
		contentPane.add(provinceLabel);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"","An Giang", "Bà Rịa – Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Thành phố Hồ Chí Minh", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"}));
		comboBox.setBounds(100, 22, 171, 27);
		contentPane.add(comboBox);
		
		JLabel studentIDLabel = new JLabel("Student ID: ");
		studentIDLabel.setBounds(318, 26, 74, 16);
		contentPane.add(studentIDLabel);
		
		studentIDtextField = new JTextField();
		studentIDtextField.setBounds(395, 21, 141, 26);
		contentPane.add(studentIDtextField);
		studentIDtextField.setColumns(10);
		
		JButton filterButton = new JButton("Filter");
		filterButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		filterButton.setBounds(548, 20, 101, 29);
		contentPane.add(filterButton);
		filterButton.addActionListener(controller);

		JButton undoButton = new JButton("Undo");
		undoButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		undoButton.setBounds(661, 21, 101, 29);
		contentPane.add(undoButton);
		undoButton.addActionListener(controller);
		
		// TABLE 
		table= new JTable();
		table.setFont(new Font("Monospaced", Font.PLAIN, 12));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"No","ID","Name","Birth Place","DOB","Gender","Score 1","Score 2","Score 3"}));
		
		JScrollPane scrollPane= new JScrollPane(table);
		scrollPane.setSize(749, 212);
		scrollPane.setLocation(28, 61);
		contentPane.add(scrollPane);
		
				// INFORMATION PART
				JLabel studentInformationLabel = new JLabel("Student Information");
				studentInformationLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
				studentInformationLabel.setBounds(28, 285, 171, 16);
				contentPane.add(studentInformationLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 313, 749, 124);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 25, 0));
		
		// id
		JLabel idLabel = new JLabel("ID");
		panel.add(idLabel);
		
		idTextField = new JTextField();
		panel.add(idTextField);
		idTextField.setColumns(10);
		
		// score 1
		JLabel score1Label = new JLabel("Score 1");
		panel.add(score1Label);
		
		score1TextField = new JTextField();
		panel.add(score1TextField);
		score1TextField.setColumns(10);
		
		// name
		JLabel nameLabel = new JLabel("Name");
		panel.add(nameLabel);
		
		nameTextField = new JTextField();
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		//score 2
		JLabel score2Label = new JLabel("Score 2");
		panel.add(score2Label);
		
		score2TextField = new JTextField();
		panel.add(score2TextField);
		score2TextField.setColumns(10);
		
		// birthday place
		JLabel birthPlaceLabel = new JLabel("Birth Place");
		panel.add(birthPlaceLabel);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"","An Giang", "Bà Rịa – Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Thành phố Hồ Chí Minh", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"}));
		panel.add(comboBox_1);
		
		//score 3
		JLabel score3Label = new JLabel("Score 3");
		panel.add(score3Label);
		
		score3TextField = new JTextField();
		panel.add(score3TextField);
		score3TextField.setColumns(10);
		
		// display date
		JLabel dateLabel = new JLabel("Date");
		panel.add(dateLabel);
		
		UtilDateModel dateModel = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(dateModel,p);
		datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
		panel.add(datePicker);
		
		JLabel empty_1= new JLabel();
		JLabel empty_2= new JLabel();
		panel.add(empty_1);
		panel.add(empty_2);

		// display gender radio button
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(genderLabel);
		
		btg= new ButtonGroup();
		femaleRadioButton = new JRadioButton("Female");
		btg.add(femaleRadioButton);
		panel.add(femaleRadioButton);
		
		maleRadioButton = new JRadioButton("Male");
		btg.add(maleRadioButton);
		panel.add(maleRadioButton);
		
		// BUTTON PART
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(28, 454, 749, 30);
		contentPane.add(buttonPanel);
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(85, 5, 100, 29);
		addButton.addActionListener(controller);
		buttonPanel.setLayout(null);
		buttonPanel.add(addButton);
		addButton.addActionListener(controller);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(211, 5, 100, 29);
		buttonPanel.add(deleteButton);
		deleteButton.addActionListener(controller);
		
		JButton editButton = new JButton("Edit");
		editButton.setBounds(336, 5, 100, 29);
		buttonPanel.add(editButton);
		editButton.addActionListener(controller);
		
		JButton saveButton = new JButton("Save");
		saveButton.setBounds(463, 5, 100, 29);
		buttonPanel.add(saveButton);
		saveButton.addActionListener(controller);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(598, 5, 100, 29);
		cancelButton.addActionListener(controller);
		buttonPanel.add(cancelButton);

		this.setVisible(true);
	}

	public Contestant getDataFromTextField(){
		String id = idTextField.getText();
		String name = nameTextField.getText();

		String proName = comboBox_1.getSelectedItem().toString();
		Province p = Province.getProvinceByName(proName);

		java.util.Date input = (java.util.Date) datePicker.getModel().getValue();
		LocalDate date = LocalDate.ofInstant(input.toInstant(), ZoneId.systemDefault());
		Double score1 = Double.valueOf(score1TextField.getText());
		Double score2 = Double.valueOf(score2TextField.getText());
		Double score3 = Double.valueOf(score3TextField.getText());

		int gender = 0;
		Enumeration<AbstractButton> buttons = btg.getElements();
		while (buttons.hasMoreElements()) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				if (button.getText().equals("Female"))
					gender = 1;
			}
		}
		Contestant contestant = new Contestant(id, name, p, date, gender, score1, score2, score3);
		return contestant;
	}

	public Contestant getDataFromTable(){
		DefaultTableModel tableModel= (DefaultTableModel) table.getModel();
		int row= table.getSelectedRow();

		String id = tableModel.getValueAt(row,1)+"";
		String name = tableModel.getValueAt(row,2)+"";
		String proName = tableModel.getValueAt(row,3)+"";
		Province p= Province.getProvinceByName(proName);
		String dateString= tableModel.getValueAt(row,4)+"";
		LocalDate date = LocalDate.parse(dateString,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		int gender = Integer.valueOf(tableModel.getValueAt(row,5)+"");
		Double score2 = Double.valueOf(tableModel.getValueAt(row,6)+"");
		Double score1 = Double.valueOf(tableModel.getValueAt(row,7)+"");
		Double score3 = Double.valueOf(tableModel.getValueAt(row,8)+"");

		idTextField.setText(id);
		nameTextField.setText(name);
		comboBox_1.setSelectedItem(p.getProName());
		datePicker.getJFormattedTextField().setText(dateString);
		if (gender==1)
			femaleRadioButton.setSelected(true);
		else
			maleRadioButton.setSelected(true);
		score1TextField.setText(score1+"");
		score2TextField.setText(score2+"");
		score3TextField.setText(score3+"");

		Contestant contestant = new Contestant(id, name, p, date, gender, score1, score2, score3);
		return contestant;
	}

	public void addOrUpdate(Contestant contestant){
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		Contestant c= model.isInContestantList(contestant);

		if (c == null){
			this.model.insert(contestant);
			defaultTableModel.addRow(new Object[] { this.model.getNum(), contestant.getConID(), contestant.getName(), contestant.getProvince().getProName(),
					contestant.getDOB().toString(), contestant.getGender(), contestant.getScore1(), contestant.getScore2(), contestant.getScore3() });
		}
		else{
			c= contestant;
			for (int i=0; i<model.getNum(); i++){
				if (defaultTableModel.getValueAt(i, 1).equals(contestant.getConID())){
					defaultTableModel.setValueAt(c.getName(), i, 2);
					defaultTableModel.setValueAt(c.getProvince().getProName(), i, 3);
					defaultTableModel.setValueAt(c.getDOB().toString(), i, 4);
					defaultTableModel.setValueAt(c.getGender(), i, 5);
					defaultTableModel.setValueAt(c.getScore1(), i, 6);
					defaultTableModel.setValueAt(c.getScore2(), i, 7);
					defaultTableModel.setValueAt(c.getScore3(), i, 8);
				}

			}
		}
	}

	public void eraseForm() {
		idTextField.setText("");
		nameTextField.setText("");
		comboBox_1.setSelectedItem("");
		datePicker.getJFormattedTextField().setText("");
		score1TextField.setText("");
		score2TextField.setText("");
		score3TextField.setText("");
	}
	public void deleteARow(){
		Contestant contestant= this.getDataFromTable();
		model.delete(contestant);

		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int row= table.getSelectedRow();
		defaultTableModel.removeRow(row);
		for (int i=row; i<model.getNum(); ++i){
			defaultTableModel.setValueAt(i+1, i, 0);
		}
	}

	public void printList(ArrayList <Contestant> list){
		int cnt=0;
		DefaultTableModel defaultTableModel= (DefaultTableModel)table.getModel();
		while (defaultTableModel.getRowCount()>0)
			defaultTableModel.removeRow(0);

		for (Contestant contestant : list) 
				defaultTableModel.addRow(new Object[] { ++cnt, contestant.getConID(), contestant.getName(), contestant.getProvince().getProName(),
						contestant.getDOB().toString(), contestant.getGender(), contestant.getScore1(), contestant.getScore2(), contestant.getScore3() });
	}

	public void filter(){
		String proNameSearch= comboBox.getSelectedItem().toString();
		String IDSearch= studentIDtextField.getText();

		if ( !proNameSearch.isEmpty() && !IDSearch.isEmpty())
			printList(Filter.listFound(model.getConList(), Filter.filterByPro(proNameSearch).and(Filter.filterByID(IDSearch))) );
		else{
			if (!IDSearch.isEmpty())
				printList(Filter.listFound(model.getConList(), (Filter.filterByID(IDSearch))));
			else
				printList(Filter.listFound(model.getConList(), (Filter.filterByPro(proNameSearch))));
		}

	}

    public void exit() {
		System.exit(0);
    }

	public void save(String path){
		try {
			this.model.setFileName(path);
			FileOutputStream fos= new FileOutputStream(path);
			ObjectOutputStream oos= new ObjectOutputStream(fos);	
			for (Contestant contestant : model.getConList()) {
				oos.writeObject(contestant);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void saveFileAction() {
		if (!model.getFileName().isEmpty()){
			this.save(model.getFileName());
		}
		else{
			JFileChooser fileChooser = new JFileChooser();
			int choice = fileChooser.showSaveDialog(this);
			if (choice == JFileChooser.APPROVE_OPTION){
				File thisFile = fileChooser.getSelectedFile();
				this.save(thisFile.getAbsolutePath());
			}
		}
    }

	public void open(File file){
		ArrayList<Contestant> conList= new ArrayList<Contestant> ();

		try {
			this.model.setFileName(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Contestant contestant= null;
			while ( (contestant= (Contestant) ois.readObject()) != null){
				conList.add(contestant);
			}
			ois.close();
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}

		this.model.setConList(conList);
		// ArrayList ds = new ArrayList();
		// try {
		// 	this.model.setFileName(file.getAbsolutePath());
		// 	FileInputStream fis = new FileInputStream(file);
		// 	ObjectInputStream ois = new ObjectInputStream(fis);
		// 	Contestant ts = null;
		// 	while((ts = (Contestant) ois.readObject())!=null) {
		// 		ds.add(ts);
		// 	}
		// 	ois.close();
		// } catch (Exception e) {
		// 	System.out.println(e.getMessage());
		// }
		// this.model.setConList(ds);

	}

    public void openFileAction() {
		JFileChooser fileChooser = new JFileChooser();
		int choice = fileChooser.showOpenDialog(this);
		if (choice == JFileChooser.APPROVE_OPTION) {
			File thisFile = fileChooser.getSelectedFile();
			this.open(thisFile);
			printList(model.getConList());
		}

    }
}
