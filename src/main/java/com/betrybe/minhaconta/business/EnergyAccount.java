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
    ElectronicDevice[] highConsumptionDevicesList = new ElectronicDevice[allAddresses.length];

    int index = 0;

    for (Address address : allAddresses) {
      ElectronicDevice[] devices = address.getDevicesAsArray();

      if (devices.length > 0) {  // Verifica se há dispositivos antes de procurar o de maior consumo
        ElectronicDevice maxDevice = devices[0];

        for (ElectronicDevice device : devices) {
          if (device.monthlyKwh() > maxDevice.monthlyKwh()) {
            maxDevice = device;
          }
        }
        highConsumptionDevicesList[index] = maxDevice;
      }
      index++;
    }
    return highConsumptionDevicesList;
  }


}
