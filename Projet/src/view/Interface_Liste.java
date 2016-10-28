package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Dimension;

public class Interface_Liste extends JPanel {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_Liste frame = new Interface_Liste();
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
	public Interface_Liste() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.WEST);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setMinimumSize(new Dimension(200, 25));
		splitPane_1.setMaximumSize(new Dimension(200, 20));
		splitPane.setRightComponent(splitPane_1);
		
		JButton btnAdd = new JButton("Add");
		splitPane_1.setLeftComponent(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		splitPane_1.setRightComponent(btnDelete);
		
		JList<String> list = new JList<String>();
		list.setMinimumSize(new Dimension(0, 200));
		list.setMaximumSize(new Dimension(0, 200));
		list.setPreferredSize(new Dimension(0, 180));
		list.setModel(new AbstractListModel<String>() {
			String[] values = new String[] {"nom + quantite (1)", "nom + quantite (1)", "nom + quantite (1)", "nom + quantite (1)", "nom + quantite (1)"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		splitPane.setLeftComponent(list);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane_2, BorderLayout.EAST);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_2.setRightComponent(splitPane_3);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_3.setRightComponent(splitPane_4);
		
		JButton btnEdit = new JButton("Edit");
		splitPane_4.setLeftComponent(btnEdit);
		
		JButton btnDelete_1 = new JButton("Delete");
		splitPane_4.setRightComponent(btnDelete_1);
		
		JButton btnAdd_1 = new JButton("Add");
		splitPane_3.setLeftComponent(btnAdd_1);
		
		JList<String> list_2 = new JList<String>();
		list_2.setPreferredSize(new Dimension(0, 180));
		list_2.setMinimumSize(new Dimension(0, 175));
		list_2.setMaximumSize(new Dimension(0, 200));
		list_2.setModel(new AbstractListModel<String>() {
			String[] values = new String[] {"name", "prix", "qtt", "descript"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		splitPane_2.setLeftComponent(list_2);
		
		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_5.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane_5, BorderLayout.CENTER);
		
		JList<String> list_1 = new JList<String>();
		list_1.setPreferredSize(new Dimension(0, 180));
		list_1.setMinimumSize(new Dimension(0, 200));
		list_1.setModel(new AbstractListModel<String>() {
			String[] values = new String[] {"name product", "name product", "name product", "name product", "name product", "name product"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		splitPane_5.setLeftComponent(list_1);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(10, 10));
		splitPane_5.setRightComponent(panel);
		
		JSplitPane splitPane_6 = new JSplitPane();
		splitPane_6.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane_6, BorderLayout.NORTH);
		
		JSplitPane splitPane_7 = new JSplitPane();
		splitPane_6.setRightComponent(splitPane_7);
		
		JSplitPane splitPane_8 = new JSplitPane();
		splitPane_7.setRightComponent(splitPane_8);
		
		JLabel lblGroupListProduct = new JLabel("Group List Product");
		lblGroupListProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroupListProduct.setPreferredSize(new Dimension(122, 18));
		splitPane_8.setLeftComponent(lblGroupListProduct);
		
		JLabel lblProductDetail = new JLabel("Product Details");
		lblProductDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductDetail.setPreferredSize(new Dimension(72, 18));
		splitPane_8.setRightComponent(lblProductDetail);
		
		JLabel lblProductList = new JLabel("Product List");
		lblProductList.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductList.setPreferredSize(new Dimension(118, 18));
		splitPane_7.setLeftComponent(lblProductList);
		
		JLabel lblListManagement = new JLabel("List Management");
		lblListManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblListManagement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		splitPane_6.setLeftComponent(lblListManagement);
	}

}
