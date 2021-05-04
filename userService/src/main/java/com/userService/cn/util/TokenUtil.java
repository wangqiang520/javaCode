package com.userService.cn.util;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.userService.cn.util.ConstantEnum;
import com.userService.cn.util.ResultEnum;

/**   
 * @ClassName: TokenUtils   
 * @Description: 使用token验证用户是否登录
 * @author: 王强
 * @date: 2020年4月29日 上午2:24:09     
 */
public class TokenUtil {
	private static Logger logger=LoggerFactory.getLogger(TokenUtil.class);
	private static String DATA="data";

    /**   
     * @Title: token 
     * @Description: 生成Token
     * @param data 数据
     * @param maxTime 过期时间
     * @return String
     * @throws  
     */
    public static String getToken (String data,long maxTime){
        String token = null;
        try {
        	//过期时间
        	long expirDate=Long.parseLong(ConstantEnum.EXPIRE_DATE.getValue());
        	expirDate=maxTime==0?expirDate:maxTime;
            Date date = new Date(System.currentTimeMillis()+expirDate);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(ConstantEnum.TOKEN_SECRET.getValue());
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("type","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim(DATA,data)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            logger.error(e.getMessage());
            logger.error(ResultEnum.GENERATION_TOKEN_ERROR.getMsg());
            return  token;
        }
        return token;
    }

    /**   
     * @Title: checkToken 
     * @Description:校验Token
     * @param token
     * @return boolean
     * @throws  
     */
    public static boolean checkToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(ConstantEnum.TOKEN_SECRET.getValue());
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        }catch (Exception e){
        	logger.error(e.getMessage());
            logger.error(ResultEnum.CHECK_TOKEN_ERROR.getMsg());
            return  false;
        }
    }
    /**   
     * @Title: encodeTokenValue 
     * @Description: 解密Token里的值
     * @param token
     * @return String
     * @throws  
     */
    public static String encodeTokenValue(String token) {
    	String tokenValue=null;
    	 try {
             Algorithm algorithm = Algorithm.HMAC256(ConstantEnum.TOKEN_SECRET.getValue());
             JWTVerifier verifier = JWT.require(algorithm).build();
             DecodedJWT jwt=verifier.verify(token);
             tokenValue=jwt.getClaim(DATA).asString();
             return tokenValue;
         }catch (Exception e){
         	logger.error(e.getMessage());
            logger.error(ResultEnum.CHECK_TOKEN_ERROR.getMsg());
            return tokenValue;
         }
    }
    
    public static void main(String[] args) {
       String username ="zhangsan";
        String password = "123";
        String token = getToken(username,998l);
        System.out.println(token);
        boolean b = checkToken(token);
        System.out.println(b);
       String encode= encodeTokenValue(token);
       System.out.println(encode);
    }
}