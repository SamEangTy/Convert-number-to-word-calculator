import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
public class ConvertNumber{
	ConvertToWord ConvertToWordEN = new ConvertToWord();
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		PrintWriter myWriter = new PrintWriter("Convert Number to txt.txt");
//		myWriter.println("THis is txt file");
//		myWriter.flush();
//		myWriter.close();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConvertNumber window = new ConvertNumber();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public ConvertNumber() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Convert this number:");
		lblNewLabel.setFont(new Font("Khmer OS Siemreap", Font.BOLD, 18));
		lblNewLabel.setBounds(104, 46, 202, 19);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(104, 68, 202, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea txtrAnswer = new JTextArea();
		txtrAnswer.setText("Answer:");
		txtrAnswer.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		txtrAnswer.setBounds(104, 147, 202, 67);
		frame.getContentPane().add(txtrAnswer);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				txtrAnswer.setText("");
				txtrAnswer.setText("Answer: ");
				textField.requestFocus();
			}
		});
		btnClear.setFont(new Font("Khmer OS Siemreap", Font.BOLD, 10));
		btnClear.setBounds(104, 105, 89, 27);
		frame.getContentPane().add(btnClear);
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("Khmer OS Siemreap", Font.BOLD, 10));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileWriter fileWriter = null;
			    BufferedWriter bufferedWriter = null;

			    try {
			        fileWriter = new FileWriter("Convert Number to txt.txt", true);
			        bufferedWriter = new BufferedWriter(fileWriter);
			        PrintWriter printWriter = new PrintWriter(bufferedWriter);

			        txtrAnswer.setText("");
			        txtrAnswer.setText("Answer: ");
			        textField.requestFocus();
			        int ValueTextFiled = Integer.parseInt(textField.getText());
			        String EN_Word = ConvertToWord.ConvertToWordEN(ValueTextFiled);
			        String KH_Word = ConvertToWord.ConvertToWordKH(ValueTextFiled);
			        double USD = ConvertToWord.ConvertToUSD(ValueTextFiled);
			        NumberFormat formatter = NumberFormat.getCurrencyInstance();
//			        System.out.println(formatter.format(USD));
//			        txtrAnswer.append("\nValue : " + ValueTextFiled);
			        txtrAnswer.append("\n" + EN_Word + " riel");
			        txtrAnswer.append("\n" + KH_Word + "រៀល");
			        txtrAnswer.append("\n" + formatter.format(USD) + " $");

			        // Write information to the text file
			        printWriter.println(EN_Word + " riel");
			        printWriter.println(KH_Word+ "រៀល");
			        printWriter.println(formatter.format(USD)+ " $");
			        printWriter.println("----------------------------------");
			        printWriter.flush();
			        printWriter.close();
			    } catch (IOException e1) {
			        e1.printStackTrace();
			    } finally {
			        try {
			            if (bufferedWriter != null) {
			                bufferedWriter.close();
			            }
			            if (fileWriter != null) {
			                fileWriter.close();
			            }
			        } catch (IOException e2) {
			            e2.printStackTrace();
			        }
			    }
			}
		});
		btnCalculate.setBounds(203, 105, 103, 27);
		frame.getContentPane().add(btnCalculate);
	}
}
