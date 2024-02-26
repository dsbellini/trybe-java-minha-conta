package com.betrybe.minhaconta.presentation;

import com.betrybe.minhaconta.business.EnergyAccount;
import com.betrybe.minhaconta.business.EnergyBill;
import com.ions.lightdealer.sdk.model.Address;
import com.ions.lightdealer.sdk.model.Client;
import com.ions.lightdealer.sdk.model.ElectronicDevice;
import com.ions.lightdealer.sdk.service.LightDealerApi;

/**
 * The type Application.
 */
public class Application {

  /**
   * The Ui.
   */
  ConsoleUserInterface ui;
  /**
   * The Api.
   */
  LightDealerApi api;

  /**
   * The Client.
   */
  Client client;

  /**
   * The Electronic device.
   */
  ElectronicDevice electronicDevice;


  /**
   * Constructor that instantiates a new Application.
   *
   * @param ui the ui
   */
  public Application(ConsoleUserInterface ui) {
    this.ui = ui;
    this.api = new LightDealerApi();
    this.client = new Client();
    this.electronicDevice = new ElectronicDevice();
  }

  /**
   * Req. 4 – Creates CLI menu.
   */
  public void run() {
    char optionSelected = '0';
    while (optionSelected != '6') {
      String[] optionsMenu;
      optionsMenu = new String[]{
          "1 - Cadastrar cliente",
          "2 - Cadastrar imóvel de cliente",
          "3 - Cadastrar dispositivos em imóvel",
          "4 - Estimar conta de imóvel",
          "5 - Otimizar uso de energia",
          "6 - Sair"
      };

      optionSelected = ui.inputMenuOption(optionsMenu);
      runOptionAction(optionSelected);
    }
  }

  /**
   * Req. 5 – Run menu options.
   *
   * @param option the option
   */
  public void runOptionAction(char option) {
    switch (option) {
      case '1':
        registerClient();
        break;
      case '2':
        registerClientAddress();
        break;
      case '3':
        registerAddressDevices();
        break;
      case '4':
        estimateAddressBill();
        break;
      case '5':
        optimizeEnergyBill();
        break;
      case '6':
        ui.showMessage("Volte sempre!");
        break;
      default:
        ui.showMessage("Opção inválida!");
    }
  }

  /**
   * Req. 6 – Register client.
   */
  public void registerClient() {
    ui.fillClientData(this.client);
    api.addClient(this.client);
  }

  /**
   * Req. 7 – Register client address.
   */
  public void registerClientAddress() {
    String clientCpf = ui.inputClientCpf();
    Client searchClient = api.findClient(clientCpf);
    if (searchClient == null) {
      ui.showMessage("Pessoa cliente não encontrada!");
    }
    Address clientAddress = new Address();
    ui.fillAddressData(clientAddress);
    api.addAddressToClient(clientAddress, searchClient);
  }

  /**
   * Req. 8 – Register address devices.
   */
  public void registerAddressDevices() {
    String houseRegistration = ui.inputAddressRegistration();
    Address address = api.findAddress(houseRegistration);
    if (address == null) {
      ui.showMessage("Endereço não encontrado!");
    }
    int devices = ui.inputNumberOfDevices();
    for (int index = 0; index < devices; index++) {
      ui.fillDeviceData(electronicDevice);
      api.addDeviceToAddress(electronicDevice, address);
    }
  }

  /**
   * Req. 9 – Estimates the address energy bill.
   */
  public void estimateAddressBill() {
    String houseRegistration = ui.inputAddressRegistration();
    Address address = api.findAddress(houseRegistration);
    if (address == null) {
      ui.showMessage("Endereço não encontrado!");
    }
    EnergyBill energyBill = new EnergyBill(address, true);
    System.out.println("Valor estimado para a conta: " + energyBill.estimate());
  }

  /**
   * Req. 10 – Optimizes the energy bill.
   */
  public void optimizeEnergyBill() {
    String clientCpf = ui.inputClientCpf();
    Client client = api.findClient(clientCpf);
    if (client == null) {
      ui.showMessage("Pessoa cliente não encontrada!");
    }
    EnergyAccount energyAccount = new EnergyAccount(client);
    suggestReducedUsage(energyAccount);
  }

  /**
   * Req 10 - Aux. Method to display high consumptions devices.
   *
   * @param energyAccount the energy account
   */
  public void suggestReducedUsage(EnergyAccount energyAccount) {
    ElectronicDevice[] highConsume = energyAccount.findHighConsumptionDevices();
    ui.showMessage("Considere reduzir o uso dos seguintes dispositivos:");
    for (ElectronicDevice device : highConsume) {
      ui.showMessage(device.getName());
    }
  }
}
