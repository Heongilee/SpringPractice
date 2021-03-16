package ems.member.configration;

import ems.member.DataBaseConnectionInfo;
import ems.member.dao.StudentDao;
import ems.member.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MemberConfig {
    //<bean id="studentDao" class="ems.member.dao.StudentDao" ></bean>
    @Bean
    public StudentDao studentDao() {
        return new StudentDao();
    }

    @Bean
    public StudentRegisterService registerService() {
        return new StudentRegisterService(studentDao());
    }

    @Bean
    public StudentModifyService modifyService() {
        return new StudentModifyService(studentDao());
    }

    @Bean
    public StudentDeleteService deleteService() {
        return new StudentDeleteService(studentDao());
    }

    @Bean
    public StudentSelectService selectService() {
        return new StudentSelectService(studentDao());
    }

    @Bean
    public StudentAllSelectService allSelectService() {
        return new StudentAllSelectService(studentDao());
    }

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

    @Bean
    public EMSInformationService informationService() {
        EMSInformationService info = new EMSInformationService();
        info.setInfo("Education Management System program was developed in 2015.");
        info.setCopyRight("COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
        info.setVer("The version is 1.0");
        info.setsYear(2015);
        info.setsMonth(1);
        info.setsDay(1);
        info.seteYear(2015);
        info.seteMonth(2);
        info.seteDay(28);

        String[] data = {"Cheney.", "Eloy.", "Jasper.", "Dillon.", "Kian."};
        ArrayList<String> developers = new ArrayList<String>(Arrays.asList(data));
        info.setDevelopers(developers);

        Map<String, String> administrators = new HashMap<String, String>(){{
            put("Cheney", "cheney@springPjt.org");
            put("Jasper", "jasper@springPjt.org");
        }};
        info.setAdministrators(administrators);

        Map<String, DataBaseConnectionInfo> dbInfos = new HashMap<String, DataBaseConnectionInfo>(){{
            put("dev", dataBaseConnectionInfoDev());
            put("real", dataBaseConnectionInfoReal());
        }};
        info.setDbInfos(dbInfos);

        return info;
    }
}