package ems.member.configration;

import ems.member.DataBaseConnectionInfo;
import ems.member.service.EMSInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MemberConfig03 {
    @Autowired
    DataBaseConnectionInfo dataBaseConnectionInfoDev;

    @Autowired
    DataBaseConnectionInfo dataBaseConnectionInfoReal;

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
            put("dev", dataBaseConnectionInfoDev);
            put("real", dataBaseConnectionInfoReal);
        }};
        info.setDbInfos(dbInfos);

        return info;
    }
}