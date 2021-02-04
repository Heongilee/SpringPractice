package Pjt210204_03.toy;

import Pjt210204_03.battery.Battery;

public class ElectronicRobotToy {
  private Battery battery;

  public ElectronicRobotToy() {
  }

  public void setBattery(Battery battery) {
    this.battery = battery;
  }
  
}
///////////////////////////// DI 유형 2 /////////////////////////////////
// (배터리)부품이 없는 상태로 생산되며, 필요할 경우 기능(배터리)주입이 가능하다.
//
///////////////////////////////////////////////////////////////////////
