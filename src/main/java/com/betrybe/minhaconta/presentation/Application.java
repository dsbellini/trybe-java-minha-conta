package com.betrybe.minhaconta.presentation;

import com.betrybe.minhaconta.business.EnergyAccount;
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
   * Constructor that instantiates a new Application.
   *
   * @param ui the ui
   */
  public Application(ConsoleUserInterface ui) {
    this.ui = ui;
    this.api = new LightDealerApi();
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
    Client client = new Client();
    ui.fillClientData(client);
    api.addClient(client);
  }

  /**
   * Req. 7 – Register client address.
   */
  public void registerClientAddress() {
  }

  /**
   * Req. 8 – Register address devices.
   */
  public void registerAddressDevices() {
  }

  /**
   * Req. 9 – Estimates the address energy bill.
   */
  public void estimateAddressBill() {
  }

  /**
   * Req. 10 – Optimizes the energy bill.
   */
  public void optimizeEnergyBill() {
  }

  /**
   * Req 10 - Aux. Method to display high consumptions devices.
   *
   * @param energyAccount the energy account
   */
  public void suggestReducedUsage(EnergyAccount energyAccount) {
  }
}
