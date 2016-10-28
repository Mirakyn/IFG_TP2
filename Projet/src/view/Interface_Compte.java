package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Component;

public class Interface_Compte extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Interface_Compte dialog = new Interface_Compte();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Interface_Compte() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton saveButton = new JButton("Save");
				saveButton.setActionCommand("Cancel");
				buttonPane.add(saveButton);
			}
		}
		{
			JSplitPane splitPane = new JSplitPane();
			splitPane.setPreferredSize(new Dimension(220, 25));
			splitPane.setMinimumSize(new Dimension(250, 25));
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			getContentPane().add(splitPane, BorderLayout.WEST);
			{
				JSplitPane splitPane_1 = new JSplitPane();
				splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
				splitPane.setRightComponent(splitPane_1);
				{
					JSplitPane splitPane_2 = new JSplitPane();
					splitPane_1.setLeftComponent(splitPane_2);
					{
						JLabel lblRegistratedFrom = new JLabel("Registrated from :");
						lblRegistratedFrom.setMinimumSize(new Dimension(100, 14));
						lblRegistratedFrom.setHorizontalAlignment(SwingConstants.CENTER);
						splitPane_2.setLeftComponent(lblRegistratedFrom);
					}
					{
						JLabel label = new JLabel("");
						splitPane_2.setRightComponent(label);
					}
				}
				{
					JPanel panel = new JPanel();
					splitPane_1.setRightComponent(panel);
				}
			}
			{
				JSplitPane splitPane_1 = new JSplitPane();
				splitPane_1.setPreferredSize(new Dimension(203, 15));
				splitPane.setLeftComponent(splitPane_1);
				{
					JLabel lblUsername = new JLabel("Username :");
					lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
					lblUsername.setPreferredSize(new Dimension(100, 14));
					splitPane_1.setLeftComponent(lblUsername);
				}
				{
					JLabel label = new JLabel("");
					splitPane_1.setRightComponent(label);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblAccountManagement = new JLabel("Account Management");
				panel.add(lblAccountManagement);
			}
		}
		{
			JSplitPane splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			getContentPane().add(splitPane, BorderLayout.EAST);
			{
				JSplitPane splitPane_1 = new JSplitPane();
				splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
				splitPane.setRightComponent(splitPane_1);
				{
					JSplitPane splitPane_2 = new JSplitPane();
					splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
					splitPane_1.setRightComponent(splitPane_2);
					{
						JSplitPane splitPane_3 = new JSplitPane();
						splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
						splitPane_2.setRightComponent(splitPane_3);
						{
							JPanel panel = new JPanel();
							splitPane_3.setRightComponent(panel);
						}
						{
							JSplitPane splitPane_4 = new JSplitPane();
							splitPane_3.setLeftComponent(splitPane_4);
							{
								JLabel lblConfirmation = new JLabel("Confirmation :");
								splitPane_4.setLeftComponent(lblConfirmation);
							}
							{
								textField_2 = new JTextField();
								splitPane_4.setRightComponent(textField_2);
								textField_2.setColumns(10);
							}
						}
					}
					{
						JSplitPane splitPane_3 = new JSplitPane();
						splitPane_2.setLeftComponent(splitPane_3);
						{
							JLabel lblNewPassword = new JLabel("New Password :");
							splitPane_3.setLeftComponent(lblNewPassword);
						}
						{
							textField_1 = new JTextField();
							splitPane_3.setRightComponent(textField_1);
							textField_1.setColumns(10);
						}
					}
				}
				{
					JSplitPane splitPane_2 = new JSplitPane();
					splitPane_1.setLeftComponent(splitPane_2);
					{
						JLabel lblOldPassworD = new JLabel("Old Password :");
						lblOldPassworD.setHorizontalAlignment(SwingConstants.CENTER);
						lblOldPassworD.setAlignmentX(Component.CENTER_ALIGNMENT);
						splitPane_2.setLeftComponent(lblOldPassworD);
					}
					{
						textField = new JTextField();
						splitPane_2.setRightComponent(textField);
						textField.setColumns(10);
					}
				}
			}
			{
				JLabel lblChangeYourPassword = new JLabel("Change your password");
				lblChangeYourPassword.setHorizontalAlignment(SwingConstants.CENTER);
				splitPane.setLeftComponent(lblChangeYourPassword);
			}
		}
	}

}
