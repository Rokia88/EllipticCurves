/*******************************************************************************
 * ElGamal
 * 
 * Created by Rokia on 16/6/17.
 * Copyright © 2017 Rokia. All rights reserved.
 ******************************************************************************/
package it.gssi.elgamal.ec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

import ecc.*;
import ecc.elliptic.ECKey;
import ecc.elliptic.ECPoint;
import ecc.elliptic.EllipticCurve;

public class ElGamalKey  implements Key{
	
	protected BigInteger sk;
	protected EllipticCurve mother;
	protected ECPoint alpha;
	protected ECPoint beta;
	protected boolean secret;
	
	public ElGamalKey(EllipticCurve ec)
	{
		secret = true;
		mother = ec;
		sk=new BigInteger(ec.getp().bitLength() + 17,Rand.om);
		if (mother.getOrder() != null) sk=sk.mod(mother.getOrder());
		alpha = mother.getGenerator();
		beta= (alpha.multiply(sk));
		
	}

	@Override
	public Key readKey(InputStream in) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeKey(OutputStream out) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ElGamalKey getPublic() {
		ElGamalKey temp = new ElGamalKey(mother);
		((ElGamalKey)temp).beta = beta;
		((ElGamalKey)temp).alpha = alpha;
		((ElGamalKey)temp).sk = BigInteger.ZERO;
		((ElGamalKey)temp).secret = false;
		System.gc();
		return temp;
	}

	@Override
	public boolean isPublic() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
