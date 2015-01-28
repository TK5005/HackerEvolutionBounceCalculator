import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EvolutionView extends JFrame implements ActionListener, ChangeListener {

	public EvolutionCalculator calculator = new EvolutionCalculator();
	
	private static final long serialVersionUID = 1L;
	
	private int cpu1Value = 1;
	private int cpu2Value = 0;
	private int modemValue = 1;
	private int firewallValue = 0;
	
	private JRadioButton cpu1Option1;
	private JRadioButton cpu1Option2;
	private JRadioButton cpu1Option3;
	private JRadioButton cpu2Option1;
	private JRadioButton cpu2Option2;
	private JRadioButton cpu2Option3;
	private JRadioButton modemOption1;
	private JRadioButton modemOption2;
	private JRadioButton modemOption3;
	private JRadioButton firewallOption1;
	private JRadioButton firewallOption2;
	private JRadioButton firewallOption3;
	
	private JTextArea passwordSummaryText;
	private JTextArea encryptionSummaryText;
	private JTextArea transfersSummaryText;
	private JSpinner maxBounceSpinner;

	public EvolutionView() {
		setTitle("Calculator");
		setPreferredSize(new Dimension(500, 400));
		setMinimumSize(new Dimension(800, 600));

		JPanel summaryPanel = new JPanel();
		summaryPanel.setPreferredSize(new Dimension(10, 200));
		summaryPanel.setMaximumSize(new Dimension(32767, 200));
		summaryPanel.setMinimumSize(new Dimension(10, 200));
		getContentPane().add(summaryPanel, BorderLayout.SOUTH);
		summaryPanel.setLayout(new BoxLayout(summaryPanel, BoxLayout.X_AXIS));
		
		JPanel passwordSummary = new JPanel();
		summaryPanel.add(passwordSummary);
		passwordSummary.setLayout(new BoxLayout(passwordSummary, BoxLayout.Y_AXIS));
		
		JLabel passwordSummaryLabel = new JLabel("Password");
		passwordSummaryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		passwordSummary.add(passwordSummaryLabel);
		
		passwordSummaryText = new JTextArea();
		passwordSummaryText.setEditable(false);
		passwordSummary.add(passwordSummaryText);
		
		JPanel encryptionSummary = new JPanel();
		summaryPanel.add(encryptionSummary);
		encryptionSummary.setLayout(new BoxLayout(encryptionSummary, BoxLayout.Y_AXIS));
		
		JLabel encryptionSummaryLabel = new JLabel("Encryption");
		encryptionSummaryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		encryptionSummary.add(encryptionSummaryLabel);
		
		encryptionSummaryText = new JTextArea();
		encryptionSummaryText.setEditable(false);
		encryptionSummary.add(encryptionSummaryText);
		
		JPanel transfersSummary = new JPanel();
		summaryPanel.add(transfersSummary);
		transfersSummary.setLayout(new BoxLayout(transfersSummary, BoxLayout.Y_AXIS));
		
		JLabel transfersSummaryLabel = new JLabel("Transfers");
		transfersSummaryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		transfersSummary.add(transfersSummaryLabel);
		
		transfersSummaryText = new JTextArea();
		transfersSummaryText.setEditable(false);
		transfersSummary.add(transfersSummaryText);
		
		JPanel titlePanel = new JPanel();
		getContentPane().add(titlePanel, BorderLayout.NORTH);
		
		JLabel appTitle = new JLabel("Calculator");
		titlePanel.add(appTitle);
		
		JPanel centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel cpu1Panel = new JPanel();
		centerPanel.add(cpu1Panel);
		cpu1Panel.setLayout(new BoxLayout(cpu1Panel, BoxLayout.Y_AXIS));
		
		JLabel cpu1Label = new JLabel("CPU 1 (Ghz)");
		cpu1Panel.add(cpu1Label);
		
		cpu1Option1 = new JRadioButton("None");
		cpu1Panel.add(cpu1Option1);
		
		cpu1Option2 = new JRadioButton("1 Ghz");
		cpu1Option2.setSelected(true);
		cpu1Panel.add(cpu1Option2);
		
		cpu1Option3 = new JRadioButton("2 Ghz");
		cpu1Panel.add(cpu1Option3);
		
		JPanel cpu2Panel = new JPanel();
		centerPanel.add(cpu2Panel);
		cpu2Panel.setLayout(new BoxLayout(cpu2Panel, BoxLayout.Y_AXIS));
		
		JLabel cpu2Label = new JLabel("CPU 2 (Ghz)");
		cpu2Panel.add(cpu2Label);
		
		cpu2Option1 = new JRadioButton("None");
		cpu2Panel.add(cpu2Option1);
		cpu2Option1.setSelected(true);
		
		cpu2Option2 = new JRadioButton("1 Ghz");
		cpu2Panel.add(cpu2Option2);
		
		cpu2Option3 = new JRadioButton("2 Ghz");
		cpu2Panel.add(cpu2Option3);
		
		JPanel modemPanel = new JPanel();
		centerPanel.add(modemPanel);
		modemPanel.setLayout(new BoxLayout(modemPanel, BoxLayout.Y_AXIS));
		
		JLabel modemLabel = new JLabel("Modem (mbps)");
		modemPanel.add(modemLabel);
		
		modemOption1 = new JRadioButton("1 mbps");
		modemOption1.setSelected(true);
		modemPanel.add(modemOption1);
		
		modemOption2 = new JRadioButton("2 mbps");
		modemPanel.add(modemOption2);
		
		modemOption3 = new JRadioButton("3 mbps");
		modemPanel.add(modemOption3);
		
		JPanel firewallPanel = new JPanel();
		centerPanel.add(firewallPanel);
		firewallPanel.setLayout(new BoxLayout(firewallPanel, BoxLayout.Y_AXIS));
		
		JLabel firewallLabel = new JLabel("Firewall Level");
		firewallPanel.add(firewallLabel);
		
		firewallOption1 = new JRadioButton("None");
		firewallOption1.setSelected(true);
		firewallPanel.add(firewallOption1);
		
		firewallOption2 = new JRadioButton("Level 1");
		firewallPanel.add(firewallOption2);
		
		firewallOption3 = new JRadioButton("Level 2");
		firewallPanel.add(firewallOption3);
		
		ButtonGroup cpu1Group = new ButtonGroup();
		ButtonGroup cpu2Group = new ButtonGroup();
		ButtonGroup modemGroup = new ButtonGroup();
		ButtonGroup firewallGroup = new ButtonGroup();
		
		cpu1Group.add(cpu1Option1);
		cpu1Group.add(cpu1Option2);
		cpu1Group.add(cpu1Option3);
		
		cpu2Group.add(cpu2Option1);
		cpu2Group.add(cpu2Option2);
		cpu2Group.add(cpu2Option3);

		modemGroup.add(modemOption1);
		modemGroup.add(modemOption2);
		modemGroup.add(modemOption3);
		
		firewallGroup.add(firewallOption1);
		firewallGroup.add(firewallOption2);
		firewallGroup.add(firewallOption3);
		
		JPanel maxBouncePanel = new JPanel();
		centerPanel.add(maxBouncePanel);
		maxBouncePanel.setLayout(new BoxLayout(maxBouncePanel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("Max Bounces");
		maxBouncePanel.add(lblNewLabel);
		
		maxBounceSpinner = new JSpinner();
		maxBounceSpinner.addChangeListener(this);
		maxBounceSpinner.setModel(new SpinnerNumberModel(new Integer(5), new Integer(0), null, new Integer(1)));
		maxBouncePanel.add(maxBounceSpinner);
		
		cpu1Option1.addActionListener(this);
		cpu1Option2.addActionListener(this);
		cpu1Option3.addActionListener(this);
		
		cpu2Option1.addActionListener(this);
		cpu2Option2.addActionListener(this);
		cpu2Option3.addActionListener(this);
		
		modemOption1.addActionListener(this);
		modemOption2.addActionListener(this);
		modemOption3.addActionListener(this);
		
		firewallOption1.addActionListener(this);
		firewallOption2.addActionListener(this);
		firewallOption3.addActionListener(this);
		
		getResults(cpu1Value, cpu2Value, modemValue, firewallValue, (int)maxBounceSpinner.getValue());
	}
	
	private void getResults(int cpu1, int cpu2, int modem, int firewall, int maxBounces){
		String passwordResults = calculator.getPasswordLenght(cpu1, cpu2, firewall, maxBounces);
		String encryptionResults = calculator.getEncryptionSize(cpu1, cpu2, firewall, maxBounces);
		String transferResults = calculator.getTransfers(modem, firewall, maxBounces);
		
		passwordSummaryText.setText(passwordResults);
		encryptionSummaryText.setText(encryptionResults);
		transfersSummaryText.setText(transferResults);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object changedButton = e.getSource();
		if(changedButton.equals(cpu1Option1)){
			this.cpu1Value = 0;
		} else if(changedButton.equals(cpu1Option2)){
			this.cpu1Value = 1;
		} else if(changedButton.equals(cpu1Option3)){
			this.cpu1Value = 2;
		} else if(changedButton.equals(cpu2Option1)){
			this.cpu2Value = 0;
		} else if(changedButton.equals(cpu2Option2)){
			this.cpu2Value = 1;
		} else if(changedButton.equals(cpu2Option3)){
			this.cpu2Value = 2;
		} else if(changedButton.equals(modemOption1)){
			this.modemValue = 1;
		} else if(changedButton.equals(modemOption2)){
			this.modemValue = 2;
		} else if(changedButton.equals(modemOption3)){
			this.modemValue = 3;
		} else if(changedButton.equals(firewallOption1)){
			this.firewallValue = 0;
		} else if(changedButton.equals(firewallOption2)){
			this.firewallValue = 1;
		} else if(changedButton.equals(firewallOption3)){
			this.firewallValue = 2;
		}
		getResults(cpu1Value, cpu2Value, modemValue, firewallValue, (int)maxBounceSpinner.getValue());
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		getResults(cpu1Value, cpu2Value, modemValue, firewallValue, (int)maxBounceSpinner.getValue());
	}
}