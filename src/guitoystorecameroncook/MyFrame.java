package guitoystorecameroncook;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.*;

public class MyFrame extends JFrame {

    public static int numberOfPeople = 0;
    public static int numberOfLineItems = 0;
    public static int numberOfSales = 0;
    public static Inventory inventory = new Inventory();// inventory holds all items
    public static ArrayList<Person> persons = new ArrayList<>();// arraylist of all people employee and customers
    public static ArrayList<LineItem> items = new ArrayList<>();// like inventory except not
    public static ArrayList<Transaction> transactions = new ArrayList<>();// all the transacations returns and sales
    public static final int HEIGHT = 600;
    public static final int WIDTH = 925;
    public static final int LOCATION_X = 50;
    public static final int LOCATION_Y = 100;

    /**
     * constructor for myFrame
     */
    public MyFrame() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(LOCATION_X, LOCATION_Y);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MyPanel p = new MyPanel();
        add(p);
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        JMenu color = new JMenu("Create New...");
        JMenu transaction = new JMenu("Transaction");
        JMenu exit = new JMenu("Exit");
        bar.add(color);
        bar.add(transaction);
        bar.add(exit);

        JMenuItem employee = new JMenuItem("Employee");
        employee.addActionListener(new EmployeeListener());
        JMenuItem customer = new JMenuItem("Customer");
        customer.addActionListener(new CustomerListener());
        JMenuItem item = new JMenuItem("Item");
        item.addActionListener(new ItemListener());
        color.add(employee);
        color.add(customer);
        color.add(item);

        JMenuItem sale = new JMenuItem("Sale");
        sale.addActionListener(new SaleListener());
        JMenuItem returnTrans = new JMenuItem("Return");
        returnTrans.addActionListener(new ReturnListener());
        transaction.add(sale);
        transaction.add(returnTrans);

        JMenuItem close = new JMenuItem("Exit Program");
        exit.add(close);
        close.addActionListener(new MenuListener());
        LoginFrame frame = new LoginFrame();

    }

    /**
     * the login frame, where you create the login dialog and that is used to
     * login it is user: admin pass: admin
     */
    class LoginFrame extends JFrame {

        public LoginFrame() {
            setVisible(false);//we need to make the frame visible
            setSize(300, 300);//before we display the dialog
            LoginDialog dialog = new LoginDialog(this);
            dialog.setSize(200, 100);//this is parent window
            dialog.setLocation(500, 500);
            dialog.setVisible(true);
        }

    }

    /**
     * The dialog class for a password text field
     */
    class LoginDialog extends JDialog {

        public LoginDialog(JFrame owner) {
            super(owner, "Authentication", true);
            setResizable(false);
            setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new GridLayout(2, 2));
            JLabel label1 = new JLabel("login: ");
            centerPanel.add(label1);
            final JTextField loginField = new JTextField("", 10);
            centerPanel.add(loginField);
            JLabel label2 = new JLabel("passowrd: ");
            centerPanel.add(label2);
            final JPasswordField passwordField
                    = new JPasswordField("", 10);
            centerPanel.add(passwordField);
            add(centerPanel, BorderLayout.CENTER);
            JPanel southPanel = new JPanel();
            add(southPanel, BorderLayout.SOUTH);
            JButton okButton = new JButton("OK");
            southPanel.add(okButton);
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    char[] correctPassword = {'a', 'd', 'm', 'i', 'n'};
                    if (loginField.getText().trim().equals("admin")) {
                        char[] password = passwordField.getPassword();
                        if (Arrays.equals(password, correctPassword)) {
                            LoginDialog.this.dispose();
                        }
                    }
                    Arrays.fill(correctPassword, '0');
                }
            });
        }
    }

    /**
     * listener for using the close program drop down
     */
    class MenuListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    /**
     * employee listener that makes employee dialog
     */
    class EmployeeListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            EmployeeDialog e1 = new EmployeeDialog(MyFrame.this);
            e1.setSize(300, 300);
            e1.setLocation(500, 500);
            e1.setVisible(true);

        }
    }

    /**
     * The employee dialog box
     */
    class EmployeeDialog extends JDialog {

        public EmployeeDialog(JFrame owner) {
            super(owner, "New Employee", true);
            setLayout(new GridLayout(5, 1));

            JPanel namePanel = new JPanel();
            namePanel.setLayout(new GridLayout(2, 2));

            JPanel pNPanel = new JPanel();
            pNPanel.setLayout(new GridLayout(2, 2));

            JPanel addressPanel = new JPanel();
            addressPanel.setLayout(new GridLayout(2, 2));

            JPanel salaryPanel = new JPanel();
            salaryPanel.setLayout(new GridLayout(2, 2));

            JPanel buttonPanel = new JPanel();
            JButton accept = new JButton("Accept");
            JButton exit = new JButton("Exit");
            buttonPanel.add(accept);
            buttonPanel.add(exit);

            exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });

            add(namePanel);
            add(pNPanel);
            add(addressPanel);
            add(salaryPanel);
            add(buttonPanel);

            JLabel nameLabel = new JLabel("Enter Name: ");
            JTextField nameField = new JTextField(2);
            namePanel.add(nameLabel);
            namePanel.add(nameField);

            JLabel pNLabel = new JLabel("Enter PhoneNumber: ");
            JTextField pNField = new JTextField(15);
            pNPanel.add(pNLabel);
            pNPanel.add(pNField);

            JLabel addressLabel = new JLabel("Enter Address: ");
            JTextField addressField = new JTextField(15);
            addressPanel.add(addressLabel);
            addressPanel.add(addressField);

            JLabel salaryLabel = new JLabel("Enter Salary: ");
            JTextField salaryField = new JTextField(15);
            salaryPanel.add(salaryLabel);
            salaryPanel.add(salaryField);
            pack();

            accept.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String name = nameField.getText();
                        String phone = pNField.getText();
                        String address = addressField.getText();
                        String salaryString = salaryField.getText();
                        double salary = Double.parseDouble(salaryString);
                        persons.add(numberOfPeople, new Employee(name, phone, address, salary));
                        setVisible(false);

                        class empDialog extends JDialog {

                            public empDialog(JDialog owner) {
                                super(owner, "Employee info", true);
                                JLabel emp = new JLabel(persons.get(numberOfPeople).toString());
                                add(emp);
                            }
                        }
                        empDialog empD = new empDialog(EmployeeDialog.this);
                        empD.setSize(700, 300);
                        empD.setLocation(500, 500);
                        empD.setVisible(true);
                        numberOfPeople++;
                    } catch (Exception c) {

                    }
                }
            });

        }
    }

    /**
     * customer listener that makes customer dialog
     */
    class CustomerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            CustomerDialog c1 = new CustomerDialog(MyFrame.this);
            c1.setSize(300, 300);
            c1.setLocation(500, 500);
            c1.setVisible(true);

        }
    }

    /**
     * the customer dialog box
     */
    class CustomerDialog extends JDialog {

        public CustomerDialog(JFrame owner) {
            super(owner, "New Customer", true);
            JFrame f1 = new JFrame();
            setLayout(new GridLayout(5, 1));

            JPanel namePanel = new JPanel();
            namePanel.setLayout(new GridLayout(2, 2));

            JPanel pNPanel = new JPanel();
            pNPanel.setLayout(new GridLayout(2, 2));

            JPanel addressPanel = new JPanel();
            addressPanel.setLayout(new GridLayout(2, 2));

            JPanel salaryPanel = new JPanel();
            salaryPanel.setLayout(new GridLayout(2, 2));

            JPanel buttonPanel = new JPanel();
            JButton accept = new JButton("Accept");
            JButton exit = new JButton("Exit");
            buttonPanel.add(accept);
            buttonPanel.add(exit);

            exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });

            add(namePanel);
            add(pNPanel);
            add(addressPanel);
            add(salaryPanel);
            add(buttonPanel);

            JLabel nameLabel = new JLabel("Enter Name: ");
            JTextField nameField = new JTextField(2);
            namePanel.add(nameLabel);
            namePanel.add(nameField);

            JLabel pNLabel = new JLabel("Enter PhoneNumber: ");
            JTextField pNField = new JTextField(15);
            pNPanel.add(pNLabel);
            pNPanel.add(pNField);

            JLabel addressLabel = new JLabel("Enter Address: ");
            JTextField addressField = new JTextField(15);
            addressPanel.add(addressLabel);
            addressPanel.add(addressField);

            JLabel salaryLabel = new JLabel("Enter age: ");
            JTextField salaryField = new JTextField(15);
            salaryPanel.add(salaryLabel);
            salaryPanel.add(salaryField);
            pack();

            accept.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String name = nameField.getText();
                        String phone = pNField.getText();
                        String address = addressField.getText();
                        String ageString = salaryField.getText();
                        int age = Integer.parseInt(ageString);
                        persons.add(numberOfPeople, new Customer(name, phone, address, age));
                        setVisible(false);

                        class CusDialog extends JDialog {

                            public CusDialog(JDialog owner) {
                                super(owner, "Customer info", true);
                                JLabel emp = new JLabel(persons.get(numberOfPeople).toString());
                                add(emp);
                            }
                        }
                        CusDialog empD = new CusDialog(CustomerDialog.this);
                        empD.setSize(600, 300);
                        empD.setLocation(500, 500);
                        empD.setVisible(true);
                    } catch (Exception c) {

                    }
                }
            });

        }
    }

    /**
     * item listener used to create item dialog object
     */
    class ItemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ItemDialog item = new ItemDialog(MyFrame.this);
            item.setSize(300, 300);
            item.setLocation(500, 500);
            item.setVisible(true);

        }
    }

    /**
     * dialog box to create a item
     */
    class ItemDialog extends JDialog {

        public ItemDialog(JFrame owner) {
            super(owner, "New Product", true);
            JFrame f1 = new JFrame();
            setLayout(new GridLayout(5, 1));

            JPanel namePanel = new JPanel();
            namePanel.setLayout(new GridLayout(2, 2));

            JPanel pNPanel = new JPanel();
            pNPanel.setLayout(new GridLayout(2, 2));

            JPanel addressPanel = new JPanel();
            addressPanel.setLayout(new GridLayout(2, 2));

            JPanel salaryPanel = new JPanel();
            salaryPanel.setLayout(new GridLayout(2, 2));

            JPanel buttonPanel = new JPanel();
            JButton accept = new JButton("Accept");
            JButton exit = new JButton("Exit");
            buttonPanel.add(accept);
            buttonPanel.add(exit);

            exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });

            add(namePanel);
            add(pNPanel);
            add(addressPanel);
            add(salaryPanel);
            add(buttonPanel);

            JLabel nameLabel = new JLabel("Enter Name: ");
            JTextField nameField = new JTextField(2);
            namePanel.add(nameLabel);
            namePanel.add(nameField);

            JLabel pNLabel = new JLabel("Enter description: ");
            JTextField pNField = new JTextField(15);
            pNPanel.add(pNLabel);
            pNPanel.add(pNField);

            JLabel addressLabel = new JLabel("Enter Price: ");
            JTextField addressField = new JTextField(15);
            addressPanel.add(addressLabel);
            addressPanel.add(addressField);

            JLabel salaryLabel = new JLabel("Enter Quantity: ");
            JTextField salaryField = new JTextField(15);
            salaryPanel.add(salaryLabel);
            salaryPanel.add(salaryField);
            pack();

            accept.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String itemName = nameField.getText();
                    String description = pNField.getText();
                    String priceString = addressField.getText();
                    String quantityString = salaryField.getText();
                    double price = Double.parseDouble(priceString);
                    int quantity = Integer.parseInt(quantityString);
                    Product p1 = new Product(itemName, description, price);
                    items.add(numberOfLineItems, new LineItem(p1, quantity));
                    inventory.addItems(items.get(numberOfLineItems));
                    setVisible(false);
                    /**
                     * class for the customer dialog
                     */
                    class CusDialog extends JDialog {

                        public CusDialog(JDialog owner) {
                            super(owner, "Customer info", true);
                            JLabel emp = new JLabel(items.get(numberOfLineItems).toString());
                            add(emp);
                        }
                    }
                    CusDialog c1 = new CusDialog(ItemDialog.this);
                    c1.setSize(700, 300);
                    c1.setLocation(500, 500);
                    c1.setVisible(true);
                    numberOfLineItems++;

                }
            });

        }
    }

    /**
     * used to create a sale dialog
     */
    class SaleListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            SaleDialog s1 = new SaleDialog(MyFrame.this);
            s1.setSize(300, 300);
            s1.setLocation(500, 500);
            s1.setVisible(true);

        }
    }

    /**
     * sale dialog box class
     */
    class SaleDialog extends JDialog {

        public SaleDialog(JFrame owner) {
            super(owner, "New Sale", true);
            JFrame f1 = new JFrame();
            setLayout(new GridLayout(4, 1));

            JPanel namePanel = new JPanel();
            namePanel.setLayout(new GridLayout(2, 2));

            JPanel pNPanel = new JPanel();
            pNPanel.setLayout(new GridLayout(2, 2));

            JPanel addressPanel = new JPanel();
            addressPanel.setLayout(new GridLayout(2, 2));

            JPanel salaryPanel = new JPanel();
            salaryPanel.setLayout(new GridLayout(2, 2));

            JPanel buttonPanel = new JPanel();
            JButton accept = new JButton("Accept");
            JButton exit = new JButton("Exit");
            buttonPanel.add(accept);
            buttonPanel.add(exit);

            exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });

            add(namePanel);
            add(addressPanel);
            add(salaryPanel);
            add(buttonPanel);

            JLabel nameLabel = new JLabel("Enter id of the product: ");
            JTextField nameField = new JTextField(2);
            namePanel.add(nameLabel);
            namePanel.add(nameField);

            JLabel pNLabel = new JLabel("Enter quantity desired: ");
            JTextField pNField = new JTextField(15);
            pNPanel.add(pNLabel);
            pNPanel.add(pNField);

            JLabel addressLabel = new JLabel("Enter Employee Id: ");
            JTextField addressField = new JTextField(15);
            addressPanel.add(addressLabel);
            addressPanel.add(addressField);

            JLabel salaryLabel = new JLabel("Enter Customer Id: ");
            JTextField salaryField = new JTextField(15);
            salaryPanel.add(salaryLabel);
            salaryPanel.add(salaryField);
            pack();

            accept.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Date d1 = new Date();
                        String itemId = nameField.getText();
                        String empIdString = addressField.getText();
                        String cusIdString = salaryField.getText();
                        //int quantity = Integer.parseInt(quantityString);
                        double proId = Double.parseDouble(itemId);
                        double empId = Double.parseDouble(empIdString);
                        double cusId = Double.parseDouble(cusIdString);
                        int proPosition = inventory.findProduct(proId);
                        int empPosition = findEmployee(empId);
                        int cusPosition = findCustomer(cusId);
                        Employee e1 = (Employee) persons.get(empPosition);
                        Customer c1 = (Customer) persons.get(cusPosition);
                        setVisible(false);
                        /**
                         * class for the quantity dialog
                         */
                        class quantityDialog extends JDialog {

                            public quantityDialog(JDialog owner) {
                                super(owner, "Quantity", true);
                                setLayout(new BorderLayout());
                                JPanel quantityPanel = new JPanel();
                                JLabel quantityLabel = new JLabel("There is " + inventory.getProduct(proPosition).getQuanity() + " of thise product, how much do you want : ");
                                JTextField quantityField = new JTextField(15);
                                quantityPanel.add(quantityLabel);
                                quantityPanel.add(quantityField);
                                add(quantityPanel, BorderLayout.NORTH);

                                JPanel buttonPanel = new JPanel();
                                JButton accept = new JButton("Accept");
                                buttonPanel.add(accept);

                                add(buttonPanel, BorderLayout.SOUTH);
                                accept.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            String quantityString = quantityField.getText();
                                            int quantity = Integer.parseInt(quantityString);
                                            LineItem line1 = new LineItem(inventory.getProduct(proPosition).getProduct(), quantity);
                                            Sale s1 = new Sale(line1, d1, e1, c1);
                                            transactions.add(numberOfSales, s1);
                                            e1.addSales(s1);
                                            c1.addPurchases(s1);
                                            setVisible(false);
                                            /**
                                             * class for the reciept dialog
                                             */
                                            class recieptDialog extends JDialog {
                                                
                                                public recieptDialog(JDialog owner) {
                                                    super(owner, "Sale Reciept", true);
                                                    JPanel reciept = new JPanel();
                                                    String result = "Your sale id is:  " + transactions.get(numberOfSales).getSaleId();
                                                    JLabel j1 = new JLabel(result);
                                                    JLabel j2 = new JLabel("The total: " + transactions.get(numberOfSales).getTotal());
                                                    reciept.add(j1);
                                                    reciept.add(j2);
                                                    add(reciept);
                                                    pack();

                                                }
                                            }
                                            recieptDialog reciept = new recieptDialog(quantityDialog.this);
                                            reciept.setSize(600, 300);
                                            reciept.setLocation(500, 500);
                                            reciept.setVisible(true);
                                            inventory.deleteInventory(proPosition, quantity);
                                            numberOfSales++;
                                        } catch (Exception c) {
                                        }
                                    }
                                });

                            }
                        }
                        quantityDialog q1 = new quantityDialog(SaleDialog.this);
                        q1.setSize(600, 300);
                        q1.setLocation(500, 500);
                        q1.setVisible(true);
                    } catch (Exception f) {
                    }
                }
            });

        }
    }

    /**
     * used to create a sale dialog
     */
    class ReturnListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ReturnDialog r1 = new ReturnDialog(MyFrame.this);
            r1.setSize(300, 300);
            r1.setLocation(500, 500);
            r1.setVisible(true);

        }
    }

    /**
     * is the return dialog class
     */
    class ReturnDialog extends JDialog {

        public ReturnDialog(JFrame owner) {
            super(owner, "New Return", true);
            JFrame f1 = new JFrame();
            setLayout(new GridLayout(5, 1));

            JPanel namePanel = new JPanel();
            namePanel.setLayout(new GridLayout(2, 2));

            JPanel pNPanel = new JPanel();
            pNPanel.setLayout(new GridLayout(2, 2));

            JPanel addressPanel = new JPanel();
            addressPanel.setLayout(new GridLayout(2, 2));

            JPanel salaryPanel = new JPanel();
            salaryPanel.setLayout(new GridLayout(2, 2));

            JPanel extraPanel = new JPanel();
            extraPanel.setLayout(new GridLayout(2, 2));

            JPanel buttonPanel = new JPanel();
            JButton accept = new JButton("Accept");
            JButton exit = new JButton("Exit");
            buttonPanel.add(accept);
            buttonPanel.add(exit);

            exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });

            add(namePanel);
            add(pNPanel);
            add(salaryPanel);
            add(extraPanel);
            add(buttonPanel);

            JLabel nameLabel = new JLabel("Enter transaction number of sale: ");
            JTextField nameField = new JTextField(2);
            namePanel.add(nameLabel);
            namePanel.add(nameField);

            JLabel proIdLabel = new JLabel("Enter Product id  that you want ot return: ");
            JTextField proIdField = new JTextField(2);
            pNPanel.add(proIdLabel);
            pNPanel.add(proIdField);

            JLabel salaryLabel = new JLabel("Enter Employee Id: ");
            JTextField salaryField = new JTextField(15);
            salaryPanel.add(salaryLabel);
            salaryPanel.add(salaryField);

            JLabel extraLabel = new JLabel("Enter Customer Id: ");
            JTextField extraField = new JTextField(15);
            extraPanel.add(extraLabel);
            extraPanel.add(extraField);
            pack();
            accept.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Date d1 = new Date();
                        String transIdString = nameField.getText();
                        String proIdString = proIdField.getText();
                        String empIdString = salaryField.getText();
                        String cusIdString = extraField.getText();
                        double proId = Double.parseDouble(proIdString);
                        int proPosition = inventory.findProduct(proId);
                        double transId = Double.parseDouble(transIdString);
                        double empId = Double.parseDouble(empIdString);
                        double cusId = Double.parseDouble(cusIdString);
                        Transaction t1 = transactions.get(findTransaction(transId, transactions));
                        int empPosition = findEmployee(empId);
                        int cusPosition = findCustomer(cusId);
                        Employee e1 = (Employee) persons.get(empPosition);
                        Customer c1 = (Customer) persons.get(cusPosition);
                        setVisible(false);
                        /**
                         * class for the quantityDialog
                         */
                        class quantityDialog extends JDialog {

                            public quantityDialog(JDialog owner) {
                                super(owner, "Quantity", true);
                                setLayout(new BorderLayout());
                                JPanel quantityPanel = new JPanel();
                                JLabel quantityLabel = new JLabel("You bought " + t1.getQuantity(t1.findProduct(proId)) + " of thise product(s), how much do you want return : ");
                                JTextField quantityField = new JTextField(15);
                                quantityPanel.add(quantityLabel);
                                quantityPanel.add(quantityField);
                                add(quantityPanel, BorderLayout.NORTH);

                                JPanel buttonPanel = new JPanel();
                                JButton accept = new JButton("Accept");
                                buttonPanel.add(accept);

                                add(buttonPanel, BorderLayout.SOUTH);
                                accept.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            String quantityString = quantityField.getText();
                                            int quantity = Integer.parseInt(quantityString);
                                            System.out.println("before");
                                            LineItem line1 = inventory.getProduct(proPosition);
                                            System.out.println("after");
                                            Sale s1 = new Sale(line1, d1, e1, c1);
                                            transactions.add(numberOfSales, s1);
                                            setVisible(false);
                                            class recieptDialog extends JDialog {

                                                public recieptDialog(JDialog owner) {
                                                    super(owner, "Sale Reciept", true);
                                                    JPanel reciept = new JPanel();
                                                    String result = "Your sale id is:  " + transactions.get(numberOfSales).getSaleId();
                                                    JLabel j1 = new JLabel(result);
                                                    JLabel j2 = new JLabel("The total returned : " + line1.getPrice() * quantity);
                                                    reciept.add(j1);
                                                    reciept.add(j2);
                                                    add(reciept);
                                                    pack();

                                                }
                                            }
                                            recieptDialog reciept = new recieptDialog(quantityDialog.this);
                                            reciept.setSize(600, 300);
                                            reciept.setLocation(500, 500);
                                            reciept.setVisible(true);
                                            inventory.deleteInventory(proPosition, quantity);
                                        } catch (Exception f) {

                                        }
                                    }
                                });

                            }
                        }
                        quantityDialog q1 = new quantityDialog(ReturnDialog.this);
                        q1.setSize(600, 300);
                        q1.setLocation(500, 500);
                        q1.setVisible(true);
                    } catch (Exception g) {

                    }
                }
            });
        }
    }

    /**
     * this searchs the arraylist persons, for the employee at a specfic id.
     *
     * @param empId the id of the employee we are looking for
     * @param persons the arraylist where we are looking for it
     * @return the index of where the employee is located in the arraylist
     */
    public static int findEmployee(double empId) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.size() == 0) {
                return -1;

            }
            if (persons.get(i).getId() == empId && persons.get(i).getClass() == Employee.class) {
                return i;
            }

        }
        return -1;
    }

    /**
     * this searches the arraylist of persons, to find the customer that matches
     * the unique id that the user entered.
     *
     * @param custId is the unique id that the user entered,which we are
     * searching the arraylist for.
     * @param persons the arraylist that we are searching
     * @return the index where that customer is located in the arraylist.
     */
    public static int findCustomer(double custId) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.size() == 0) {
                return -1;

            }
            if (persons.get(i).getId() == custId && persons.get(i).getClass() == Customer.class) {
                return i;
            }
        }
        return -1;
    }

    /**
     * this finds the transaction that has the same id that they user inputed.
     *
     * @param transId is the id that we are searching for
     * @param transactions is the arraylist we are searching through
     * @return the index where this transaction is located.
     */
    public static int findTransaction(double transId, ArrayList<Transaction> transactions) {
        int transPosition;
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.isEmpty()) {
                return -1;
            }
            if (transactions.get(i).getSaleId() == transId) {
                return i;
            }
        }
        return -1;
    }

}
