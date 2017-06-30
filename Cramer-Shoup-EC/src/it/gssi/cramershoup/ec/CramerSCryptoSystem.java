/*******************************************************************************
 * Cramer-Shoup
 * 
 * Created by Rokia on 16/6/17.
 * Copyright © 2017 Rokia. All rights reserved.
 ******************************************************************************/
package it.gssi.cramershoup.ec;

import java.math.BigInteger;
import java.security.MessageDigest;

import ecc.CryptoSystem;
import ecc.Key;
import ecc.Rand;
import ecc.elliptic.ECPoint;
import ecc.elliptic.EllipticCurve;
import ecc.elliptic.NoCommonMotherException;
import ecc.elliptic.NotOnMotherException;


public class CramerSCryptoSystem implements CryptoSystem{
	
	MessageDigest hash;
	
	private EllipticCurve ec;
	
	 public CramerSCryptoSystem(EllipticCurve ec) {
			this.ec = ec;
			try {
			    hash = MessageDigest.getInstance("SHA-512");
			} catch (java.security.NoSuchAlgorithmException e) {
			    System.out.println("RSACryptoSystem: THIS CANNOT HAPPEN\n"+e);
			    System.exit(0);
			}
		    }

	@Override
	public byte[] encrypt(byte[] plain, int numbytes, Key key) {
		return null;
	}
	
	public ECPoint[] encrypt(ECPoint x ,Key key) throws NoCommonMotherException, NotOnMotherException {
	CramerSKey ck = (CramerSKey) key;

	BigInteger rk = new BigInteger(ck.mother.getp().bitLength() + 17, Rand.om);
	if (ck.mother.getOrder() != null) {
	    rk = rk.mod(ck.mother.getOrder());
	}
	ECPoint u1 = ck.alpha.multiply(rk);

	ECPoint u2 = ck.beta.multiply(rk);
	
	ECPoint e = x.add(ck.h.multiply(rk));
	hash.reset();
	hash.update(u1.compress());
	hash.update(u2.compress());
	hash.update(e.compress());
	byte[] digest = hash.digest();
	BigInteger H = new BigInteger(digest);
	//System.out.print("encrypt");
	//System.out.println(H+",");
	ECPoint val, val2,v;
	if(H.signum()== -1)
	{
		val = ck.d.multiply(rk.multiply(H.abs()));
		val2 = new ECPoint(ck.mother,val.getx(),val.gety().negate());	
		v = (ck.c.multiply(rk)).add(val2);
	}
	else
	{
		v = (ck.c.multiply(rk)).add(ck.d.multiply(rk.multiply(H)));
	}
	
	ECPoint[] res = {u1,u2,e,v};

	
	return res;
	}

	@Override
	public byte[] decrypt(byte[] cipher, Key dk) {
	
		return null;
	}
	
	public ECPoint decrypt(ECPoint[] cipher, Key key) throws NoCommonMotherException, NotOnMotherException {
		CramerSKey dk = (CramerSKey) key;
		hash.reset();
		hash.update(cipher[0].compress());
		hash.update(cipher[1].compress());
		hash.update(cipher[2].compress());
		byte[] digest = hash.digest();
		BigInteger H = new BigInteger(digest);
		//System.out.println("decrypt");
		//System.out.println(H+",");
		ECPoint val = null;
		ECPoint x= null,val2 = null, val3= null;
		if(H.signum()!= -1)
		{
			val = (((cipher[0].multiply(dk.x1)).add(cipher[1].multiply(dk.x2))).add(cipher[0].multiply(dk.y1.multiply(H)))).add(cipher[1].multiply(dk.y2.multiply(H)));
		}
		else if(H.signum()== -1)
		{
			val = (((cipher[0].multiply(dk.x1)).add(cipher[1].multiply(dk.x2))));
			val3 = cipher[0].multiply(dk.y1.multiply(H.abs()));
			val2 = new ECPoint(dk.mother,val3.getx(),val3.gety().negate());	
			val = val.add(val2);
			
			val3 = cipher[1].multiply(dk.y2.multiply(H.abs()));
			val2 = new ECPoint(dk.mother,val3.getx(),val3.gety().negate());	
			val = val.add(val2);
			
		}
		
		if(val.getx().compareTo(cipher[3].getx())==0 && val.gety().compareTo(cipher[3].gety())==0)
		{
			val2 = new ECPoint(dk.mother,cipher[0].getx(),cipher[0].gety().negate());
	    	x = cipher[2].add(val2.multiply(dk.z));
	    }	
		
		return x;
	}

	@Override
	public Key generateKey() throws NoCommonMotherException {
		
		return new CramerSKey(ec);
	}

	@Override
	public int blockSize() {
		
		return 20;
	}

}
