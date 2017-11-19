import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class MarinaGUI extends JFrame{
	
	String[] customerColumnNames = {"Customer ID", "First Name", "Last Name", "Payment Info", "Phone Number", "Street Address", "City", "State", "ZIP Code"};
	String[] boatColumnNames = {"Vin","Customer ID", "Make", "Model", "Color","Is Powered Boat"};
	String[] slipColumnNames = {"Slip ID", "Is Powered Slip?", "Is Occupied?"};
	String[] leaseColumnNames = {"Lease ID","Customer ID", "Vin","Slip ID","Lease Start Date", "Lease End Date"};
	
	private JButton createButton = new JButton("Create");
	private JButton deleteButton = new JButton("Delete");
	private JButton findButton = new JButton("Find");
	private JButton updateButton = new JButton("Update");
	
	private JLabel customerIDLB = new JLabel("Customer ID", SwingConstants.RIGHT);
	private JLabel fnameLB = new JLabel("First Name", SwingConstants.RIGHT);
	private JLabel lnameLB = new JLabel("Last Name", SwingConstants.RIGHT);
	private JLabel paymentLB = new JLabel("Payment Info", SwingConstants.RIGHT);
	private JLabel phoneLB = new JLabel("Phone Number", SwingConstants.RIGHT);
	private JLabel streetLB = new JLabel("Street", SwingConstants.RIGHT);
	private JLabel cityLB = new JLabel("City", SwingConstants.RIGHT);
	private JLabel stateLB = new JLabel("State", SwingConstants.RIGHT);
	private JLabel zipcodeLB = new JLabel("Zip Code", SwingConstants.RIGHT);
	
	private JTextField customerIDTF = new JTextField(25);
	private JTextField fnameTF = new JTextField(25);
	private JTextField lnameTF = new JTextField(25);
	private JTextField paymentTF = new JTextField(25);
	private JTextField phoneTF = new JTextField(25);
	private JTextField streetTF = new JTextField(25);
	private JTextField cityTF = new JTextField(25);
	private JTextField stateTF = new JTextField(25);
	private JTextField zipcodeTF = new JTextField(25);
	
	
	private JPanel contentPanel = new JPanel();
	private JPanel tablePanel = new JPanel();
	private JPanel buttonPanel = new JPanel(new GridLayout(4,1,1,5));
	private JPanel searchPanel = new JPanel();
	
	private JPanel customerPanel = new JPanel();
	//customerPanel.add(JLabel,JTextField..)
	
	private JPanel boatPanel = new JPanel();
	private JPanel slipPanel = new JPanel();
	private JPanel leasePanel = new JPanel();
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	
	//private DefaultTableModel customerModel = new DefaultTableModel(customerColumnNames, 0);
	//private JTable customerTable = new JTable(customerModel);
	
	Object[][] boatData = {
				    {"MAI5NS6TF708", "1","Ranger","Rt 188","White",new Boolean(true)},
				    {"ABC67689B606", "2","Wellcraft", "Martinique 3000","Black/Red", new Boolean(false)}
	};		
	private JTable boatTable = new JTable(boatData, boatColumnNames);
	
	Object[][] slipData = {
		    {"1A", new Boolean(true), new Boolean(true)},
		    {"1B", new Boolean(false), new Boolean(false)},
		    {"2A", new Boolean(false), new Boolean(false)},
		    {"2B", new Boolean(false), new Boolean(false)},
		    {"3A", new Boolean(true), new Boolean(false)},
		    {"3B", new Boolean(false), new Boolean(true)}
	};	
	private JTable slipTable = new JTable(slipData, slipColumnNames);
	
	Object[][] leaseData = {
		    {"001", "1", "MAI5NS6TF708", "1A","11/5/2017","11/6/2017"},
		    {"002", "2", "ABC67689B606", "3B","7/5/2017","12/28/2017"}
	};	
	private JTable leaseTable = new JTable(leaseData, leaseColumnNames);
	
	private void buildGUI(){
		customerPanel.setLayout(new GridLayout(9,2,1,1));
		
		customerPanel.add(customerIDLB);
		customerPanel.add(customerIDTF);
		
		customerPanel.add(fnameLB);
		customerPanel.add(fnameTF);
		
		customerPanel.add(lnameLB);
		customerPanel.add(lnameTF);
		
		customerPanel.add(paymentLB);
		customerPanel.add(paymentTF);
		
		customerPanel.add(phoneLB);
		customerPanel.add(phoneTF);
		
		customerPanel.add(streetLB);
		customerPanel.add(streetTF);
		
		customerPanel.add(cityLB);
		customerPanel.add(cityTF);
		
		customerPanel.add(stateLB);
		customerPanel.add(stateTF);
		
		customerPanel.add(zipcodeLB);	
		customerPanel.add(zipcodeTF);
		
		createButton.addActionListener(new ActionListen());
		
		
		//customerPanel.add(customerTable);
		//customerPanel.setLayout(new BorderLayout());
		//customerPanel.add(customerTable.getTableHeader(), BorderLayout.PAGE_START);
		//customerPanel.add(customerTable, BorderLayout.CENTER);
		
		
		tabbedPane.addTab("Customers", customerPanel);
		
		tabbedPane.addTab("Boats", boatPanel);
		boatPanel.setLayout(new BorderLayout());
		boatPanel.add(boatTable.getTableHeader(), BorderLayout.PAGE_START);
		boatPanel.add(boatTable, BorderLayout.CENTER);
		
		tabbedPane.addTab("Slips", slipPanel);
		slipPanel.setLayout(new BorderLayout());
		slipPanel.add(slipTable.getTableHeader(), BorderLayout.PAGE_START);
		slipPanel.add(slipTable, BorderLayout.CENTER);
		
		tabbedPane.addTab("Leases", leasePanel);
		leasePanel.setLayout(new BorderLayout());
		leasePanel.add(leaseTable.getTableHeader(), BorderLayout.PAGE_START);
		leasePanel.add(leaseTable, BorderLayout.CENTER);
		
		tabbedPane.setUI(new BasicTabbedPaneUI() {
	        private final Insets borderInsets = new Insets(0, 0, 0, 0);
	        @Override
	        protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
	        }
	        @Override
	        protected Insets getContentBorderInsets(int tabPlacement) {
	            return borderInsets;
	        }
	    });

		tablePanel.add(tabbedPane);
		
		buttonPanel.add(findButton);
		buttonPanel.add(createButton);
		buttonPanel.add(updateButton);
		buttonPanel.add(deleteButton);

		contentPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.gridwidth = 10;
		constraints.gridheight = 10;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.ipadx = 500;
		contentPanel.add(tabbedPane, constraints);
		
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.ipadx = 0;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 11;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		contentPanel.add(buttonPanel, constraints);
		add(contentPanel);
	}
	
	private class ActionListen implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			if(tabbedPane.getSelectedIndex() == 0)
			{	
				if(e.getSource() == findButton)
				{	
					System.out.println("Find button is clicked");
				}
				else if(e.getSource() == createButton)
				{
					
				}
				else if(e.getSource() == updateButton)
				{
					
				}
				else if(e.getSource() == deleteButton)
				{
					
				}
				else
				{
					
				}			
			}
			
			else if(tabbedPane.getSelectedIndex() == 1)
			{	
				if(e.getSource() == findButton)
				{	
					System.out.println("Find button is clicked");
				}
				else if(e.getSource() == createButton)
				{
					
				}
				else if(e.getSource() == updateButton)
				{
					
				}
				else if(e.getSource() == deleteButton)
				{
					
				}
				else
				{
					
				}			
			}
			
			else if(tabbedPane.getSelectedIndex() == 2)
			{	
				if(e.getSource() == findButton)
				{	
					System.out.println("Find button is clicked");
				}
				else if(e.getSource() == createButton)
				{
					
				}
				else if(e.getSource() == updateButton)
				{
					
				}
				else if(e.getSource() == deleteButton)
				{
					
				}
				else
				{
					
				}			
			}
			
			else if(tabbedPane.getSelectedIndex() == 3)
			{	
				if(e.getSource() == findButton)
				{	
					System.out.println("Find button is clicked");
				}
				else if(e.getSource() == createButton)
				{
					
				}
				else if(e.getSource() == updateButton)
				{
					
				}
				else if(e.getSource() == deleteButton)
				{
					
				}
				else
				{
					
				}			
			}
			
			else
			{
				
			}
		}		
	}
	
	public MarinaGUI(){
		super("Marina");
		setLayout(new GridLayout(1, 2, 1, 1));
		buildGUI();
		setSize(768,512);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MarinaGUI gui = new MarinaGUI();
		DatabaseManager db = new DatabaseManager();
		//db.findAllCustomers();
	}

}