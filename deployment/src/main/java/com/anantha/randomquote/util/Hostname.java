package com.anantha.randomquote.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Hostname {

static String hostname = "Unknown";

public static String getHostname() {
	try
	{
	    InetAddress addr;
	    addr = InetAddress.getLocalHost();
	    hostname = addr.getHostName();
	}
	catch (UnknownHostException ex)
	{
	    System.out.println("Hostname can not be resolved");
	}

	return hostname;
}	

}
