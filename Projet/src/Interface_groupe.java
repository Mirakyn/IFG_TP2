package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JButton;

public class Interface_groupe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_groupe frame = new Interface_groupe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface_groupe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(20, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.WEST);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setMaximumSize(new Dimension(20, 20));
		splitPane_1.setPreferredSize(new Dimension(200, 10));
		splitPane_1.setMinimumSize(new Dimension(187, 25));
		splitPane.setRightComponent(splitPane_1);
		
		JButton button = new JButton("New Group");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		button.setPreferredSize(new Dimension(93, 15));
		button.setMinimumSize(new Dimension(75, 10));
		button.setMaximumSize(new Dimension(100, 10));
		splitPane_1.setLeftComponent(button);
		
		JButton btnAddGroup = new JButton("Add Group");
		btnAddGroup.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAddGroup.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnAddGroup.setPreferredSize(new Dimension(45, 5));
		splitPane_1.setRightComponent(btnAddGroup);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_2);
		
		JList list = new JList();
		list.setPreferredSize(new Dimension(0, 175));
		list.setSize(new Dimension(0, 25));
		list.setMaximumSize(new Dimension(0, 10));
		list.setMinimumSize(new Dimension(0, 175));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Group 1", "Group 2", "Group 3", "..."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		splitPane_2.setRightComponent(list);
		
		JLabel lblGroupesAssocis = new JLabel("Associated Groups");
		lblGroupesAssocis.setPreferredSize(new Dimension(100, 14));
		lblGroupesAssocis.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_2.setLeftComponent(lblGroupesAssocis);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblGestionDesGroupes = new JLabel("Gestion des groupes");
		panel.add(lblGestionDesGroupes);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane_3, BorderLayout.EAST);
		
		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_5.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_3.setLeftComponent(splitPane_5);
		
		JLabel lblNewLabel = new JLabel("Members list\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		splitPane_5.setLeftComponent(lblNewLabel);
		
		JList list_1 = new JList();
		list_1.setPreferredSize(new Dimension(100, 175));
		list_1.setMaximumSize(new Dimension(2000, 2000));
		list_1.setMinimumSize(new Dimension(100, 175));
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Member 1", "Member 2", "Member 3", "Member 4", "..."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		splitPane_5.setRightComponent(list_1);
		
		JButton btnNewList = new JButton("New List");
		splitPane_3.setRightComponent(btnNewList);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane_4, BorderLayout.CENTER);
		
		JSplitPane splitPane_6 = new JSplitPane();
		splitPane_6.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_4.setLeftComponent(splitPane_6);
		
		JLabel lblunknown = new JLabel("*unknown*");
		lblunknown.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_6.setLeftComponent(lblunknown);
		
		JList list_2 = new JList();
		list_2.setPreferredSize(new Dimension(0, 175));
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] {"dsf", "sdfsdf", "sdfs", "dfsd", "fds", "fsdf"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		splitPane_6.setRightComponent(list_2);
		
		JButton btnCheckList = new JButton("Check List");
		splitPane_4.setRightComponent(btnCheckList);
	}

}
