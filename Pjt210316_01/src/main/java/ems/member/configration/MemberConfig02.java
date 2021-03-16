package ems.member.configration;

import ems.member.DataBaseConnectionInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig02 {
    @Bean
    public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
        DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
        infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        infoDev.setUserId("scott");
        infoDev.setUserPw("tiger");

        return infoDev;
    }

    @Bean
    public DataBaseConnectionInfo dataBaseConnectionInfoReal() {
        DataBaseConnectionInfo infoReal = new DataBaseConnectionInfo();
        infoReal.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
        infoReal.setUserId("masterid");
        infoReal.setUserPw("masterpw");

        return infoReal;
    }
}