public enum Games {
    MINECRAFT("Minecraft", 8, 9,"PLAYSTATION5", "SAMSUNG"),
    FIFA("FIFA", 2, 1,"PLAYSTATION5", "HP"),
    COD("Call of Duty", 3, 4,"NINTENDOSWITCH", "ASUS"),
    PES("Pro Evolution Soccer", 1, 2,"XBOX", "DELL"),
    GOW("God of War", 4, 3,"XBOX", "SAMSUNG"),
    FORZA("Forza Horizon", 5, 6,"PLAYSTATION5", "DELL"),
    RDR("Read Dead Redemption", 6, 5,"NINTENDOSWITCH", "HP"),
    MARIO("Super Mario", 7, 3, "XBOX", "ASUS"),
    FORTNITE("Fortnite", 9, 8, "NINTENDOSWITCH", "DELL");
    
    public final String label;
    public final int postN1;
    public final int postN2;
    public final boolean reserved; // true if reserved
    public final String console; // XBOX, PLAYSTATION5, NINTENDOSWITCH
    public final String screen; // Screen 1, Screen 2, Screen 3, Screen 4, Screen 5, Screen 6, Screen 7, Screen 8, Screen 9

    Games(String label, int postN1, int postN2, String console, String screen) {
        this.label = label;
        this.postN1 = postN1;
        this.postN2 = postN2;
        this.reserved = false;
        this.console = console;
        this.screen = screen;
    }
}

