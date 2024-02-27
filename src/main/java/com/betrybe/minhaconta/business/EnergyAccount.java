package com.betrybe.minhaconta.business;

import com.ions.lightdealer.sdk.model.Address;
import com.ions.lightdealer.sdk.model.Client;
import com.ions.lightdealer.sdk.model.ElectronicDevice;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Energy account.
 */
public class EnergyAccount {

  Client client;

  public EnergyAccount(Client client) {
    this.client = client;
  }

  /**
   * Req. 11 – Find high consumption device per address.
   */
  public ElectronicDevice[] findHighConsumptionDevices() {
    Address[] allAddresses = this.client.getAddressesAsArray();
    List<ElectronicDevice> highConsumptionDevicesList = new ArrayList<>();

    for (Address address : allAddresses) {
      ElectronicDevice[] devices = address.getDevicesAsArray();
      ElectronicDevice maxDevice = devices[0];
      for (ElectronicDevice device : devices) {
        if (device.monthlyKwh() > maxDevice.monthlyKwh()) {
          highConsumptionDevicesList.add(device);
        }
      }
    }
    return highConsumptionDevicesList.toArray(new ElectronicDevice[0]);
  }
}
