/*******************************************************************************
 * ElGamal
 * 
 * Created by Rokia on 16/6/17.
 * Copyright © 2017 Rokia. All rights reserved.
 ******************************************************************************/
package it.gssi.elgamal.ec;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import ecc.elliptic.*;


public class Main {
	
	private final static int NbrTrials = 200;
	
	public static ECParameters createEC(int keyL)
	{
		ECParameters sec = null;
		switch (keyL) {
		case 160:
			sec = new secp160();
			break;
		case 224:
			sec = new secp224();
			break;
		case 256:
			sec = new secp256();
			break;
		case 384:
			sec = new secp384();
			break;
		case 512:
			sec = new secp512();
			break;
		default:
			break;
		}
		return sec;
	}
	
	public static void main(String[] args) throws NoCommonMotherException, NotOnMotherException, FileNotFoundException, UnsupportedEncodingException {
		try {
			
			int[] keyL = {160,224,256,384,512};
			
			ECParameters sec;
			double durationE;
			double durationD;
			long start;
			PrintWriter writer = new PrintWriter("ExecutionTimeElGamal-EC.txt", "UTF-8");
			writer.format("%-15s  |%-15s  |%-15s  |\n\n","keyLength", "encrypt(ms)","decrypt(ms)");
			writer.flush();
			for(int i = 0; i < keyL.length; i++)
			{
					sec = createEC(keyL[i]);
					
				 	EllipticCurve ec = new EllipticCurve(sec);

				    ElGamalCryptoSystem cs = new ElGamalCryptoSystem(ec);

				    ElGamalKey sk = (ElGamalKey)cs.generateKey();
				    ElGamalKey pk = sk.getPublic();
				     
				    
				    ECPoint x = new ECPoint(sk.mother,sec.msgX(),sec.msgY());

				    for(int k = 0; k < NbrTrials; k++)
				    {
				    	ECPoint[] c = null;
				    	start = System.currentTimeMillis();
				    	for(int j=0; j < 1000; j++)
					    {
				    		c = cs.encrypt(x, pk);
					    }
					    durationE = (System.currentTimeMillis()-start)/1000;
					    
					    ECPoint x1 = null;
					    start = System.currentTimeMillis();
					    for(int j=0; j < 1000; j++)
					    {
					    	x1 = cs.decrypt(c, sk);
					    }				     
					    durationD = (System.currentTimeMillis()-start)/1000;
					    
					    if(x.getx().compareTo(x1.getx()) == 0 && x.gety().compareTo(x1.gety()) == 0)
					    {
					    	
					    	writer.format("%-15d  |%-15.2f  |%-15.2f  |\n", keyL[i],durationE,durationD);
					    	writer.flush();
					    }
					    else {
						  
					    	writer.format("%-15d  |%-45s  |\n", keyL[i],"computation error");
					    	writer.flush();
					    }  	
				    }
				    
			}
			writer.close();
			
		} catch (InsecureCurveException e) {
		    System.out.println("TestCryptoStreams: "+e);
		}
	    }
}
