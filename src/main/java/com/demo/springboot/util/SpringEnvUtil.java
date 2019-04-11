package com.demo.springboot.util;

import com.demo.springboot.constant.ProfileEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/11
 * @time 17:44
 */


@Configuration
public class SpringEnvUtil implements EnvironmentAware {
    private static Environment enviroment;

    @Override
    public void setEnvironment(Environment environment) {
        SpringEnvUtil.enviroment = environment;
    }

    public static Environment getEnv(){
        return enviroment;
    }

    public static ProfileEnum getProfileType(){
        String[] activeProfiles = enviroment.getActiveProfiles();
        if(activeProfiles.length==1){
            String profile = activeProfiles[0];
            if(profile.startsWith(ProfileEnum.LOCAL.name().toLowerCase())){
                return ProfileEnum.LOCAL;
            }else if(profile.startsWith(ProfileEnum.DEV.name().toLowerCase())){
                return ProfileEnum.DEV;
            }else if(profile.startsWith(ProfileEnum.TEST.name().toLowerCase())){
                return ProfileEnum.TEST;
            }else if(profile.startsWith(ProfileEnum.PRE.name().toLowerCase())){
                return ProfileEnum.PRE;
            }else if(profile.startsWith(ProfileEnum.PRO.name().toLowerCase())){
                return ProfileEnum.PRO;
            }
        }
        return ProfileEnum.UNKOWN;
    }
}
