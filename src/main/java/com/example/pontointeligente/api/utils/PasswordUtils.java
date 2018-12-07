package com.example.pontointeligente.api.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/

public class PasswordUtils {

	private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);

	public PasswordUtils() {
	}

	public static String gerarBCrypt(String senha) {
		if (senha == null)
			return senha;

		log.info("Gerando hash com BCrypt");

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			return new String(md.digest(senha.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		/*
		 * BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder(); return
		 * bCryptEncoder.encode(senha);
		 */
	}

}
