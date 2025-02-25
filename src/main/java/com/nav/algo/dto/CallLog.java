package com.nav.dto;

import java.util.List;
import java.util.ArrayList;

public class CallLog {
private final List<String> callHierarchy = new ArrayList<>();
//Add nee entry to the log
public void addEntry(String className, String methodName)
{
callHierarchy.add(className + "."+methodName);
} 
//Get the full call hierarchy as a string

}