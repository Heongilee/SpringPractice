package Pjt210204_03.toy;

import Pjt210204_03.battery.Battery;

public class ElectronicRadioToy {
  private Battery battery;

  public ElectronicRadioToy(Battery battery) {
    this.battery = battery;
  }

  public void setBattery(Battery battery) {
    this.battery = battery;
  }
    
}
///////////////////////////// DI 유형 3 /////////////////////////////////
//(배터리)부품이 부착된 상태로 생산되며, 필요할 경우 유연하게 기능(배터리)주입이 가능하다.
//
///////////////////////////////////////////////////////////////////////
