package com.betrybe.minhaconta.business;

import com.ions.lightdealer.sdk.model.Address;
import com.ions.lightdealer.sdk.model.ElectronicDevice;

/**
 * The type Energy bill.
 */
public class EnergyBill {
  // Req. 1 – Create class constructor and attributes.

  /**
   * The Address.
   */
  Address address;
  /**
   * The Residential plan.
   */
  boolean residentialPlan;
  /**
   * The Rate.
   */
  double rate = 0.15;

  /**
   * Instantiates a new Energy bill.
   *
   * @param address         the address
   * @param residentialPlan the residential plan
   */
  public EnergyBill(Address address, boolean residentialPlan) {
    this.address = address;
    this.residentialPlan = residentialPlan;
  }

  /**
   * Req. 2 – Calculates an adjusted tariff for non-residential plans.
   *
   * @param value the value
   * @return the double
   */
  public double adjustedTariff(double value) {
    if (!residentialPlan) {
      return value * 1.1;
    }
    return value;
  }

  /**
   * Req. 3 – Calculates the total usage of a collection of devices.
   *
   * @param devices the devices
   * @return the int
   */
  public static int calculateTotalUsage(ElectronicDevice[] devices) {
    int total = 0;
    for (ElectronicDevice device : devices) {
      total += (int) device.monthlyKwh();
    }
    return total;
  }

  /**
   * deop Aux. Method that estimates the energy bill value.
   *
   * @return the double
   */
  public double estimate() {
    double value = calculateTotalUsage(address.getDevicesAsArray()) * rate;

    return adjustedTariff(value);
  }
}
