package window.components;

import javafx.scene.control.Button;
import util.FTCEnum;
import window.components.actions.Actions;

import java.util.Map;

public final class Buttons {

    private Button installButton = new Button("Install");
    private Button browseButton = new Button("Browse");
    private Button settingsButton = new Button("Settings");
    private Button launchButton = new Button("Launch");
    private Button discordButton = new Button("Discord");
    private Button patreonButton = new Button("Patreon");
    private Button websiteButton = new Button("Website");

    private InstanceList instanceList;

    public Buttons(InstanceList instanceList){
        this.instanceList = instanceList;

        installButtonInit();
        browseButtonInit();
        settingsButtonInit();
        launchButtonInit();
        discordButtonInit();
        patreonButtonInit();
        websiteButtonInit();
    }

    private void websiteButtonInit() {
    }

    private void patreonButtonInit() {
    }

    private void discordButtonInit() {
    }

    private void launchButtonInit() {
    }

    private void settingsButtonInit() {
    }

    private void browseButtonInit() {
        browseButton.setPrefSize((double)FTCEnum.screenProperties.get(FTCEnum.ScreenInfo.WIDTH.getScreenString())/7,
                (double)FTCEnum.screenProperties.get(FTCEnum.ScreenInfo.HEIGHT.getScreenString())/5);
        browseButton.setOnAction(Actions.browseButtonAction());
    }

    private void installButtonInit() {
        installButton.setPrefSize((double)FTCEnum.screenProperties.get(FTCEnum.ScreenInfo.WIDTH.getScreenString())/7,
                (double)FTCEnum.screenProperties.get(FTCEnum.ScreenInfo.HEIGHT.getScreenString())/5);
        installButton.setOnAction(Actions.installButtonAction(instanceList));
    }

    public Button getInstallButton() {
        return installButton;
    }

    public void setInstallButton(Button installButton) {
        this.installButton = installButton;
    }

    public Button getBrowseButton() {
        return browseButton;
    }

    public void setBrowseButton(Button browseButton) {
        this.browseButton = browseButton;
    }

    public Button getSettingsButton() {
        return settingsButton;
    }

    public void setSettingsButton(Button settingsButton) {
        this.settingsButton = settingsButton;
    }

    public Button getLaunchButton() {
        return launchButton;
    }

    public void setLaunchButton(Button launchButton) {
        this.launchButton = launchButton;
    }

    public Button getDiscordButton() {
        return discordButton;
    }

    public void setDiscordButton(Button discordButton) {
        this.discordButton = discordButton;
    }

    public Button getPatreonButton() {
        return patreonButton;
    }

    public void setPatreonButton(Button patreonButton) {
        this.patreonButton = patreonButton;
    }

    public Button getWebsiteButton() {
        return websiteButton;
    }

    public void setWebsiteButton(Button websiteButton) {
        this.websiteButton = websiteButton;
    }

}
