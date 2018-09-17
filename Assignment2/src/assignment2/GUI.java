package assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Samuel Brownley 31691379
 * @version 1.0
 * @date 22/05/2017
 * @filename GUI.java
 */
public class GUI extends JFrame
{
    String familyName = "";
    FTree BTree;
    
    Font titleFont = new Font("Serif",Font.BOLD,50);
    Font headerFont = new Font("Serif",Font.BOLD,25); 
    String[] genderList = {"Female","Male"};    
    
    boolean isViewMode = true;

    //Main window
    JFrame mainframe = new JFrame("Family Tree Fun");

    Container contentPane = mainframe.getContentPane();

    //North panel
    JPanel northPanel = new JPanel(new BorderLayout());  
    JPanel northTitle = new JPanel(); 
    JLabel title = new JLabel("Family Tree Fun");
    JPanel northBtns = new JPanel();
    JButton view = new JButton("View Mode");
    JButton edit = new JButton("Edit Mode");

    //South panel
    JPanel southPanel = new JPanel();
    JButton exit = new JButton("Exit");
    JLabel footer=new JLabel("Made by Samuel Brownley 31691379   samuel.brownley@hotmail.com");

    //East panel
    JPanel eastPanel = new JPanel(new BorderLayout());  
    JLabel details = new JLabel("Details:");        

    JPanel detailsPanel = new JPanel(new GridLayout(0,2));        
    JLabel fName = new JLabel("First Name: ");
    JLabel sBName = new JLabel("Surname (before marriage): ");
    JLabel sMName = new JLabel("Surname (after marriage): ");
    JLabel gender = new JLabel("Gender: ");
    JLabel address = new JLabel("Address");   
    JLabel addressSNum = new JLabel("Street Number: ");  
    JLabel addressSName = new JLabel("Street Name: ");       
    JLabel addressSub = new JLabel("Suburb: "); 
    JLabel addressPcode = new JLabel("Postcode: ");   
    JLabel description = new JLabel("Description: ");
    JLabel mother = new JLabel("Mother: ");
    JLabel father = new JLabel("Father: ");
    JLabel spouse = new JLabel("Spouse: ");
    JLabel children = new JLabel("Children: ");

    JTextField fNameTxt = new JTextField();
    JTextField sBNameTxt = new JTextField();
    JTextField sMNameTxt = new JTextField();
    //JTextField genderTxt = new JTextField(); 
    JComboBox genderTxt = new JComboBox(genderList);
    JTextField addressSNumTxt = new JTextField();  
    JTextField addressSNameTxt = new JTextField();       
    JTextField addressSubTxt = new JTextField(); 
    JTextField addressPcodeTxt = new JTextField();       
    JTextField descriptionTxt = new JTextField();
    JTextField motherTxt = new JTextField();
    JTextField fatherTxt = new JTextField();
    JTextField spouseTxt = new JTextField();        
    JTextArea childrenTxt = new JTextArea();
    JScrollPane childrenScroll = new JScrollPane(childrenTxt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JPanel eastBtnPanel = new JPanel();
    JButton addChild = new JButton("Add Child"); 
    JButton addFather = new JButton("Add Father"); 
    JButton addMother = new JButton("Add Mother");     
    JButton addSpouse = new JButton("Add Spouse"); 
    JButton update = new JButton("Update");

    //West panel
    JPanel westPanel = new JPanel(new BorderLayout()); 
    JLabel members = new JLabel("Family Members:");   
    DefaultListModel memberListModel = new DefaultListModel();
    JList<String> membersList = new JList<>(memberListModel);
    JScrollPane memberScroll = new JScrollPane(membersList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
    
    JPanel westBtnPanel = new JPanel();
    JButton newTree = new JButton("New Family");
    JButton loadTree = new JButton("Load Family");
    JButton saveTree = new JButton("Save Family");
    
    //Center panel        
    JPanel centerPanel = new JPanel(new BorderLayout());    
    
    DefaultListModel treeListModel = new DefaultListModel();
    JList<String> treeList = new JList<>(treeListModel);
    JScrollPane treeScroll = new JScrollPane(treeList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
    
    
    //Add member window
    JFrame addNewMember = new JFrame("Add Family Member");
    JLabel ANMTitle = new JLabel();
    JPanel ANMBInputPanel = new JPanel(new GridLayout(0,2));
    JLabel ANMFName = new JLabel("First Name: ");
    JLabel ANMBSurname = new JLabel("Surname  (before marriage): ");
    JLabel ANMMSurname = new JLabel("Surname (after marriage): ");
    JLabel ANMgender = new JLabel("Gender: ");
    JLabel ANMaddress = new JLabel("Address");    
    JLabel ANMaddressSNum = new JLabel("Street Number: ");  
    JLabel ANMaddressSName = new JLabel("Street Name: ");       
    JLabel ANMaddressSub = new JLabel("Suburb: "); 
    JLabel ANMaddressPcode = new JLabel("Postcode: ");  
    JLabel ANMdescription = new JLabel("Description: ");
    JLabel ANMmother = new JLabel("Mother: ");
    JLabel ANMfather = new JLabel("Father: ");
    JLabel ANMspouse = new JLabel("Spouse: ");
    
    JTextField ANMfNameTxt = new JTextField();
    JTextField ANMsBNameTxt = new JTextField();
    JTextField ANMsMNameTxt = new JTextField();
    JComboBox ANMgenderTxt = new JComboBox(genderList);
    //JTextField ANMgenderTxt = new JTextField();
    JTextField ANMaddressTxt = new JTextField();   
    JTextField ANMaddressSNumTxt = new JTextField();  
    JTextField ANMaddressSNameTxt = new JTextField();       
    JTextField ANMaddressSubTxt = new JTextField(); 
    JTextField ANMaddressPcodeTxt = new JTextField();        
    JTextField ANMdescriptionTxt = new JTextField();
    JTextField ANMmotherTxt = new JTextField();
    JTextField ANMfatherTxt = new JTextField();
    JTextField ANMspouseTxt = new JTextField();   
    
    JPanel ANMBtnPanel = new JPanel();
    JButton saveMember = new JButton("Save");
    JButton cancelMember = new JButton("Cancel");
    
    /**
     * Sets up the GUI to display the appropriate panels, buttons, inputs 
     * and labels
     */
    GUI()
    {    
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(1280,720);
        mainframe.setVisible(true);
        contentPane.setLayout(new BorderLayout());        
        
        //North panel
        northPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        title.setFont(titleFont);
        
        view.addActionListener((ActionEvent e) -> {
            SwitchMode();
        });
        
        edit.addActionListener((ActionEvent e) -> {
            SwitchMode();
        });
        
        northTitle.add(title);
        northBtns.add(view);
        northBtns.add(edit);

        northPanel.add(northTitle,BorderLayout.NORTH);
        northPanel.add(northBtns,BorderLayout.SOUTH);

        //South panel
        southPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        southPanel.add(footer);
        southPanel.add(exit);

        //East panel
        eastPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        details.setFont(headerFont);
        
        
        motherTxt.setEditable(false);
        fatherTxt.setEditable(false);
        spouseTxt.setEditable(false);     
        childrenTxt.setEditable(false);

        detailsPanel.add(fName);
        detailsPanel.add(fNameTxt);
        detailsPanel.add(sBName);
        detailsPanel.add(sBNameTxt);
        detailsPanel.add(sMName);
        detailsPanel.add(sMNameTxt);
        detailsPanel.add(gender);
        detailsPanel.add(genderTxt);
        detailsPanel.add(address);
        detailsPanel.add(new JLabel(""));
        detailsPanel.add(addressSNum);
        detailsPanel.add(addressSNumTxt);
        detailsPanel.add(addressSName);
        detailsPanel.add(addressSNameTxt);
        detailsPanel.add(addressSub);
        detailsPanel.add(addressSubTxt);
        detailsPanel.add(addressPcode);
        detailsPanel.add(addressPcodeTxt);
        detailsPanel.add(description);
        detailsPanel.add(descriptionTxt); 
        detailsPanel.add(mother);
        detailsPanel.add(motherTxt);      
        detailsPanel.add(father);
        detailsPanel.add(fatherTxt);          
        detailsPanel.add(spouse);      
        detailsPanel.add(spouseTxt);      
        detailsPanel.add(children);      
        detailsPanel.add(childrenScroll);
        
        eastBtnPanel.add(addMother);
        eastBtnPanel.add(addFather);
        eastBtnPanel.add(addSpouse);
        eastBtnPanel.add(addChild);
        eastBtnPanel.add(update);
        
        addChild.addActionListener((ActionEvent e) -> {
            OpenAddMember("Child");
        });
        
        addFather.addActionListener((ActionEvent e) -> {
            OpenAddMember("Father");
        });
        
        addMother.addActionListener((ActionEvent e) -> {
            OpenAddMember("Mother");
        });
        
        addSpouse.addActionListener((ActionEvent e) -> {
            OpenAddMember("Spouse");
        });
        
        update.addActionListener((ActionEvent e) -> {
            updateMember(BTree.GetFamily().get(membersList.getSelectedIndex()));
        });

        eastPanel.add(details,BorderLayout.NORTH);
        eastPanel.add(detailsPanel);
        eastPanel.add(eastBtnPanel,BorderLayout.SOUTH);

        //West panel
        westPanel.setBorder(BorderFactory.createLineBorder(Color.black)); 
        members.setFont(headerFont);  
        
        newTree.addActionListener((ActionEvent e) -> {
            OpenAddMember("Family");
        });
        
        saveTree.addActionListener((ActionEvent e) -> {
            SaveTree();
        });
        
        loadTree.addActionListener((ActionEvent e) -> {
            LoadTree();
        });
        
        membersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        membersList.addListSelectionListener((ListSelectionEvent ls) -> {
            ShowTree(membersList.getSelectedIndex());
            UpdateDetailsPanel(BTree.GetFamily().get(membersList.getSelectedIndex()));
        });
        
        westBtnPanel.add(newTree);
        westBtnPanel.add(saveTree);
        westBtnPanel.add(loadTree);
        
        westPanel.add(members,BorderLayout.NORTH);   
        westPanel.add(memberScroll);
        westPanel.add(westBtnPanel,BorderLayout.SOUTH);

        //Center panel
        treeList.setEnabled(false);
        centerPanel.add(treeList);
        
        //Add each panel to the frame
        contentPane.add(northPanel,BorderLayout.NORTH);
        contentPane.add(southPanel,BorderLayout.SOUTH);
        contentPane.add(eastPanel,BorderLayout.EAST);
        contentPane.add(westPanel,BorderLayout.WEST);
        contentPane.add(centerPanel,BorderLayout.CENTER);
        
        
        //Add member window     
        ANMTitle.setFont(headerFont);
        addNewMember.setSize(400,400);
        addNewMember.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
                CloseAddMember();
            }
        });
        
        cancelMember.addActionListener((ActionEvent e) -> {
            CloseAddMember();
        });
        
        ANMBInputPanel.add(ANMFName);
        ANMBInputPanel.add(ANMfNameTxt);
        ANMBInputPanel.add(ANMBSurname);
        ANMBInputPanel.add(ANMsBNameTxt);
        ANMBInputPanel.add(ANMMSurname);
        ANMBInputPanel.add(ANMsMNameTxt);
        ANMBInputPanel.add(ANMgender);
        ANMBInputPanel.add(ANMgenderTxt);
        ANMBInputPanel.add(ANMaddress);
        ANMBInputPanel.add(new JLabel(""));
        ANMBInputPanel.add(ANMaddressSNum);
        ANMBInputPanel.add(ANMaddressSNumTxt);
        ANMBInputPanel.add(ANMaddressSName);
        ANMBInputPanel.add(ANMaddressSNameTxt);
        ANMBInputPanel.add(ANMaddressSub);
        ANMBInputPanel.add(ANMaddressSubTxt);
        ANMBInputPanel.add(ANMaddressPcode);
        ANMBInputPanel.add(ANMaddressPcodeTxt);
        ANMBInputPanel.add(ANMdescription);
        ANMBInputPanel.add(ANMdescriptionTxt); 
        
        ANMBtnPanel.add(saveMember);
        ANMBtnPanel.add(cancelMember);
        
        addNewMember.add(ANMTitle,BorderLayout.NORTH);
        addNewMember.add(ANMBInputPanel,BorderLayout.CENTER);
        addNewMember.add(ANMBtnPanel,BorderLayout.SOUTH);
        
        view.setEnabled(false);
        edit.setEnabled(true);        
        AlterDetails(false);
    }

    /**
     * Updates the details to panel to reflect the details of one
     * 
     * @param one   family member selected
     */
    void UpdateDetailsPanel(FMember one)
    {
        fNameTxt.setText(one.GetFirstName());
        sBNameTxt.setText(one.GetBirthSurname());
        sMNameTxt.setText(one.GetMarriageSurname());

        if(one.GetGender()=='M')
        {                
            genderTxt.setSelectedIndex(1);
        }
        else if(one.GetGender()=='F')
        {
            genderTxt.setSelectedIndex(0);
        }
        
        addressSNumTxt.setText(one.GetAddress().GetStreetNum()); 
        addressSNameTxt.setText(one.GetAddress().GetStreetName()); 
        addressSubTxt.setText(one.GetAddress().GetSuburb()); 
        addressPcodeTxt.setText(one.GetAddress().GetPostcode());
        
        descriptionTxt.setText(one.GetDescription());
        
        if(one.GetMother()!=null)
        {  
            motherTxt.setText(one.GetMother().GetFirstName());
        }
        else
        {
            motherTxt.setText("");
        }
        if(one.GetFather()!=null)
        {  
            fatherTxt.setText(one.GetFather().GetFirstName());
        }
        else
        {
            fatherTxt.setText("");
        }
        if(one.GetSpouse()!=null)
        {  
            spouseTxt.setText(one.GetSpouse().GetFirstName());
        }   
        else
        {
            spouseTxt.setText("");
        }     

        String childrenNames="";
        for(int i = 0;i<one.GetChildren().size();i++)
        {
            childrenNames += one.GetChildren().get(i).GetFirstName() ;
            childrenNames+= "\n";
        }
        childrenTxt.setText(childrenNames);
    }

    /**
     * Enables/disables the details panel. Used when changing modes
     * 
     * @param onoff     
     */
    private void AlterDetails(boolean onoff)
    {
        fNameTxt.setEditable(onoff);
        sBNameTxt.setEditable(onoff);
        sMNameTxt.setEditable(onoff);
        genderTxt.setEnabled(onoff);        
        addressSNumTxt.setEditable(onoff); 
        addressSNameTxt.setEditable(onoff); 
        addressSubTxt.setEditable(onoff); 
        addressPcodeTxt.setEditable(onoff); 
        descriptionTxt.setEditable(onoff); 

        addChild.setEnabled(onoff);
        addSpouse.setEnabled(onoff);
        addMother.setEnabled(onoff);
        addFather.setEnabled(onoff);
        update.setEnabled(onoff);
    }
    
    /**
     * Opens the addNewMember window and customises it based on type
     * 
     * @param type  type of member to be added
     */
    void OpenAddMember(String type)
    {        
        addNewMember.setTitle("Add New " + type);
        ANMTitle.setText("Add New " + type);
                
        saveMember.addActionListener((ActionEvent e) -> {
            SaveAddMember(type);
        });
        
        mainframe.setEnabled(false);
        addNewMember.setVisible(true);
        addNewMember.setLocation(mainframe.getLocation().x+mainframe.getWidth()/2-addNewMember.getWidth()/2,mainframe.getLocation().y+mainframe.getHeight()/2-addNewMember.getHeight()/2);
    }
    
    /**
     * Closes the addNewMember window
     */
    void CloseAddMember()
    {
        mainframe.setEnabled(true);
        addNewMember.setVisible(false);
        ClearActionListener(saveMember);
    }
    
    /**
     * Saves a new member to the current family and updates each of the 
     * appropriate panels
     * 
     * @param type  type of member to be added
     */
    void SaveAddMember(String type)
    {
        if(CheckIfEmptyANM())
        {
            try
            {
                FMember newMember = new FMember(ANMfNameTxt.getText(),ANMsBNameTxt.getText(),ANMsMNameTxt.getText(),ANMgenderTxt.getSelectedItem().toString().charAt(0),new Address(ANMaddressSNumTxt.getText(),ANMaddressSNameTxt.getText(),ANMaddressSubTxt.getText(),ANMaddressPcodeTxt.getText()),ANMdescriptionTxt.getText());

                if(type.equals("Family"))
                {
                    BTree = null;
                    BTree = new FTree(newMember);
                }
                else
                {     
                    BTree.AddMember(newMember,type,membersList.getSelectedIndex());
                }
                CloseAddMember();
                UpdateFamilyList();
                ClearANM();
            }
            catch(Exception ex)
            {
                System.out.println("Problem with input");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(mainframe,"Ensure all data has been entered.");
        }
    }
    
    /**
     * Alternates between Edit and View mode
     */
    void SwitchMode()
    {
        System.out.println(isViewMode);
        if(isViewMode)
        {        
            if(!memberListModel.isEmpty())
            {                    
                isViewMode = false;
                view.setEnabled(true);
                edit.setEnabled(false);

                newTree.setEnabled(false);
                loadTree.setEnabled(false);

                AlterDetails(!isViewMode);
            }
            else
            {
                JOptionPane.showMessageDialog(centerPanel, "No family loaded.");
            }
        }
        else
        {            
            isViewMode = true;
            view.setEnabled(false);
            edit.setEnabled(true);

            newTree.setEnabled(true);
            loadTree.setEnabled(true);

            AlterDetails(!isViewMode);
        }
    }
    
    /**
     * Updates the list of family members in the list in left panel
     */
    void UpdateFamilyList()
    {
        if(BTree.GetFamily().size()>0)
        {
            
            int selInd = membersList.getSelectedIndex();
            for(int i=0;i<BTree.GetFamily().size();i++)
            {
                String surname;
                if(BTree.GetFamily().get(i).GetMarriageSurname().equals(""))
                {
                    surname=BTree.GetFamily().get(i).GetBirthSurname();
                }
                else
                {
                    surname=BTree.GetFamily().get(i).GetMarriageSurname();
                }
                if(memberListModel.size()<=i)
                {
                    memberListModel.addElement(BTree.GetFamily().get(i).GetFirstName() + " " + surname);
                }
                else
                {
                    memberListModel.setElementAt(BTree.GetFamily().get(i).GetFirstName() + " " + surname, i);       
                }

            }
            if(memberListModel.size()>BTree.GetFamily().size())
            {
                for(int i=memberListModel.size()-1;i>BTree.GetFamily().size()-1;i--)
                {
                    memberListModel.remove(i);
                }
            }
            
            if(selInd<0)
            {
                selInd=0;   
            }

            membersList.setSelectedIndex(selInd);
            ShowTree(selInd);
            UpdateDetailsPanel(BTree.GetFamily().get(0));
        }
    }
    
    /**
     * Remove all action listeners from btn
     * 
     * @param btn  button to remove listeners from
     */
    void ClearActionListener(JButton btn)
    {
        for(ActionListener al:btn.getActionListeners())
        {
            btn.removeActionListener(al);
        }
    }
    
    /**
     * Saves family tree as the chosen name to a file
     */
    void SaveTree()
    {
        if(BTree!=null)
        {
            String filename=JOptionPane.showInputDialog(mainframe, "Family Name:",familyName);
            FileOutputStream fos;
            ObjectOutputStream oos;
            if(!filename.trim().equals(""))
            {
                try
                {            
                    familyName=filename;
                    File filed = new File("family");
                    if(!filed.exists()){  if(filed.mkdir()){ System.out.println("directory is created"); }} else{ System.out.println("directory exist");  }
                    fos = new FileOutputStream("family/" + filename + ".ftree");
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(BTree);

                    fos.close();
                }
                catch(FileNotFoundException ex)
                {
                    System.out.println("thing");
                }
                catch(IOException ex)
                {            
                    System.out.println("stuff");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(mainframe,"Enter a valid family name.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(mainframe,"No family to save.");
        }
    }
    
    /**
     * Loads the chosen family from a file
     */
    void LoadTree()
    {
        String path;
        FileInputStream fis;
        ObjectInputStream ois;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")+"/family"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Family Tree","ftree");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal==JFileChooser.APPROVE_OPTION)
        {
            path=chooser.getSelectedFile().getPath();
            
            try
            {
                familyName = chooser.getSelectedFile().getName().replace(".ftree","");
                fis = new FileInputStream(path);
                ois = new ObjectInputStream(fis);
                BTree = (FTree)ois.readObject();
                ois.close();
                
                UpdateFamilyList();
            }
            catch(FileNotFoundException ex)
            {
                System.out.println("thing");
            }
            catch(IOException ex)
            {           
                JOptionPane.showMessageDialog(mainframe,"Problem loading family\n" + ex);
            } 
            catch (ClassNotFoundException ex) 
            {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    /**
     * Updates the family tree in the center panel based on index given
     * 
     * @param index     index of family to begin
     */
    void ShowTree(int index)
    {
        treeListModel.clear();
        FMember base = BTree.GetFamily().get(index);
        
        if(base.GetMother()!=null)
        {          
            treeListModel.addElement("Mother: " + base.GetMother().GetFirstName());
        }
        if(base.GetFather()!=null)
        {
            treeListModel.addElement("Father: " + base.GetFather().GetFirstName());         
        }
        treeListModel.addElement("    Self: " + base.GetFirstName());
        if(base.GetSpouse()!=null)
        {
            treeListModel.addElement("    Spouse: " + base.GetSpouse().GetFirstName());        
        }
        
        if(base.GetChildren().size()>0)
        {
            for(int i=0;i<base.GetChildren().size();i++)
            {            
                treeListModel.addElement("        Child " + (i+1) + ": " + base.GetChildren().get(i).GetFirstName());
                if(base.GetChildren().get(i).GetChildren().size()>0)
                {
                    for(int j=0;j<base.GetChildren().get(i).GetChildren().size();j++)
                    {
                        treeListModel.addElement("            Grandchild " + (j+1) + ": " + base.GetChildren().get(i).GetChildren().get(j).GetFirstName());
                    }
                }
            }
        }
    }
    
    /**
     * Clears the addNewMembers windows text fields
     */
    void ClearANM()
    {
        ANMfNameTxt.setText("");
        ANMsBNameTxt.setText("");
        ANMsMNameTxt.setText("");
        ANMgenderTxt.setSelectedIndex(0);
        ANMaddressTxt.setText("");  
        ANMaddressSNumTxt.setText("");
        ANMaddressSNameTxt.setText("");
        ANMaddressSubTxt.setText(""); 
        ANMaddressPcodeTxt.setText(""); 
        ANMaddressTxt.setText("");
        ANMdescriptionTxt.setText("");
    }
    
    /**
     * Clears the details panel text fields
     */
    void ClearDetails()
    {
        fNameTxt.setText("");
        sBNameTxt.setText("");
        sMNameTxt.setText("");
        genderTxt.setSelectedIndex(0);
        addressSNumTxt.setText("");
        addressSNameTxt.setText("");
        addressSubTxt.setText(""); 
        addressPcodeTxt.setText(""); 
        descriptionTxt.setText("");
        motherTxt.setText("");
        fatherTxt.setText("");
        spouseTxt.setText("");
        childrenTxt.setText("");
    }
    
    /**
     * Updates the details of the currently selected family member 
     * 
     * @param mem  currently selected family member
     */
    void updateMember(FMember mem)
    {
        if(CheckIfEmptyDetails())
        {
            try
            {
                mem.SetFirstName(fNameTxt.getText());
                mem.SetBirthSurname(sBNameTxt.getText());
                mem.SetMarriageSurname(sMNameTxt.getText());
                System.out.println(genderTxt.getSelectedItem().toString().charAt(0));
                mem.SetGender(genderTxt.getSelectedItem().toString().charAt(0));
                mem.SetAddress(new Address(addressSNumTxt.getText(),addressSNameTxt.getText(),addressSubTxt.getText(),addressPcodeTxt.getText()));
                mem.SetDescription(descriptionTxt.getText());
                UpdateFamilyList();
                UpdateDetailsPanel(BTree.GetFamily().get(membersList.getSelectedIndex()));
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(centerPanel, "Ensure all information has been entered correctly.");
                System.out.println(ex.toString());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(mainframe,"Ensure all data has been entered.");
        }
    }
    
    /**
     * Validates the input fields in the details panel to ensure they are not empty
     * 
     * @return boolean
     */
    boolean CheckIfEmptyDetails()
    {
        if(fNameTxt.getText().trim().equals("")){return false;}
        if(sBNameTxt.getText().trim().equals("")){return false;}
        if(addressSNumTxt.getText().trim().equals("")){return false;}
        if(addressSNameTxt.getText().trim().equals("")){return false;}
        if(addressSubTxt.getText().trim().equals("")){return false;}
        if(addressPcodeTxt.getText().trim().equals("")){return false;}
        return !descriptionTxt.getText().trim().equals("");
    }
    
    /**
     * Validates the input fields in the adNewMember window to ensure they are not empty
     * 
     * @return 
     */
    boolean CheckIfEmptyANM()
    {
        if(ANMfNameTxt.getText().trim().equals("")){return false;}
        if(ANMsBNameTxt.getText().trim().equals("")){return false;}
        if(ANMaddressSNumTxt.getText().trim().equals("")){return false;}
        if(ANMaddressSNameTxt.getText().trim().equals("")){return false;}
        if(ANMaddressSubTxt.getText().trim().equals("")){return false;}
        if(ANMaddressPcodeTxt.getText().trim().equals("")){return false;}
        return !ANMdescriptionTxt.getText().trim().equals("");
    }
}