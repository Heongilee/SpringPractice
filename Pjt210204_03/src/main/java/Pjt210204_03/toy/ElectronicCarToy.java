package Pjt210204_03.toy;

import Pjt210204_03.battery.Battery;
import Pjt210204_03.battery.NormalBattery;

public class ElectronicCarToy {
  private Battery battery;

  public ElectronicCarToy() {
    battery = new NormalBattery();
  }
  
}
///////////////////////////// DI 유형 1 /////////////////////////////////
// 공장에서 완제품을 생산하기 때문에, 배터리를 새로 필요로 할 경우 다시 인스턴스 생성을 해야한다.
//
///////////////////////////////////////////////////////////////////////
