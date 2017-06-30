/*******************************************************************************
 * ElGamal
 * 
 * Created by Rokia on 16/6/17.
 * Copyright © 2017 Rokia. All rights reserved.
 ******************************************************************************/
package it.gssi.elgamal.ec;
import java.math.BigInteger;

import ecc.elliptic.ECParameters;

public class secp160 implements ECParameters {
			
    private static final BigInteger p 
	= new BigInteger("1147860701762054730346201299935827782113538756127", 10);
    
    private static final BigInteger a 
	= new BigInteger("-3");
    
    private static final BigInteger b 
	= new BigInteger("993193335754933797118314178888153828594854512705", 10);
    
    //private static final BigInteger S 
  	//= new BigInteger("1053CDE4"+"2C14D696"+"E6768756"+"1517533B"+"F3F83345", 16);
  
    private static final BigInteger gx
	= new BigInteger("149030953802387988890481475034797473420181310462", 10);

    private static final BigInteger gy
    	= new BigInteger("1055989080595414487475030903108133024108643333859", 10);

    private static final BigInteger n
  	= new BigInteger("1147860701762054730346200648614608152209809891831", 10);
    
    private static final BigInteger msgx
   	= new BigInteger("787994052312353708514835258069991399000520539260", 10);

       private static final BigInteger msgy
       	= new BigInteger("650595466584755486705616728205044445594710842173", 10);

  
    public BigInteger a() {
	return a;
    }

    public BigInteger b() {
	return b;
    }

    public BigInteger p() {
	return p;
    }

    public BigInteger generatorX() {
	return gx;
    }

    public BigInteger msgY() {
	return msgy;
    }
    
    public BigInteger msgX() {
    	return msgx;
        }

    public BigInteger order() {
	return n;
    }

    public String toString(){
	return "secp160";
    }

    public static void main(String[] args) {
	System.out.println("a:  "+a);
	System.out.println("b:  "+b);
	System.out.println("p:  "+p);
	System.out.println("gx: "+gx);
	System.out.println("gy: "+gy);
	System.out.println("n:  "+n);
	System.out.println("p.toByteArray().length: "+p.toByteArray().length);
    }

	@Override
	public BigInteger generatorY() {
		// TODO Auto-generated method stub
		return gy;
	}

	@Override
	public BigInteger generator2X() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigInteger generator2Y() {
		// TODO Auto-generated method stub
		return null;
	}
}
