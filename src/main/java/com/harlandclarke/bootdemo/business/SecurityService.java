package com.harlandclarke.bootdemo.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harlandclarke.bootdemo.cache.HazelCast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author root
 */
@Component("securityService")
public class SecurityService {


    @Autowired
    private HazelCast hazelCast;

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    private String uid;
    private String passwd;
    private String sectoken;


    public String getToken(String account, String routingno) {
        this.setUid(account);
        this.setPasswd(routingno);
        String temp = account + routingno;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(temp.getBytes());
            byte[] messageDigestMD5 = messageDigest.digest();
            StringBuilder stringBuffer = new StringBuilder();
            for (byte bytes : messageDigestMD5) {
                stringBuffer.append(String.format("%02x", bytes & 0xff));
            }

            logger.debug("key:" + this.getUid());
            logger.debug("token:" + stringBuffer.toString());
            this.setSectoken(stringBuffer.toString());
            // hazelCast.put(this.getUid(), stringBuffer.toString());
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException exception) {
            logger.debug(exception.toString());
        }
        return null;

    }


    public String getUid() {
        return uid;
    }


    public void setUid(String uid) {
        this.uid = uid;
    }


    public String getPasswd() {
        return passwd;
    }


    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }


    public String getSectoken() {
        return sectoken;
    }


    public void setSectoken(String sectoken) {
        this.sectoken = sectoken;
    }


}