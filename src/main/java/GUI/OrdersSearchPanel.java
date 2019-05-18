package main.java.GUI;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class OrdersSearchPanel extends IWorkPanel {
    private JLabel providerLabel;
    private JLabel categoryLabel;
    private JLabel itemNameLabel;
    private JLabel orderIdLabel;
    private JLabel orderStatusLabel;
    private JLabel deliveryDateLabel;
    private JComboBox providersList;
    private JComboBox categoryList;
    private JComboBox itemList;
    private JTextField orderIdTF;
    private JCheckBox openOrderCB;
    private JCheckBox closedOrderCB;
    private JDateChooser deliveryDateChooser;
    private JButton searchOrderButton;
    private JTable ordersTable;
    private JScrollPane scrollTable;
    private JPanel searchPanel;
    private JPanel tablePanel;

    private String[] columnNames = {"Order ID","Units","Cost","Delivery status","Delivery Date"};
    private String[][] testData ={{"555","5","999","Closed","10.05.19"}};

    public OrdersSearchPanel(){
            initialization();
            setSearchPanelLayout();
            setTableLayout();
            setMainLayout();
    }

    @Override
    protected void initialization(){
        providerLabel = new JLabel("Provider: ");
        categoryLabel = new JLabel("Category: ");
        itemNameLabel = new JLabel("Item name: ");
        orderIdLabel = new JLabel("Order ID: ");
        orderStatusLabel = new JLabel("Order status: ");
        deliveryDateLabel = new JLabel("Delivery date: ");
        providersList = new JComboBox();
        categoryList = new JComboBox();
        itemList = new JComboBox();
        openOrderCB = new JCheckBox("Open");
        closedOrderCB = new JCheckBox("Closed");
        deliveryDateChooser = new JDateChooser();
        orderIdTF = new JTextField(10);
        searchOrderButton = new JButton("Search order");
        ordersTable = new JTable(testData,columnNames);
        scrollTable = new JScrollPane(ordersTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        searchPanel = new JPanel();
        tablePanel = new JPanel();
    }

    @Override
    protected void setMainLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gcMainPanel = new GridBagConstraints();
        gcMainPanel.fill = GridBagConstraints.HORIZONTAL;

        gcMainPanel.ipady = 5;
        gcMainPanel.gridy = 0;
        gcMainPanel.weightx = 0.5;
        gcMainPanel.weighty = 0.1;

        gcMainPanel.gridx = 0;
        gcMainPanel.anchor = GridBagConstraints.PAGE_START;
        add(searchPanel, gcMainPanel);

        gcMainPanel.ipady = 0;
        gcMainPanel.gridy ++;
        gcMainPanel.weightx = 0.5;
        gcMainPanel.weighty = 0.1;

        gcMainPanel.gridx = 0;
        gcMainPanel.anchor = GridBagConstraints.LINE_START;
        add(tablePanel, gcMainPanel);
    }

    @Override
    protected void setTableLayout() {
        Dimension dim = new Dimension(300,450);
        scrollTable.setPreferredSize(dim);

        tablePanel.setLayout(new GridBagLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        GridBagConstraints gcTablePanel = new GridBagConstraints();
        gcTablePanel.fill = GridBagConstraints.HORIZONTAL;

        gcTablePanel.gridx = 0;
        gcTablePanel.gridy = 0;
        gcTablePanel.weightx = 1;
        gcTablePanel.weighty = 0.1;

        tablePanel.add(scrollTable,gcTablePanel);
    }

    @Override
    protected void setSearchPanelLayout() {
        /////// Set combo-box ///////
        DefaultComboBoxModel providersModel = new DefaultComboBoxModel();
        providersModel.addElement("provider 1");
        providersList.setModel(providersModel);
        DefaultComboBoxModel categoryModel = new DefaultComboBoxModel();
        categoryModel.addElement("category 1");
        categoryList.setModel(categoryModel);

        searchPanel.setBorder(BorderFactory.createTitledBorder("Orders"));
        searchPanel.setLayout(new GridBagLayout());
        GridBagConstraints gcSearchPanel = new GridBagConstraints();
        gcSearchPanel.fill = GridBagConstraints.CENTER;
        gcSearchPanel.insets = new Insets(5,5,5,5);

        /////// First row ///////
        gcSearchPanel.gridy = 0;
        gcSearchPanel.weightx = 1;
        gcSearchPanel.weighty = 0.1;
        gcSearchPanel.gridx = 0;

        /////// Next row //////
        gcSearchPanel.gridy ++;
        gcSearchPanel.weightx = 0.5;
        gcSearchPanel.weighty = 0.1;
        gcSearchPanel.gridx = 0;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(providerLabel, gcSearchPanel);

        gcSearchPanel.gridx = 1;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(providersList, gcSearchPanel);

        gcSearchPanel.gridx = 2;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(categoryLabel, gcSearchPanel);

        gcSearchPanel.gridx = 3;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(categoryList, gcSearchPanel);

        /////// Next row ///////
        gcSearchPanel.gridy ++;

        gcSearchPanel.weightx = 0.5;
        gcSearchPanel.weighty = 0.1;

        gcSearchPanel.gridx = 0;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(itemNameLabel, gcSearchPanel);

        gcSearchPanel.gridx = 1;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(itemList, gcSearchPanel);

        gcSearchPanel.gridx = 2;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(orderIdLabel, gcSearchPanel);

        gcSearchPanel.gridx = 3;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(orderIdTF, gcSearchPanel);

        /////// Next row ///////
        gcSearchPanel.gridy ++;

        gcSearchPanel.weightx = 0.5;
        gcSearchPanel.weighty = 0.1;

        gcSearchPanel.gridx = 0;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(itemNameLabel, gcSearchPanel);

        gcSearchPanel.gridx = 1;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(itemList, gcSearchPanel);

        gcSearchPanel.gridx = 2;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(deliveryDateLabel, gcSearchPanel);

        gcSearchPanel.gridx = 3;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(deliveryDateChooser, gcSearchPanel);

        /////// Next row ///////
        gcSearchPanel.gridy ++;

        gcSearchPanel.weightx = 0.5;
        gcSearchPanel.weighty = 0.1;

        gcSearchPanel.gridx = 0;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(orderIdLabel, gcSearchPanel);

        gcSearchPanel.gridx = 1;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(orderIdTF, gcSearchPanel);

        gcSearchPanel.gridx = 2;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(orderStatusLabel, gcSearchPanel);

        gcSearchPanel.gridx = 3;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(openOrderCB, gcSearchPanel);

        /////// Next row ///////
        gcSearchPanel.gridy ++;

        gcSearchPanel.weightx = 0.5;
        gcSearchPanel.weighty = 0.1;

        gcSearchPanel.gridx = 1;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(searchOrderButton, gcSearchPanel);

        gcSearchPanel.gridx = 3;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(closedOrderCB, gcSearchPanel);

        ///// align fields sizes //////
        Dimension fieldSize = orderIdTF.getPreferredSize();
        providersList.setPreferredSize(fieldSize);
        categoryList.setPreferredSize(fieldSize);
        itemList.setPreferredSize(fieldSize);
        searchOrderButton.setPreferredSize(fieldSize);
        deliveryDateChooser.setPreferredSize(fieldSize);
    }

    @Override
    protected void setActionListeners(){

    }

}