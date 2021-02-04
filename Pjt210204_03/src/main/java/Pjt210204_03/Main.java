package Pjt210204_03;

import Pjt210204_03.battery.ChargeBattery;
import Pjt210204_03.toy.ElectronicCarToy;
import Pjt210204_03.toy.ElectronicRobotToy;

public class Main {
  public static void main(String[] args) {
    ElectronicCarToy carToy = new ElectronicCarToy();
    
    ElectronicRobotToy robotToy = new ElectronicRobotToy();
    robotToy.setBattery(new ChargeBattery());
  }
}
