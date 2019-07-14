package main.java.GUI;

import com.toedter.calendar.JDateChooser;
import main.java.BL.Contract.*;
import main.java.common.DateUtils;
import main.java.common.StringUtils;
import main.java.common.constants.Constants;
import main.java.common.constants.DatabaseConstants;
import main.java.common.constants.GUIConstants;
import main.java.database.DatabaseController;
import main.java.database.UserRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import static java.lang.Integer.valueOf;

public class UserPanel extends IWorkPanel {
    private JLabel userNameLable;
    private JLabel firstnameLable;
    private JLabel lastNameLable;
    private JLabel dateOfBirthLable;
    private JLabel phoneNumberLable;
    private JLabel isManagerLable;
    private JLabel departmentLable;
    private JLabel hireDateLable;
    private JLabel itemAdded;
    private JLabel passwordLable;
    private JComboBox department;
    private JTextField userName;
    private JTextField firstName;
    private JTextField phoneNumber;
    private JPasswordField password;
    private JTextField lastName;
    private JCheckBox isManager;
    private JLabel allRequired;
    private JDateChooser dateOfBirth;
    private JDateChooser hireDate;
    private JButton addUserButton;
    private JScrollPane scrollItemsTable;
    private JScrollPane scrollOrderTable;
    private JPanel searchPanel;
    private EditItemDialog itemDialog;
    private OrderPlacedDialog orderPlacedDialog;
    private Vector<String> departments;


    public UserPanel() {
        initialization();
        setSearchPanelLayout();
        setTableLayout();
        setMainLayout();
        setActionListeners();
    }

    @Override
    protected void initialization() {
        userNameLable = new JLabel("User Name");
        firstnameLable = new JLabel("First Name");
        lastNameLable = new JLabel("Last Name");
        lastName= new JTextField();
        dateOfBirthLable = new JLabel("Fite");
        phoneNumberLable = new JLabel("Phone number");
        isManagerLable = new JLabel("Is Manager?");
        departmentLable = new JLabel("Department");
        hireDateLable = new JLabel("Hire Date");
        passwordLable = new JLabel("Password");
        department = new JComboBox();
        itemAdded = new JLabel(GUIConstants.ITEM_ADDED);
        password = new JPasswordField();
        isManager= new JCheckBox();
        userName = new JTextField(10);
        firstName = new JTextField(10);
        hireDate = new JDateChooser();
        phoneNumber= new JTextField();
        addUserButton = new JButton("Add User");
        dateOfBirth= new JDateChooser();
        allRequired = new JLabel(GUIConstants.ALL_FIELDS_REQUIRED);
        searchPanel = new JPanel();
        itemDialog = new EditItemDialog((JFrame) SwingUtilities.getWindowAncestor(this));
        orderPlacedDialog = new OrderPlacedDialog((JFrame) SwingUtilities.getWindowAncestor(this));
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
        gcMainPanel.gridy++;
        gcMainPanel.weightx = 0.5;
        gcMainPanel.weighty = 0.1;

    }

    @Override
    protected void setTableLayout() {

    }


    @Override
    protected void setSearchPanelLayout() {
        setComboBoxes();

        searchPanel.setBorder(BorderFactory.createTitledBorder("Orders"));
        searchPanel.setLayout(new GridBagLayout());
        GridBagConstraints gcSearchPanel = new GridBagConstraints();
        gcSearchPanel.fill = GridBagConstraints.CENTER;
        gcSearchPanel.insets = new Insets(5, 5, 5, 5);

        /////// First row ///////
        gcSearchPanel.gridy = 0;
        gcSearchPanel.weightx = 0.5;
        gcSearchPanel.weighty = 0.1;

        gcSearchPanel.gridx = 0;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(userNameLable, gcSearchPanel);

        gcSearchPanel.gridx = 1;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(userName, gcSearchPanel);

        gcSearchPanel.gridx = 2;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(firstnameLable, gcSearchPanel);

        gcSearchPanel.gridx = 3;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(firstName, gcSearchPanel);



        /////// Next row ///////
        gcSearchPanel.gridy++;

        gcSearchPanel.weightx = 0.5;
        gcSearchPanel.weighty = 0.1;

        gcSearchPanel.gridx = 0;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(lastNameLable, gcSearchPanel);

        gcSearchPanel.gridx = 1;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(lastName, gcSearchPanel);

        gcSearchPanel.gridx = 2;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(dateOfBirthLable, gcSearchPanel);

        gcSearchPanel.gridx = 3;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(dateOfBirth, gcSearchPanel);


        /////// Next row ///////
        gcSearchPanel.gridy++;

        gcSearchPanel.weightx = 0.5;
        gcSearchPanel.weighty = 0.1;

        gcSearchPanel.gridx = 0;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(departmentLable, gcSearchPanel);

        gcSearchPanel.gridx = 1;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(department, gcSearchPanel);

        gcSearchPanel.gridx = 2;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(hireDateLable, gcSearchPanel);

        gcSearchPanel.gridx = 3;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(hireDate, gcSearchPanel);

        gcSearchPanel.gridx = 4;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(phoneNumberLable, gcSearchPanel);

        gcSearchPanel.gridx = 5;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(phoneNumber, gcSearchPanel);

        /////// Next row ///////
        gcSearchPanel.gridy++;

        gcSearchPanel.weightx = 0.5;
        gcSearchPanel.weighty = 0.1;

        gcSearchPanel.gridx = 0;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(isManagerLable, gcSearchPanel);

        gcSearchPanel.gridx = 1;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(isManager, gcSearchPanel);

        gcSearchPanel.gridx = 2;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(passwordLable, gcSearchPanel);

        gcSearchPanel.gridx = 3;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(password, gcSearchPanel);


/////// Next row ///////
        gcSearchPanel.gridy++;

        gcSearchPanel.weightx = 0.5;
        gcSearchPanel.weighty = 0.1;

        gcSearchPanel.gridx = 0;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        searchPanel.add(addUserButton, gcSearchPanel);

        //Validation labels
        gcSearchPanel.gridx = 3;
        gcSearchPanel.anchor = GridBagConstraints.FIRST_LINE_START;

        allRequired.setForeground(Color.red);
        allRequired.setVisible(false);
        searchPanel.add(allRequired, gcSearchPanel);


        itemAdded.setForeground(Color.blue);
        itemAdded.setVisible(false);
        searchPanel.add(itemAdded, gcSearchPanel);

        alignFieldSizes();
    }

    @Override
    protected void alignFieldSizes() {
        Dimension fieldSize = userName.getPreferredSize();
        department.setPreferredSize(fieldSize);
        addUserButton.setPreferredSize(fieldSize);
    }

    @Override
    protected void setComboBoxes() {
        setCurrentProvider();//TODO: should be adjusted live and not only when running the app first
        DefaultComboBoxModel providersModel = new DefaultComboBoxModel(departments);
        department.setModel(providersModel);
    }

    private void setCurrentProvider() {
        departments = UserRepository.getAllDepartment();
        departments.add(0, GUIConstants.SELECT_FIELD);
    }


    @Override
    protected void setActionListeners() {
        setAddUserListener();
    }

    private void setAddUserListener() {
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkAtleastOneNotEmpty()) {
                    setValidationLabelsVisibility(false);
                    allRequired.setVisible(true);
                } else {
                    setValidationLabelsVisibility(false);
                    Employee employee;
                    employee = getUserProperties();
                    UserRepository.addUser(employee,isManager.isSelected());
                    itemAdded.setVisible(true);
                }
            }
        });
    }

    private Employee getUserProperties() {
        Employee user = new Employee();
        user.setPassword(new String(password.getPassword()));
        user.setDateOfBirth(dateOfBirth.getDateFormatString());
        user.setFirstName(firstName.getText());
        user.setLastName(lastName.getText());
        user.setPhoneNmuber(phoneNumber.getText());
        user.setUserName(userName.getText());
        //user.setDepartment(Department[department.getSelectedIndex()]));
        user.setHireDate(hireDate.getDate());
        return user;
    }

    //"Item name","Category","Provider","Available units","Price per Item","Expiration date"
    private String[][] convertProductVectorToProductMatrix(Vector<Product> productVector) {
        String[][] matrix = new String[productVector.size()][Constants.PRODUCTS_MATRIX_COLUMNS];
        for (int i = 0; i < productVector.size(); i++) {
            String[] array = {
                    productVector.get(i).getProductId(),
                    productVector.get(i).getProductName(),
                    String.valueOf(productVector.get(i).getCategory()),
                    DatabaseController.getProviderNameById(productVector.get(i).getProviderId()),
                    String.valueOf(productVector.get(i).getCurrentProductAmount()),
                    productVector.get(i).getPrice(),
                    DateUtils.formatDateToString(productVector.get(i).getExpirationDate())
            };
            matrix[i] = array;
        }

        return matrix;
    }


    private boolean checkAtleastOneNotEmpty() {
        if (!department.getSelectedItem().equals(GUIConstants.SELECT_FIELD) ||
                !firstName.getText().equals(GUIConstants.EMPTY_FIELD) ||
                !lastName.getText().equals(GUIConstants.EMPTY_FIELD) ||
                !phoneNumber.getText().equals(GUIConstants.EMPTY_FIELD) ||
                !password.getText().equals(GUIConstants.EMPTY_FIELD) ||
                !isManager.getText().equals(GUIConstants.EMPTY_FIELD) ||
                !userName.getText().equals(GUIConstants.EMPTY_FIELD)
        )
            return true;

        else
            return false;
    }

    @Override
    protected void setValidationLabelsVisibility(boolean visibility) {
        allRequired.setVisible(visibility);
        itemAdded.setVisible(visibility);
    }
}
