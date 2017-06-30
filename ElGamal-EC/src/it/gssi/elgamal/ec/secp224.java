/*******************************************************************************
 * ElGamal
 * 
 * Created by Rokia on 16/6/17.
 * Copyright © 2017 Rokia. All rights reserved.
 ******************************************************************************/
package it.gssi.elgamal.ec;
import java.math.BigInteger;

import ecc.elliptic.ECParameters;

public class secp224 implements ECParameters {
    private static final BigInteger p 
	= new BigInteger("21174292597673270169193562049053717791882423761323585056162680913631", 10);
    
    private static final BigInteger a 
	= new BigInteger("-3");
    
    private static final BigInteger b 
	= new BigInteger("18321183280385145938884990414875229336370193019939570227257813318147", 10);
    
    /*private static final BigInteger S 
	= new BigInteger("C49D3608"+"86E70493"+"6A6678E1"+"139D26B7"+
			 "819F7E90", 16);*/
    
    private static final BigInteger gx
	= new BigInteger("4726868729535986298732050888587201091808398859997396461078363095773", 10);

    private static final BigInteger gy
	= new BigInteger("9893324658193121368595084506565815829044897400778736292435118678210", 10);
    
    private static final BigInteger n
	= new BigInteger("21174292597673270169193562049053723134442099121024262551089688143309", 10);
    
    private static final BigInteger msgx
   	= new BigInteger("1170344584770812966667356067643723127703852880149", 10);

       private static final BigInteger msgy
       	= new BigInteger("2293950372698764282494114106527792985411304558299985524972990748153", 10); 
    
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

    public BigInteger generatorY() {
	return gy;
    }

    public BigInteger order() {
	return n;
    }
    
    public BigInteger msgY() {
    	return msgy;
        }
        
        public BigInteger msgX() {
        	return msgx;
            }

    public String toString(){
	return "secp224";
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
