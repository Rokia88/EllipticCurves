/*******************************************************************************
 * ElGamal
 * 
 * Created by Rokia on 16/6/17.
 * Copyright © 2017 Rokia. All rights reserved.
 ******************************************************************************/
package it.gssi.elgamal.ec;
import java.math.BigInteger;

import ecc.elliptic.ECParameters;

public class secp256 implements ECParameters {
    private static final BigInteger p 
	= new BigInteger("90942894222941581070058735694432465663348344332098107489693037779484723616779", 10);
    
    private static final BigInteger a 
	= (new BigInteger("3")).negate();
    
    private static final BigInteger b 
	= new BigInteger("78688883013276200091698248537162581920209762369847930022367595957783191893217", 10);
    
    /*private static final BigInteger S 
	= new BigInteger("C49D3608"+"86E70493"+"6A6678E1"+"139D26B7"+
			 "819F7E90", 16);*/
    
    private static final BigInteger gx
	= new BigInteger("79904067204659057738119960150841517153774659823093316893475315114039533801454", 10);

    private static final BigInteger gy
	= new BigInteger("24863992577802135486600130266891304459540939953980990422638578475407377752091", 10);
    
    private static final BigInteger n
	= new BigInteger("90942894222941581070058735694432465663288414616171509431879910319924502217783", 10);
    
    private static final BigInteger msgx
   	= new BigInteger("1365414151665090791627570762775764361567648528349", 10);

       private static final BigInteger msgy
       	= new BigInteger("47016484996577168019124076237995497630059806061546074872969902025332059444381", 10); 
    
       public BigInteger msgY() {
       	return msgy;
           }
           
           public BigInteger msgX() {
           	return msgx;
               }
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

    public String toString(){
	return "secp256";
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
