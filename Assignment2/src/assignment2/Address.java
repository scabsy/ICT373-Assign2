package assignment2;

import java.io.Serializable;

/**
 * @author Samuel Brownley 31691379
 * @version 1.0
 * @date 22/05/2017
 * @filename Address.java
 */
public class Address implements Serializable
{
    /**
     * Used for saving/loading objects
     */
    private static final long serialVersionUID = 1L;
    /**
     * Street number of address
     */
    private String streetNum;
    /**
     * Street name of address
     */
    private String streetName;
    /**
     * Suburb of address
     */
    private String suburb;
    /**
     * Postcode of address
     */
    private String postcode;
    
    /**
     * Creates a new address for the given details
     * 
     * @param nStreetNum    street number of address
     * @param nStreetName   street name of address
     * @param nSuburb       suburb of address
     * @param nPostcode     postcode of address
     */
    Address(String nStreetNum, String nStreetName, String nSuburb, String nPostcode)
    {
        SetStreetNum(nStreetNum);
        SetStreetName(nStreetName);
        SetSuburb(nSuburb);
        SetPostcode(nPostcode);
    }
    
    /**
     * Returns street number of address
     * 
     * @return String
     */
    String GetStreetNum()
    {
        return streetNum;
    }
    
    /**
     * Sets the streetNum to newnum
     * 
     * @param newnum    new street number
     */
    void SetStreetNum(String newnum)
    {
        streetNum = newnum;
    }
    
    /**
     * Returns street name of address
     * 
     * @return 
     */
    String GetStreetName()
    {
        return streetName;
    }
    
    /**
     * Set streetName to newname
     * 
     * @param newname 
     */
    void SetStreetName(String newname)
    {
        streetName = newname;
    }
    
    /**
     * Returns suburb of address
     * 
     * @return 
     */
    String GetSuburb()
    {
        return suburb;
    }
    
    /**
     * Sets suburb to newsub
     * 
     * @param newsub 
     */
    void SetSuburb(String newsub)
    {
        suburb = newsub;
    }
    
    /**
     * Returns postcode of address
     * 
     * @return 
     */
    String GetPostcode()
    {
        return postcode;
    }
    
    /**
     * Set postcode to newpcode
     * @param newpcode 
     */
    void SetPostcode(String newpcode)
    {
        postcode = newpcode;
    }    
}
