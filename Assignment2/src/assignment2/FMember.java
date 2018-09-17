package assignment2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Samuel Brownley 31691379
 * @version 1.0
 * @date 22/05/2017
 * @filename FMember.java
 */
public class FMember implements Serializable
{
    /**
     * Used for saving/loading objects
     */
    private static final long serialVersionUID = 1L;
    /**
     * First name of family member
     */
    String fname;
    /**
     * Surname before marriage
     */
    String bSurname;
    /**
     * Surname after marriage
     */
    String mSurname;
    /**
     * Gender of family member
     */
    char gender;
    /**
     * Address of family member
     */
    Address address;
    /**
     * Details known about the life of family member
     */
    String description;
    /**
     * Mother of family member
     */
    FMember mother;
    /**
     * Father of family member
     */
    FMember father;
    /**
     * Spouse of family member
     */
    FMember spouse;
    /**
     * Children of family member
     */
    ArrayList<FMember> child = new ArrayList<>();  
    
    /**
     * Creates new family member using the parameters
     * 
     * @param nFName        first name 
     * @param nBSurname     surname before marriage
     * @param nMSurname     surname after marriage
     * @param nGen          gender
     * @param nAddress      address
     * @param nDescription  description of life
     */
    FMember(String nFName,String nBSurname,String nMSurname,char nGen,Address nAddress,String nDescription)
    {
        SetFirstName(nFName);
        SetBirthSurname(nBSurname);
        SetMarriageSurname(nMSurname);
        SetGender(nGen);
        SetAddress(nAddress);
        SetDescription(nDescription);
    }
    
    /**
     * Gets first name
     * 
     * @return String
     */
    String GetFirstName()
    {
        return fname;
    }
    
    /**
     * Sets first name to newname
     * @param newname   new first name
     */
    void SetFirstName(String newname)
    {
        fname=newname;
    }
    
    /**
     * Gets surname before birth
     * 
     * @return  String
     */
    String GetBirthSurname()
    {
        return bSurname;
    }
    
    /**
     * Sets surname before birth to newname
     * 
     * @param newname   new surname before birth
     */
    void SetBirthSurname(String newname)
    {
        bSurname = newname;
    }
    
    /**
     * Gets the surname after marriage
     * 
     * @return String
     */
    String GetMarriageSurname()
    {
        return mSurname;
    }
    
    /**
     * Sets the surname after marriage to newname
     * 
     * @param newname   new surname after marriage
     */
    void SetMarriageSurname(String newname)
    {
        mSurname = newname;
    }
    
    /**
     * Gets gender
     * 
     * @return char
     */
    char GetGender()
    {
        return gender;
    }
    
    /**
     * Sets gender to newgender
     * 
     * @param newgender     new gender
     */
    void SetGender(char newgender)
    {
        char gen = Character.toUpperCase(newgender);
        if(gen=='M' || gen=='F')
        {
            gender = gen;
        }
        else
        {
            gender='M';
        }        
    }
    
    /**
     * Gets the address
     * 
     * @return Address
     */
    Address GetAddress()
    {
        return address;
    }
    
    /**
     * Set address to the newaddress
     * 
     * @param newaddress    new address
     */
    void SetAddress(Address newaddress)
    {
        address = newaddress;
    }
    
    /**
     * Gets description of life
     * 
     * @return String
     */
    String GetDescription()
    {
        return description;
    }
    
    /**
     * Sets description to nDescription
     * 
     * @param nDescription new description
     */
    void SetDescription(String nDescription)
    {
        description = nDescription;
    }
    
    /**
     * Gets mother
     * 
     * @return FMember
     */
    FMember GetMother()
    {
        return mother;
    }
    
    /**
     * Set mother to newmom
     * 
     * @param newmom  new mother
     */
    void SetMother(FMember newmom)
    {
        mother = newmom;
    }
    
    /**
     * Gets father
     * 
     * @return FMember
     */
    FMember GetFather()
    {
        return father;
    }
    
    /**
     * Set father to newdad
     * 
     * @param newdad  new father
     */
    void SetFather(FMember newdad)
    {
        father = newdad;
    }
    
    /**
     * Gets spouse
     * 
     * @return  FMember
     */
    FMember GetSpouse()
    {
        return spouse;
    }
    
    /**
     * Set spouse to newspouse
     * 
     * @param newspouse  new spouse
     */
    void SetSpouse(FMember newspouse)
    {
        spouse=newspouse;
    }
    
    /**
     * Gets list of children
     * 
     * @return ArrayList<FMember> 
     */
    ArrayList<FMember> GetChildren()
    {
        return child;
    }
    
    /**
     * Adds newchild to the lsit of children
     * 
     * @param newchild new child
     */
    void AddChild(FMember newchild)
    {
        child.add(newchild);
    }
}
