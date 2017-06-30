/*******************************************************************************
 * ElGamal
 * 
 * Created by Rokia on 16/6/17.
 * Copyright © 2017 Rokia. All rights reserved.
 ******************************************************************************/
package it.gssi.elgamal.ec;

import java.math.BigInteger;

import ecc.elliptic.ECParameters;

public class secp512 implements ECParameters {
    private static final BigInteger p 
	= new BigInteger("10530467723362659054861705371139847026313999328372313651398671272025951445569024729948471343061931586610942824229083371331823229156399790385588443550959087", 10);
    
    private static final BigInteger a 
	= (new BigInteger("3")).negate();
    
    private static final BigInteger b 
	= new BigInteger("9111550163858012281440901732746538838772262590143654133938674743542107885492015390851248618042056679983385207705625699101049041930943171450852516780927629", 10);
    
    /*private static final BigInteger S 
	= new BigInteger("C49D3608"+"86E70493"+"6A6678E1"+"139D26B7"+
			 "819F7E90", 16);*/
    
    private static final BigInteger gx
	= new BigInteger("9849140505548221824273974093280520863803721981898650295289577407784805987435267347703390753172946188287923298604401015748009991328195703123581630303753365", 10);

    private static final BigInteger gy
	= new BigInteger("8137390076315174139376266162837733695315251136815544585999671696453078718100697428418227704407665627786508729897119536991731336117176807183540915828594662", 10);
    
    private static final BigInteger n
	= new BigInteger("10530467723362659054861705371139847026313999328372313651398671272025951445569144524507377363887941433449823713742916287342504795006316114468040283111710577", 10);
    
    private static final BigInteger msgx
   	= new BigInteger("1049506514658597560503141933727346904778142582045", 10);

       private static final BigInteger msgy
       	= new BigInteger("5179494360143470133519794265828379238409567733533322295076073142512083970705684659462170240896230729657985818514357776772392107451078717676048818599201154", 10); 
    
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
	return "secp512";
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
