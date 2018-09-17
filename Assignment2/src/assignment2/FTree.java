package assignment2;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Samuel Brownley 31691379
 * @version 1.0
 * @date 22/05/2017
 * @filename FTree.java
 */
public class FTree  implements Serializable
{
    /**
     * Used for saving/loading objects
     */
    private static final long serialVersionUID = 1L;
    /**
     * The base person of the family
     */
    private FMember startingPerson;
    /**
     * List of all family members
     */
    private ArrayList<FMember> family;
    
    /**
     * Creates a FTree object using startPerson as the base family member
     * 
     * @param startPerson 
     */
    FTree(FMember startPerson)
    {
        family = new ArrayList<>();
        SetStartPerson(startPerson);
    }
    
    /**
     * Sets the base person of the family to newStart
     * 
     * @param newStart  new base family member
     */
    void SetStartPerson(FMember newStart)
    {
        startingPerson = newStart;  
        if(family.size()>0)
        {
            family.set(0,startingPerson);
        }
        else
        {
            family.add(startingPerson);
        }
    }
    
    /**
     * Add a new family member of the appropriate type to the member at index
     * 
     * @param newMem    new family member
     * @param type      type of family member (Child, mother, father, spouse)
     * @param index     index in family to add the new family member
     */
    void AddMember(FMember newMem, String type,int index)
    {
        if(type.equals("Child"))
        {
            family.get(index).AddChild(newMem);
        }
        else if(type.equals("Mother"))
        {
            family.get(index).SetMother(newMem);
        }
        else if(type.equals("Father"))
        {
            family.get(index).SetFather(newMem);
        }
        else if(type.equals("Spouse"))
        {
            family.get(index).SetSpouse(newMem);
        }
        family.add(newMem);
    }
    
    /**
     * Returns entire family
     * 
     * @return list of family members
     */
    ArrayList<FMember> GetFamily()
    {
        return family;
    }    
}
